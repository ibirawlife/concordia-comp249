/**
 *
 * class containing driver
 *
 * */

/**
 *
 * import java scanner in order to take user input
 * 
 * */

import java.util.Scanner;

public class A1Q1
{
    public static void main (String[] args)
    {
        /**
         *
         * @param password to hold the password
         * @param totalAttempts to set limit of bad attempts in option 1
         * @param nbBooks to store the number of books entered by user
         * @param access which allows user to use program set to true
         *
         */
        final String password = "password";
        int totalAttempts = 12;
        int nbBooks = 0;
        boolean access = true;
        Scanner myKeyboard = new Scanner(System.in);
        /**
         *
         * welcome message
         * ask user for maximum capacity of his library and store int user input
         *
         */
        System.out.println("Welcome to Ibrahim Sidawis' library\n");
        System.out.print("What is your library's maximum capacity of books? >");
        int maxBooks = myKeyboard.nextInt();
        myKeyboard.nextLine();

        /**
         *
         * @param booksLeft calculates the amount of room left
         *
         */
        int booksLeft = (maxBooks - Book.findNumberOfCreatedBooks());

        /**
         *
         * new array of type Book of size given by user
         *
         */
        Book[] inventory = new Book[maxBooks];
        for(int i=0; i < inventory.length; i++ )
        {
            inventory[i] = new Book();
        }

        /**
         *
         * loop granting user access as long as the maximum attempts
         * of password tries allowed has not reached 0 or if user
         * wants to Quit
         *
         */
        while(access)
        {
            /**
             *
             * ask user for which option he would like to use and store user input
             *
             */
            System.out.print("\nWhat do you want to do?\n"
                    + "		1. Enter new books (password required)\n"
                    + "		2. Change information of a book (password required)\n"
                    + "		3. Display all books by a specific author\n"
                    + "		4. Display all books under a certain a price.\n"
                    + "		5. Quit\n"
                    + "Please enter your choice >");
            int option = myKeyboard.nextInt();
            myKeyboard.nextLine();

            /**
             *
             * switch takes option and goes to matching case
             *
             */
            switch(option)
            {
                case 1:
                {
                    /**
                     *
                     * if he reached the limit of tries allowed, notify user,
                     * set access to false and break
                     *
                     */
                    if(totalAttempts == 0)
                    {
                        System.out.print("Program detected suspicious activities and will terminate immediately!");
                        access = false;
                        break;
                    }
                    /**
                     *
                     * else
                     *
                     */
                    else
                    {
                        /**
                         *
                         * loop checking for incorrect password entries
                         *
                         */
                        for(int i=0; i < 3; i++)
                        {
                            /**
                             *
                             * ask user for password and store users input
                             *
                             */
                            System.out.print("	Please enter your password >");
                            String input = myKeyboard.nextLine();

                            /**
                             *
                             * if statement checking if input matches String password
                             *
                             */
                            if(input.equals(password))
                            {
                                /**
                                 *
                                 * do while loop asks user for the number of books
                                 * to enter and corrects incorrect input by informing
                                 * user
                                 *
                                 */
                                do
                                {
                                    System.out.print("\nHow many books would you like to enter? >");
                                    nbBooks = myKeyboard.nextInt();
                                    myKeyboard.nextLine();

                                    if(nbBooks > booksLeft)
                                        System.out.println("You can only enter " + booksLeft + " or less.");
                                }
                                while(nbBooks > booksLeft);

                                /**
                                 *
                                 * loop storing user input in appropriate variables
                                 * of the book increment number of books created at
                                 * the end
                                 *
                                 */
                                for(int j=0; j < nbBooks; j++)
                                {
                                    System.out.print("Please enter book title >");
                                    inventory[Book.findNumberOfCreatedBooks()].setTitle(myKeyboard.nextLine());
                                    System.out.print("Please enter book author >");
                                    inventory[Book.findNumberOfCreatedBooks()].setAuthor(myKeyboard.nextLine());
                                    System.out.print("Please enter book ISBN >");
                                    inventory[Book.findNumberOfCreatedBooks()].setISBN(myKeyboard.nextLong());
                                    System.out.print("Please enter book price >");
                                    inventory[Book.findNumberOfCreatedBooks()].setPrice(myKeyboard.nextDouble());
                                    myKeyboard.nextLine();
                                    Book.addBook();

                                }

                                /**
                                 *
                                 * exits for loop
                                 *
                                 */
                                i = 3;
                            }
                            /**
                             *
                             * else decrement the number of total attempts of user
                             *
                             */
                            else
                            {
                                totalAttempts--;
                            }
                        }
                    }
                    /**
                     *
                     * break statement to exit case 1
                     *
                     */
                    break;
                }

                case 2:
                {
                    /**
                     *
                     * loop checking for incorrect password entries
                     *
                     */
                    for(int i=0; i < 3;i++)
                    {
                        /**
                         *
                         * ask user for password and store users input
                         *
                         */
                        System.out.print("	Please enter your password >");
                        String input = myKeyboard.nextLine();

                        /**
                         *
                         * if passwords match
                         *
                         */
                        if(input.equals(password))
                        {
                            /**
                             *
                             * ask user for book number to update starting at index 0 and store users input
                             *
                             */
                            System.out.print("\nWhich book number would you like to update? (0 being the first book) >");
                            int bookToUpdate = myKeyboard.nextInt();
                            myKeyboard.nextLine();


                            int choice = 1;
                            /**
                             *
                             * while loop checking that the user inputs
                             * an existing book number and asks him
                             * if he would like to re-enter or exit
                             * by setting outer for loop parameter to 3
                             *
                             */
                            while(choice == 1)
                            {
                                if(bookToUpdate >= Book.findNumberOfCreatedBooks() || bookToUpdate < 0)
                                {
                                    System.out.print("\nThat book doesn't exist! Would you like to try again? (Enter 1 for yes - Enter 2 for no) >");
                                    choice = myKeyboard.nextInt();
                                    if(choice == 1)
                                    {
                                        System.out.print("Which book number would you like to update? >");
                                        bookToUpdate = myKeyboard.nextInt();
                                        myKeyboard.nextLine();
                                    }
                                    else
                                        i = 3;
                                }
                                else
                                    choice = 2;
                            }
                            /**
                             *
                             * if statement checking user wishes to update
                             * and displays book information before modification
                             *
                             */
                            if(choice == 2)
                            {
                                System.out.println("\nBook # " + bookToUpdate);
                                System.out.println("Author: " + inventory[bookToUpdate].getAuthor());
                                System.out.println("Title: " + inventory[bookToUpdate].getTitle());
                                System.out.println("ISBN: " + inventory[bookToUpdate].getISBN());
                                System.out.println("Price: $" + inventory[bookToUpdate].getPrice());
                                int attribute;

                                /**
                                 *
                                 * do while loop allows user to update all
                                 * attributes until he wants to quit using
                                 * a switch taking user input and asking
                                 * the matching question to change value
                                 * of variable
                                 *
                                 */
                                do
                                {
                                    System.out.println("\nWhat information would you like to change?"
                                            + "\n	1. author"
                                            + "\n	2. title"
                                            + "\n	3. ISBN"
                                            + "\n	4. price"
                                            + "\n	5. Quit"
                                            + "\nEnter your choice >");
                                    attribute = myKeyboard.nextInt();
                                    myKeyboard.nextLine();
                                    switch(attribute)
                                    {
                                        case 1:
                                            System.out.print("\nPlease enter the new author >");
                                            inventory[bookToUpdate].setAuthor(myKeyboard.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("\nPlease enter the new title >");
                                            inventory[bookToUpdate].setTitle(myKeyboard.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("\nPlease enter the new ISBN >");
                                            inventory[bookToUpdate].setISBN(myKeyboard.nextLong());
                                            break;
                                        case 4:
                                            System.out.print("\nPlease enter the new price >");
                                            inventory[bookToUpdate].setPrice(myKeyboard.nextDouble());
                                            myKeyboard.nextLine();
                                            break;
                                        case 5:
                                            break;
                                    }
                                }
                                while(attribute != 5);

                                /**
                                 *
                                 * display updated book information
                                 *
                                 */
                                System.out.print(inventory[bookToUpdate] + " has been updated");
                                i = 3;
                            }
                        }
                    }
                    /**
                     *
                     * break to exit case 2
                     *
                     */
                    break;
                }

                case 3:
                {
                    /**
                     *
                     * ask user which author he would like to search for
                     * author to store user input
                     * for loop checking if such a book exists in inventory
                     * and displays if it does or not
                     *
                     */
                    System.out.print("\nWhich author would you like to search for? >");
                    String author = myKeyboard.nextLine();
                    for(int i=0; i < inventory.length; i++)
                    {
                        if(inventory[i].getAuthor().equalsIgnoreCase(author))//
                            System.out.println(inventory[i]);
                        else
                            System.out.print("Sorry there are no books with that author name!");
                    }
                    break;
                }

                case 4:
                {
                    /**
                     *
                     *  ask user for the price and store user input
                     * for loop searching for books cheaper than price
                     *
                     */
                    System.out.print("Please enter the price >");
                    double price = myKeyboard.nextDouble();
                    myKeyboard.nextLine();
                    for(int i=0; i<inventory.length; i++)
                    {
                        if(inventory[i].getPrice() < price)
                        {
                            System.out.print(inventory[i]);
                            System.out.println();
                        }
                    }
                    break;
                }

                case 5:
                    /**
                     *
                     * displayexit message
                     * set access to false to exit
                     *
                     */
                    System.out.print("\nExiting Program");
                    access = false;
                    break;

                /**
                 *
                 * inform user of invalid input
                 *
                 */
                default:
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
            System.out.println();
        }
        /**
         *
         * stop looking for user input
         *
         */
        myKeyboard.close();
    }
}



					
	