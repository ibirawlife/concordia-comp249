/**
 *
 * An Event class with the following:
 * the year (XXXX: int type),
 * month (YY:int type),
 * and the number of cities where it will be held (int type).
 * We changed the attributes values to private in other to reinforce their privacy
 * Trade-off: We must ease accessors and getters in order to retrieve the value of the attributes created in a different class
 * 
 * */

package Pack1;

public class Event
{

    private int year;
    private int month;
    private int nbCities;
    static int mostCities = 0;
    static int leastCities = 10;

    //default constructor
    public Event()
    {
        year = 0;
        month = 0;
        nbCities = 0;
    }

    //copy constructor
    public Event(Event x)
    {
        year = x.year;
        month = x.month;
        nbCities = x.nbCities;
    }

    //parameterized constructor
    public Event(int year, int month, int nbCities)
    {
        this.year = year;
        this.month = month;
        this.nbCities = nbCities;
    }

    //Private int year setters and getters
    public void setYear(int year)
    {
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }

    //Private int month setters and getters
    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getMonth()
    {
        return month;
    }

    //Private int nbCities setters and getters
    public void setNbCities(int nbCities)
    {
        this.nbCities = nbCities;
    }

    public int getNbCities()
    {
        return nbCities;
    }

    //static int mostCities setters and getters
    public static int getMostCities()
    {
        return mostCities;
    }

    public static void setMostCities(int mostCities)
    {
        Event.mostCities = mostCities;
    }

    //static int leastCities setters and getters
    public static int getLeastCities()
    {
        return leastCities;
    }

    public static void setLeastCities(int leastCities)
    {
        Event.leastCities = leastCities;
    }

    //toString() method
    public String toString()
    {
        String s = this.getClass().toString();
        s = s.substring(12);
        return (s + " will be held in " + year + ", " + month + " in " + nbCities + " cities");
    }

    // equals() method
    public boolean equals(Object o)
    {

        if (o == null || this == null || !(o instanceof Event))
            return false;
        else
            {
                Event e = (Event) o;
                return (this.year == e.year && this.month == e.month && this.nbCities == e.nbCities);
            }
    }

}
