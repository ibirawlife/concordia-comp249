
/**
 *
 * Purpose: We created a tool (BibCreator) that will read and process 10 input files (in one execution).
 * Out of it, the program will create 3 different files with the correct references formats for IEEE, ACM and NJ
 * This assignment will allow us to practice Exception Handling, file I/O and other previous OOP concepts.
 *
 * */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;

public class BibCreator
{
    /**
     * This method reads every single line from the file and then displays them on the screen
     * @param inputFileStream is the passed BufferedReader (stream class) that will be used to read our output files
     * @throws IOException throws any input or output exceptions thats declared by the method
     */
    // A method that reads the files and prints out the content on the screen
    // The method also declares an IOException
    public static void displayFileNameContents(BufferedReader inputFileStream) throws IOException
    {
        String s;
        s = inputFileStream.readLine();
        while (s != null)
        {
            System.out.println(s);
            s = inputFileStream.readLine();
        }
    }
    /**
     * This method reads through the input files and looks for the lines that contains "={}"
     * If the method finds a line with an empty field, it throws the FileInvalidException, increments the invalidFiles integer value and returns the value 1
     * If the input file is NOT invalid, then the program will proceed.
     * The method will continue by counting the number of articles in the file (it will go through the input files and looks for the lines that contains "@ARTICLE")
     * If the method finds "@ARTICLE" within the input files, it will increment the counter
     * Then, with a Content Extraction Mechanism, the program will extract the content out of the lines that it reads
     * And finally, the method will write inside the empty output files, respecting the format corresponding to each output files
     * @param fileInputStream is the passed Scanner (stream class) that will be used to read our Latex files
     * @param fileOutputStream1 is the passed PrintWriter (stream class) that will be used to write in the output files (IEEE)
     * @param fileOutputStream2 is the passed PrintWriter (stream class) that will be used to write in the output files (NJ)
     * @param fileOutputStream3 is the passed PrintWriter (stream class) that will be used to write in the output files (ACM)
     * @param fileNum is a passed integer value that determines the file number
     * @param fileIEEE is the passed File object for the IEEE output files
     * @param fileACM is the passed File object for ACM output files
     * @param fileNJ is the passed File object for NJ output files
     * @return an integer value that determines whether or not the file is invalid
     */
    // A method that process the input files, returns 1 when they're found invalid or returns 0 if they're valid
    // Additionally, it prints the content of the input files into the output files
    // This method does not declare any exception, everything is handle within the method
    public static int processFilesForValidation(Scanner fileInputStream, PrintWriter fileOutputStream1, PrintWriter fileOutputStream2, PrintWriter fileOutputStream3, int fileNum ,File fileIEEE ,File fileACM ,File fileNJ)
    {
        int articleNum = 0;
        int invalidFiles = 0;
        String emptyField;
        String author = null;
        String title = null;
        String journal = null;
        String volume = null;
        String pages = null;
        String month = null;
        String year = null;
        String number = null;
        String doi = null;

        try
        {
            // Checks if there's a line to read
            while (fileInputStream.hasNextLine())
            {
                // Reads the line and stores the line in a string
                String s = fileInputStream.nextLine();
                if (s.contains("={}"))
                {
                    emptyField = s.substring(0, s.indexOf('='));
                    // Deletion of the output files created
                    fileIEEE.delete();
                    fileACM.delete();
                    fileNJ.delete();
                    System.out.println("Files deleted");
                    // When one empty field is found, the file is categorized as invalid
                    // So an exception is thrown
                    throw new FileInvalidException(emptyField , fileNum);
                }
                // Else if no empty field is found, the program will proceed with the following
                // First, the detection of "@ARTICLE" and then the incrementation for each article found
                // Second, the Content Extraction Mechanism, which extracts the content of most of the fields (Everything up to the opening curly bracket and the curly bracket will be taken out and everything after the closing curly bracket and the curly bracket will be taken out)
                if (s.contains("@ARTICLE{"))
                {
                    articleNum++;
                }
                if (s.indexOf("author={") == 0)
                {
                    author = s.replace("author={", "");
                    author = author.replace("}, ", "");
                }
                if (s.indexOf("title={") == 0)
                {
                    title = s.replace("title={", "");
                    title = title.replace("}, ", "");
                }
                if (s.indexOf("journal={") == 0)
                {
                    journal = s.replace("journal={", "");
                    journal = journal.replace("}, ", "");
                }
                if (s.indexOf("volume={") == 0)
                {
                    volume = s.replace("volume={", "");
                    volume = volume.replace("}, ", "");
                }
                if (s.indexOf("pages={") == 0)
                {
                    pages = s.replace("pages={", "");
                    pages = pages.replace("}, ", "");
                }
                if (s.indexOf("month={") == 0)
                {
                    month = s.replace("month={", "");
                    month = month.replace("},", "");
                }
                if (s.indexOf("year={") == 0)
                {
                    year = s.replace("year={", "");
                    year = year.replace("}, ", "");
                }
                if (s.indexOf("number={") == 0)
                {
                    number = s.replace("number={", "");
                    number = number.replace("}, ", "");
                }
                if (s.indexOf("doi={") == 0)
                {
                    doi = s.replace("doi={", "");
                    doi = doi.replace("}, ", "");
                }

                // Formats for the output files
                // IEEE Format
                if(s.indexOf("}") == 0)
                {
                    author = author.replace(" and ", ", ");
                    fileOutputStream1.println("\n" + author + ". " + "\"" + title + "\", " + journal + ", vol. " + volume + ", no. " + number + ", p. " + pages + ", " + month + " " + year + ".");
                    // NJ Format
                    author = author.replace(", ", " & ");
                    fileOutputStream2.println("\n" + author.replace(", ", " & ") + ". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").");
                    // ACM Format
                    if (author.contains("&"))
                    {
                        author = author.substring(0, author.indexOf(" &"));
                        fileOutputStream3.println("\n" + "[" + (articleNum) + "]   " + author + " et al. " + year + ". " + title + ". " + journal + ". " + volume + ", " + number + " (" + year + "), " + pages + ". DOI:HTTPS://doi.org/" + doi + ".");
                    }
                    else
                        {
                        author = author.substring(0, author.length()) ;
                        fileOutputStream3.println("\n" + "[" + (articleNum) + "]   " + author + year + ". " + title + ". " + journal + ". " + volume + ", " + number + " (" + year + "), " + pages + ". DOI:HTTPS://doi.org/" + doi + ".");
                        }
                }
            }

        }
        // Catch block for FileInvalidException
        // invalidFiles integer is incremented to 1, since the input file is found to be invalid
        catch(FileInvalidException e)
        {
            invalidFiles++;
        }
        // Since this method returns an integer, it returns 1 if the invalid or 0 if the file is valid
        return  invalidFiles;
    }
    /**
     /**
     * The main also know as the driver
     * @param args main
     */
    public static void main(String[] args)
    {
        Scanner mk = new Scanner(System.in); // Reads the inputs from the keyboard
        Scanner sc = null; // Read the input files
        PrintWriter pw1 = null; // Writes on the output files (IEEE)
        PrintWriter pw2 = null; // Writes on the output files (ACM)
        PrintWriter pw3 = null; // Writes on the output files (NJ)
        BufferedReader br = null; // Reads the input files
        int fileNum = 1; // Integer value used for the numeration of the files
        int totalValid; // Integer value used for the total number of valid files
        int totalInvalid = 0; // Integer value used for the total number of invalid files
        int totalFileInput = 10; // Integer value used for the total number of input text files
        String userNameOutputFile; // Name of the output file
        // Declaration of the variables for the File objects
        File userFile = null;
        File fileIEEE = null;
        File fileACM = null;
        File fileNJ = null;

        // PART 1 --- CREATION OF THE TOOL

        // Welcome message
        System.out.println("Welcome to BibCreator!\n");
        // The loop will keep looping until it goes through the 10 input files
        while (fileNum <= totalFileInput)
        {
            String fileName = null;

            fileName = "Latex" + fileNum + ".bib";
            System.out.println("FileName is assigned " + fileName);
            System.out.println("Latex " + fileNum + " Scanner Opened with " + fileName);
            try
            {
                // Opening of the scanner
                sc = new Scanner(new FileInputStream("Latex" + fileNum + ".bib"));
                // Opening of the the 3 PrintWriters
                pw1 = new PrintWriter(new FileOutputStream("IEEE" + fileNum + ".json", true));
                pw2 = new PrintWriter(new FileOutputStream("NJ" + fileNum + ".json", true));
                pw3 = new PrintWriter(new FileOutputStream("ACM" + fileNum + ".json",true));
            }
            // When the file cannot be opened or created, the exceptions thrown will be handled in this catch block
            // If there's more than one file in the directory,then the previously created files will be deleted. Thus, every file in the directory will be wiped, which will leave the directory empty.
            catch (FileNotFoundException e)
            {
                if (fileNum != 1)
                {
                    for (int i = 1; i < fileNum; i++)
                    {
                        // Checks if any IEEE files were previously created and then deletes them
                        fileIEEE = new File("IEEE" + i + ".json");
                        if (fileIEEE.exists())
                            fileIEEE.delete();
                        // Checks if any ACM files were previously created and then deletes them
                        fileACM = new File("ACM" + i + ".json");
                        if (fileACM.exists())
                            fileACM.delete();
                        // Checks if any NJ files were previously created and then deletes them
                        fileNJ = new File("NJ" + i + ".json");
                        if (fileNJ.exists())
                            fileNJ.delete();
                    }
                }

                System.out.println("Could not open input file Latex" + fileNum + " for reading. Please check if file exists.");
                System.out.print("Program will terminate.");
                System.exit(0);
            }
            // Creation of the three File objects
            fileIEEE = new File("IEEE"+fileNum+".json");
            fileACM = new File("ACM"+fileNum+".json");
            fileNJ = new File("NJ"+fileNum+".json");
            // Usage of the processFilesForValidation() method
            // The method returns 1 if the input file is determined to be invalid
            // When the method returns 1, it deletes the output files created and increments the integer of the total number of invalid files by 1
            if (processFilesForValidation(sc, pw1, pw2, pw3, fileNum, fileIEEE, fileACM, fileNJ) == 1)
            {
                fileIEEE.delete();
                fileACM.delete();
                fileNJ.delete();
                totalInvalid++;
            }
            // This Last step make sure that we close the Scanner and all the PrintWriters
            // It also increments the file number, so that the reading of the next input file can be started
            System.out.println("Latex " + fileNum + " Scanner Closed with " + fileName+"\n");
            sc.close();
            pw1.close();
            pw2.close();
            pw3.close();
            // Increments the file number
            fileNum++;
        }

        // Calculation of the total number of valid files
        totalValid = totalFileInput - totalInvalid;
        System.out.println("\nA total of "+totalInvalid+" files were invalid, and could not be processed. All other "+totalValid+" \"Valid\" files have been created.");

        // PART 2 --- USAGE OF THE TOOL

        int attempt=0; // numbers of attempts
        int maxAttempt = 2; // maximum number of attempt

        // The user will have two chances
        while(attempt<maxAttempt)
        {
            try

            {
                System.out.print("\nPlease enter the name of the file you want to read: ");
            userNameOutputFile = mk.nextLine(); // reads the input
            userFile = new File(userNameOutputFile +".json/"); // Creates a File object
            // If the file is in the directory, it will read the file with the BufferedReader
            if(userFile.exists())
            {
                br = new BufferedReader(new FileReader(userNameOutputFile + ".json"));
                System.out.println("BufferedReader opened for " + userNameOutputFile);
                System.out.println("-------------------------------------------------------");
                System.out.println("Here is now the content of the file : " + userNameOutputFile + "\n");
                // This method will read the file line by line and display the content on the screen
                displayFileNameContents(br);
                // Closing the BufferedReader
                br.close();
                System.out.println("\nBufferedReader closed for " + userNameOutputFile);
                // Closing message
                System.out.println("\nCiao amigo! Hope you had fun creating file with BibCreator!");
                // Closing the Scanner (reads from the keyboard)
                mk.close();
                break;
            }
            // If the file is not in the directory, the integer for the number of attempts will be incremented
            else
            {
                attempt++;
                if(attempt<2)
                {
                    System.out.println("You have one more chance!");
                }
                if(attempt==2)
                {
                    System.out.println("You have exhausted your chances!");
                }
            }
            }
        // If the file cannot be read from the BufferedReader then the exception will be caught by this block
        catch(FileNotFoundException e)
        {
            System.out.println("The file could not be opened! Cannot proceed to display.");
            System.out.println("The program will terminate");
            System.exit(0);
        }
        // This catch block will catch any other exceptions thrown by the BufferedReader
        catch (IOException e )
        {
            System.out.println("Error! Cannot display the content of the file");
            System.out.println("Program will be terminate");
            System.exit(0);
        }
        }
    }
