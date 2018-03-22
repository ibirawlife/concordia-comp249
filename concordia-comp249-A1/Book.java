/**
 *
 * class named book
 * 
 * */

public class Book 				
{
    /**
     *
     * private variables created to store book info and keep count of books created
     *
     * */
    private String title;
    private String author;
    private long ISBN;
    private double price;
    private static int numberOfCreatedBooks = 0;

    /**
     *
     * Default constructor
     *
     */
    public Book()
    {
        title = "";
        author = "";
        ISBN = 0;
        price = 0;
    }

    /**
     *
     * Constructor taking in four parameters
     * @param title
     * @param author
     * @param ISBN
     * @param price
     *
     */
    public Book(String title, String author, long ISBN, double price)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        numberOfCreatedBooks++;
    }

    /**
     *
     * Mutator method to set title
     * @param title
     *
     * */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     *
     * Accessor method to get title
     * @return String
     *
     * */
    public String getTitle()
    {
        return title;
    }

    /**
     *
     * Mutator method to set author
     * @param author
     *
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     *
     * Accessor method to get author
     * @return String
     *
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     *
     * Mutator method to set author
     * @param ISBN
     *
     */
    public void setISBN(long ISBN)
    {
        this.ISBN = ISBN;
    }

    /**
     *
     * Accessor method to get ISBN
     * @return long
     *
     * */
    public long getISBN()
    {
        return ISBN;
    }

    /**
     *
     * Mutator method to set price
     * @param price
     *
     * */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     *
     * @return double
     *
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * toString() method that outputs the
     * information about the book depending
     * on user input
     *
     * @return String
     *
     */
    public String toString()
    {
        return "The book: " + title + " written by " + author + " has an ISBN of " + ISBN + " and costs $" + price;
    }

    /**
     *
     * method to return number of books created
     * @return int
     *
     * */
    public static int findNumberOfCreatedBooks()
    {
        return numberOfCreatedBooks;
    }

    /**
     *
     * method that increments the number of books
     * after creation
     *
     * */
    public static void addBook()
    {
        numberOfCreatedBooks++;
    }

    /**
     *
     * method that checks if any books have the same ISBN or Price
     *
     * @param toCompare
     * @return boolean
     * */
    public boolean equals(Book toCompare)
    {
        if ((this.getISBN() == toCompare.getISBN()) || (this.getPrice() == toCompare.getPrice()))
            return true;
        else
            return false;
    }
}
