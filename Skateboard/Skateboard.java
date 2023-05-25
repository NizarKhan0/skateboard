
public class Skateboard
{
    private String position;
    private String name;
    private int age;
    private String eventPlace;
    private int ID;
    private String origin;
    private int minutes; //for skater & crew
    //Normal constructor
    public Skateboard(String position, String name, int age, String eventPlace, int ID, String origin, int minutes)
    {
        this.position = position;
        this.name = name;
        this.age = age;
        this.eventPlace = eventPlace;
        this.ID = ID;
        this.origin = origin;
        this.minutes = minutes;
    }
    //accessor/setter
    public void setAll(String position, String name, int age, String eventPlace, int ID, String origin, int minutes)
    {
        this.position = position;
        this.name = name;
        this.age = age;
        this.eventPlace = eventPlace;
        this.ID = ID;
        this.origin = origin;
        this.minutes = minutes;
    }
    //mutator/getter
    public String getPosition()
    { return position; }
    
    public String getName()
    { return name; }
    
    public int getAge()
    { return age; }
    
    public String getEventPlace()
    { return eventPlace; }
    
    public int getID()
    { return ID; }
    
    public String getOrigin()
    { return origin; }
    
     public int getMinutes()
    { return minutes; }
    //method calculate run points
    public int runPoints()
    {
        int valuePoints = 0;
        
        if(position.equalsIgnoreCase("Skater"))
        {
            if(minutes < 60)
            {
                valuePoints = 5;
            }
            else if(minutes >= 60 && minutes <= 80)
            {
                valuePoints = 20;
            }
            else if(minutes >= 81 && minutes <= 120)
            {
                valuePoints = 35;
            }
        }
        else if(position.equalsIgnoreCase("Crew"))
        {
            System.out.println("\n" + position + "\t\t " + name + "\t\t" + age + "\t\t" + eventPlace
                + "\t\t\t" + ID + "\t\t" + origin + "\t\t" + minutes);
        }
        
        return valuePoints;
    }
    //toString
    public String toString()
    {
        return "\n" + "Position: " + position + "\tName: " + name + "\tAge: " + age + "\t   Event Place: " + eventPlace
                + "\t    ID:" + ID + "\tOrigin: " + origin + "\t\tMinute(s): " + minutes + "\t\tRun Point: " + runPoints();
    }
}