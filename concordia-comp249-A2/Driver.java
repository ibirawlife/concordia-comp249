/**
 *
 * class containing driver
 *
 * */

import Pack1.Event;
import Pack2.Fair;
import Pack3.Festival;
import Pack3.Musicfiesta;
import Pack3.Culturalfiesta;
import Pack4.SportCompetition;

public class Driver
{
    // The method will take as input an array of Event (an array of any size) and returns an array of Event.
    // That is to say, the method needs to create an array of the same length as the passed parameter one,
    // copy all Festival from the passed array to a new array then return it.
    // The copy of the objects must use the copy constructors of the different listed classes.
    public static Event[] copyFestival(Event[] x)
    {
        Event[] eventCopy = new Event[x.length];
        for(int i=0; i<eventCopy.length; i++)
        {
            if(x[i] instanceof Festival)
            {
               eventCopy[i] = x[i];
            }
        }
        return (eventCopy);
    }

    public static void main (String [] args)
    {
        //create various objects from the 6 classes, and display all their information using the toString() method.
        Event event1 = new Event(2018,07, 9);
        Event event2 = new Event(2017,06, 5);
        Fair fair = new Fair(2016, 07, 6, 5, Fair.typeName.science);
        Festival festival = new Festival("Mexican",5.00,4,2015, 07, 6);
        Musicfiesta musicfiesta1 = new Musicfiesta(5, "IglooFest", 5.00, 4, 2014, 07, 6);
        Culturalfiesta culturalfiesta1 = new Culturalfiesta(3, "Poutine", 5.00, 4, 2035, 07, 2);
        SportCompetition sportCompetition1 = new SportCompetition(2014, 07, 5, 5, SportCompetition.Type.summer);

        //create an array of type event of size 10
        Event[] array = new Event[10];

        //toString() method to output contents of objects
        System.out.println(event1);
        System.out.println(fair);
        System.out.println(festival);
        System.out.println(musicfiesta1);
        System.out.println(culturalfiesta1);
        System.out.println(sportCompetition1);
        System.out.println();

        //use the equals method to test for equality of two objects
        System.out.println(event1.equals(event2));
        System.out.println();

        //create 4 more objects to fill array
        Musicfiesta musicfiesta2 = new Musicfiesta(5, "Piknic Electronik", 5.00, 4, 2012, 07, 6);
        Culturalfiesta culturalfiesta2 = new Culturalfiesta(3, "La cultura", 5.00, 4, 2020, 07, 3);
        SportCompetition sportCompetition2 = new SportCompetition(2025, 07, 4, 5, SportCompetition.Type.summer);


        //store all objects of type event in the array
        array[0] = event1;
        array[1] = event2;
        array[2] = fair;
        array[3] = festival;
        array[4] = musicfiesta1;
        array[5] = musicfiesta2;
        array[6] = culturalfiesta1;
        array[7] = culturalfiesta2;
        array[8] = sportCompetition1;
        array[9] = sportCompetition2;

        //trace(search) the array for the least/most number of cities
        for(int i = 0; i<array.length; i++)
        {
            if(array[i].getNbCities()>Event.getMostCities())
            {
                Event.setMostCities(array[i].getNbCities());
            }
            else if(array[i].getNbCities()<Event.getLeastCities())
            {
                Event.setLeastCities(array[i].getNbCities());
            }
        }

        for(int i = 0; i<array.length; i++)
        {
            if(array[i].getNbCities() == Event.getMostCities())
            {
                System.out.println("Most cities: " +array[i]);
            }
            else if(array[i].getNbCities() == Event.getLeastCities())
            {
                System.out.println("Least cities: " +array[i]);
            }
        }

        System.out.println();

        //trace(search) the array if they are happening in the same year
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<array.length;j++)
            {
                if (array[i].getYear() == (array[j].getYear()))
                {
                    System.out.println(array[i]);
                    System.out.println(array[j]);
                    System.out.println("Event " + (i + 1) + " and " + (j + 1) + " are in " + array[i].getYear());
                }
            }
        }

        System.out.println();

        //creating an array of length 12 containing the initial 10 objects created in part 1 and adding 2 new objects
        Event array2[] = new Event[12];
        array2[0] = event1;
        array2[1] = event2;
        array2[2] = fair;
        array2[3] = festival;
        array2[4] = musicfiesta1;
        array2[5] = musicfiesta2;
        array2[6] = culturalfiesta1;
        array2[7] = culturalfiesta2;
        array2[8] = sportCompetition1;
        array2[9] = sportCompetition2;
        array2[10] = new Event(2054, 10, 16);
        array2[11] = new Fair(2054, 10, 16, 5, Fair.typeName.trade);

        //create a copy of array2
        Event[] eventCopy = copyFestival(array2);


        //display information from original array of length 12
        for (int j = 0; j < array2.length; j++) {
            System.out.println((j + 1) + ". " + array2[j]);


        }

        System.out.println();

        //display information from copy array of length 12
        for (int j = 0; j < eventCopy.length; j++) {
            System.out.println((j + 1) + ". " + eventCopy[j]);


        }

        //the copyFestival didn't function the way it should have.
        //it was only copying events that were festivals
        //we must use the clone method in order to avoid such behaviour
    }
}
