/**
 *
 * A SportCompetition is an event that in addition has the following:
 * The number of activitie (int type) and season name (enumeration type that can be: summer, fall, winter, spring)
 * 
 * */

package Pack4;

import Pack1.Event;


public class SportCompetition extends Event
{
    private int nbAct;
    public enum Type {summer, fall, winter, spring};
    private Type season;

    //default constructor
    public SportCompetition()
    {
        super();
        nbAct = 0;
        season = null;
    }

    //copy constructor
    public SportCompetition(SportCompetition x)
    {
        setYear(x.getYear());
        setMonth(x.getMonth());
        setNbCities(x.getNbCities());
        nbAct = x.nbAct;
        season = x.season;
    }

    //parameterized constructor

    public SportCompetition(int year, int month, int nbCities, int nbAct, Type season)
    {
        super(year, month, nbCities);
        this.nbAct = nbAct;
        this.season = season;
    }

    //Private int nbAct setters and getters
    public int getNbAct() {
        return nbAct;
    }

    public void setNbAct(int nbAct)
    {
        this.nbAct = nbAct;
    }

    //Private Type  setters and getters
    public Type getSeason()
    {
        return season;
    }

    public void setSeason(Type season)
    {
        this.season = season;
    }

    public String toString()
    {
        return ("This " + super.toString() + " and there will be " + nbAct + " activities during the " + season);
    }

    public boolean equals(Object o)
    {

        if (o == null || this == null || !(o instanceof Event))
            return false;
        else
        {
            SportCompetition s = (SportCompetition) o;
            return (this.getYear() == s.getYear() && this.getMonth() == s.getMonth() && this.getNbCities() == s.getNbCities() && this.nbAct == s.nbAct && this.season.equals(s.season));
        }
    }
}
