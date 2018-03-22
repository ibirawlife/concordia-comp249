/**
 *
 * A Festival is an Event that in addition has the following: a name (String type- such as Arts, Beer,Comedy, Film, Fire, Folk...etc), ticket price (double type), and duration:# of_days (int type).
 * 
 * */

package Pack3;

import Pack1.Event;

public class Festival extends Event
{

    private String name;
    private double ticketPrice;
    private int nbDays;

    //default constructor
    public Festival()
    {
        super();
        name = null;
        ticketPrice = 0;
        nbDays = 0;
    }

    //copy constructor
    public Festival(Festival x)
    {
        setYear(x.getYear());
        setMonth(x.getMonth());
        setNbCities(x.getNbCities());
        name = x.name;
        ticketPrice = x.ticketPrice;
        nbDays = x.nbDays;
    }

    //parameterized constructor
    public Festival(String name, double ticketPrice, int nbDays, int year, int month, int nbCities)
    {
        super(year, month, nbCities);
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.nbDays = nbDays;
    }

    //Private String name setters and getters
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    //Private double ticketPrice setters and getters
    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }

    //Private int nbDays setters and getters
    public void setNbDays(int nbDays)
    {
        this.nbDays = nbDays;
    }

    public int getNbDays()
    {
        return nbDays;
    }

    public String toString()
    {
        return ("This " + name + " " + super.toString() + ", for " + nbDays + " days, the ticket will cost " + ticketPrice +"$");
    }

    // equals() method
    public boolean equals(Object o)
    {
        if (o == null || this == null || !(o instanceof Festival))
            return false;
        else
            {
                Festival f = (Festival) o;
                return (this.getYear() == f.getYear() && this.getMonth() == f.getMonth() && this.getNbCities() == f.getNbCities() && name.equals(f.name) && this.ticketPrice == f.ticketPrice && this.nbDays == f.nbDays);

            }
    }

}
