/**
 *
 * A Culturalfiesta is a Festival that in addition has the following: 
 * The number of spoken languages (int type), which indicates the maximum languages spoken in this kind of festival
 * 
 * */

package Pack3;

public class Culturalfiesta extends Festival
{

    private int nbSpokenLang;

    //default constructor
    public Culturalfiesta()
    {
        super();
        nbSpokenLang = 0;
    }

    //copy constructor
    public Culturalfiesta(Culturalfiesta x)
    {
        setYear(x.getYear());
        setMonth(x.getMonth());
        setNbCities(x.getNbCities());
        setName(x.getName());
        setTicketPrice(x.getTicketPrice());
        setNbDays(x.getNbDays());
        nbSpokenLang = x.nbSpokenLang;
    }

    //parameterized constructor
    public Culturalfiesta(int nbSpokenLang, String name, double ticketPrice, int nbDays, int year, int month, int nbCities)
    {
        super(name, ticketPrice, nbDays, year, month, nbCities);
        this.nbSpokenLang = nbSpokenLang;
    }

    //Private int nbSpokenLang setters and getters
    public void setNbSpokenLang(int nbSpokenLang)
    {
        this.nbSpokenLang = nbSpokenLang;
    }

    public int getNbSpokenLang()
    {
        return nbSpokenLang;
    }

    public String toString()
    {
        return (super.toString() + " and will be in " + nbSpokenLang + " spoken languages");
    }

    public boolean equals(Object o)
    {
        if (o == null || this == null || !(o instanceof Festival))
            return false;
        else
        {
            Culturalfiesta c = (Culturalfiesta) o;
            return (this.getYear() == c.getYear() && this.getMonth() == c.getMonth() && this.getMonth() == c.getMonth() && getName().equals(c.getName()) && this.getTicketPrice() == c.getTicketPrice() && this.getNbDays() == c.getNbDays() && this.nbSpokenLang == c.nbSpokenLang);

        }
    }
}
