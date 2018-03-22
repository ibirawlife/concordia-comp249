/*
 * 
 * This is the class file
 * This files will let us create FileInvalidException object
 * This class holds constructors for the creation of the object
 * If its invoked without parameter it will create a default object
 * If its invoked with parameters it will create a parameterized object
 * The class also holds a method that is originally inherited from the Exception class
 * 
 * */

public class FileInvalidException extends Exception
{

    private String nameField; // the name of the field in the article that is empty
    private  int numOfFile; // the number of the Latex file that is invalid


    public FileInvalidException ()
    {
        super("======================\nError: Detected empty field!\"");
    }

    /**
     *This is parameterized contains and they will be available to the objects
     * @param nameField is the name of the empty field in the article
     * @param numOfFile is the number of the Latex file
     */

    public FileInvalidException(String nameField, int numOfFile)
    {
        super(nameField);

        System.out.println("==================================\nError: Detected Empty field!\nProblem detected with input file: Latex"+numOfFile+".bib");
        System.out.println("File is invalid: field "+nameField+ " is empty. Processed stopped at this point. Other empty fields may be " +
                "present as well!");

    }

    /**
     * This method reaches for the getMessage() method
     * @return the getMessage() method from the Exception class
     */

    public String getMessage()
    {
        return (super.getMessage());
    }
}