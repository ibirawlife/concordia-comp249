/**
 *
 * A fair is an Event that in addition has the following:
 * The number of exibitors (int type), and type (enumerator type that can be : career, science, trade, travel)
 * 
 * */

package Pack2;

import Pack1.Event;

public class Fair extends Event
{
    private int nbExib;
    public enum typeName {career, science, trade, travel};
    private typeName type;

    //default constructor
    public Fair()
    {
        super();
        nbExib = 0;
        type = null;

    }

    //copy constructor
    public Fair(Fair x)
    {
        setYear(x.getYear());
        setMonth(x.getMonth());
        setNbCities(x.getNbCities());
        nbExib = x.nbExib;
        type = x.type;
    }

    //parameterized constructor
    public Fair(int year, int month, int nbCities, int nbExib, typeName type )
    {
        super(year, month, nbCities);
        this.nbExib = nbExib;
        this.type = type;
    }

    //Private int getNbExib setters and getters
    public int getNbExib()
    {
        return nbExib;
    }

    public void setNbExib(int nbExib)
    {
        this.nbExib = nbExib;
    }

    //Private typeName type setters and getters
    public typeName getType()
    {
        return type;
    }

    public void setType(typeName type)
    {
        this.type = type;
    }

    public String toString()
    {
        return ("This " + super.toString() + " and " + nbExib + " exibitors will be present during this " + type + " fair.");
    }

    public boolean equals(Object o)
    {

        if (o == null || this == null || !(o instanceof Event))
            return false;
        else
        {
            Fair f = (Fair) o;
            return (this.getYear() == f.getYear() && this.getMonth() == f.getMonth() && this.getNbCities() == f.getNbCities() && this.nbExib == f.nbExib && this.type.equals(f.type));
        }
    }
}
