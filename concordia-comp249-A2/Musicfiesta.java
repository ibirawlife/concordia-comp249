/** -------------------------------------------------------
 *
 * A Musicfiesta is a Festival that in addition it has the following: number of bands (int type).
 *
 */

package Pack3;

public class Musicfiesta extends Festival
{

    private int nbBands;

    //default constructor
    public Musicfiesta()
    {
        super();
        nbBands = 0;
    }

    //copy constructor
    public Musicfiesta(Musicfiesta x)
    {
        setYear(x.getYear());
        setMonth(x.getMonth());
        setNbCities(x.getNbCities());
        setName(x.getName());
        setTicketPrice(x.getTicketPrice());
        setNbDays(x.getNbDays());
        nbBands = x.nbBands;
    }

    //parameterized constructor
    public Musicfiesta(int nbBands, String name, double ticketPrice, int nbDays, int year, int month, int nbCities)
    {
        super(name, ticketPrice, nbDays, year, month, nbCities);
        this.nbBands = nbBands;
    }

    //Private int nbBands setters and getters
    public void setNbBands(int nbBands)
    {
        this.nbBands = nbBands;
    }

    public int getNbBands()
    {
        return nbBands;
    }

    //toString method
    public String toString()
    {
        return (super.toString() + " where " + nbBands + " will be performing");
    }

    public boolean equals(Object o)
    {
        if (o == null || this == null || !(o instanceof Festival))
            return false;
        else
        {
            Musicfiesta m = (Musicfiesta) o;
            return (this.getYear() == m.getYear() && this.getMonth() == m.getMonth() && this.getNbCities() == m.getNbCities() && getName().equals(m.getName()) && this.getTicketPrice() == m.getTicketPrice() && this.getNbDays() == m.getNbDays() && this.nbBands == m.nbBands);

        }
    }
}
