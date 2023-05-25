
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
public class TestSkateboard
{
    public static void main(String [] args) throws IOException
    {
        LinkedList skaterList = new LinkedList();
        Queue kList = new Queue();

        try
        {
            BufferedReader inFile = new BufferedReader(new FileReader("in.txt"));
            String position = null, name = null, eventPlace = null, origin = null, data = null;
            int ID = 0, minutes = 0, age = 0;
            Skateboard s;

            while((data = inFile.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(data, ";");
                position = st.nextToken();
                name = st.nextToken();
                age = Integer.parseInt(st.nextToken());
                eventPlace= st.nextToken();
                ID = Integer.parseInt(st.nextToken());
                origin = st.nextToken();
                minutes = Integer.parseInt(st.nextToken());

                s = new Skateboard(position, name, age, eventPlace, ID, origin, minutes);
                skaterList.insertAtFront(s);
                kList.enqueue(s);
            }
            inFile.close();
        }
        catch(FileNotFoundException ex)
        { System.out.println(ex.getMessage()); }
        catch(IOException ex)
        { System.out.println(ex.getMessage()); }
        catch(Exception ex)
        { System.out.println(ex.getMessage()); }

        //1 Display total number of crews that attends event
        Skateboard a = (Skateboard) skaterList.getFirst();
        String list1 = " ";
        int countC = 0;

        System.out.println("\n");
        System.out.println("\n=============================================================================================================================================================");
        System.out.println("                                                 Details of crews that attends the event in Arizona                                   ");
        System.out.println("=============================================================================================================================================================");
        System.out.println("|Position|" + "\t|Name|" + "\t\t|Age|" + "\t\t|Event Place|" + "\t\t|ID|" + "\t\t|Origin|" + "\t|Minutes|");

        while(a!= null)
        {
            if(a.getEventPlace().equalsIgnoreCase("Arizona"))
            {
                if(a.getPosition().equalsIgnoreCase("Crew"))
                {
                    list1 += a.runPoints();
                    countC++;
                }
            }
            a = (Skateboard) skaterList.getNext();
        }
        System.out.println("\n");
        System.out.println("Total number of crews that attends the event in Arizona: " + countC);

        //2 To find the skater with the highest points
        Skateboard b = (Skateboard) skaterList.getFirst();
        int max = 0;
        String list3 = " ";

        System.out.println("\n");
        System.out.println("\n============================================================================================================================================================");
        System.out.println("\t\t\t\t\t\tDetails of skater with the highest points ");
        System.out.println("============================================================================================================================================================");
        while(b != null)
        {
            if(b.getPosition().equalsIgnoreCase("Skater"))
            {
                if(b.runPoints() > max)
                {
                    max = b.runPoints();
                    list3 += b.toString();
                }
            }
            b = (Skateboard) skaterList.getNext();
        }
        System.out.println(list3);

        //3 the oldest crew
        Skateboard c = (Skateboard) skaterList.getFirst();
        int oldest = 0;
        String list2 = " ";

        System.out.println("\n");
        System.out.println("\n============================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\tThe oldest crew member");
        System.out.println("============================================================================================================================================================");
        System.out.println("|Position|" + "\t|Name|" + "\t\t|Age|" + "\t\t|Event Place|" + "\t\t|ID|" + "\t\t|Origin|" + "\t|Minutes|");
        while(c != null)
        {
            if(c.getPosition().equalsIgnoreCase("Crew"))
            {
                if(c.getAge() > oldest)
                {
                    oldest = c.getAge();
                    list2 += c.runPoints();
                }
            }
            c = (Skateboard) skaterList.getNext();
        }

        //4 sort names in ascending order
        //before sorting
        Skateboard d = (Skateboard) skaterList.getFirst();
        System.out.println("\n");
        System.out.println("\n============================================================================================================================================================");
        System.out.println("\t\t\t\t\t\tBefore sorting the list according to names");
        System.out.println("============================================================================================================================================================");
        while(d != null)
        {
            if(d.getPosition().equalsIgnoreCase("Skater"))
            {
                System.out.println(d.toString());
            }
            d = (Skateboard) skaterList.getNext();
        }

        //sorting list according to skaters names
        skaterList.SortByNameAscending();

        d = (Skateboard) skaterList.getFirst();
        System.out.println("\n");
        System.out.println("\n============================================================================================================================================================");
        System.out.println("\t\t\t\t\t\tAfter sorting the list according to names");
        System.out.println("============================================================================================================================================================");
        while(d != null)
        {
            if(d.getPosition().equalsIgnoreCase("Skater"))
            {
                System.out.println(d.toString());
            }
            d = (Skateboard) skaterList.getNext();
        }
        //5 Delete the last node
        Skateboard e = (Skateboard) skaterList.getFirst();

        System.out.println("\n");
        System.out.println("\n============================================================================================================================================================");
        System.out.println("\t\t\t\t\t\tDisplay all data in the list once the last node in the list is removed");
        System.out.println("============================================================================================================================================================");

        skaterList.removeLast();
        while(e != null)
        {
            System.out.println(e.toString());
            e = (Skateboard) skaterList.getNext();
        }
        skaterList.removeLast();
    }
}
