import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer newPerformer)
    {
        if (!performers.contains(newPerformer))
        {
            performers.add(newPerformer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer)
    {
        if (performers.contains(performer))
        {
            performers.remove(performer);
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        double average = 0;
        for (Performer performer : performers)
        {
            average += performer.getAge();
        }
        average /= performers.size();
        return average;
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> performersOverAge = new ArrayList<>();
        for (Performer performer : performers)
        {
            if (performer.getAge() >= age)
            {
                performersOverAge.add(performer);
            }
        }
        return performersOverAge;
    }

    public void groupRehearsal()
    {
        for (Performer performer : performers)
        {
            System.out.println("REHEARSAL CALL! " + performer.getName());
            if(performer instanceof Comedian)
            {
                ((Comedian) performer).rehearse(false);
            }
            else
            {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer performer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());
            if (performer instanceof Dancer)
            {
                ((Dancer) performer).pirouette(2);
            }
            performer.perform();
        }
    }
}