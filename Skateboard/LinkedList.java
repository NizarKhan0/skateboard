public class LinkedList
{
    NodeClass head, tail, current;
    private String name; //String like "list" used in printing
    
    public LinkedList(String s)
    {
        name = s;
        head = tail = current = null;
    }
    
    public LinkedList()
    {
        this("linked list");
    }
    
    public void insertAtFront(Skateboard insertItem)
    {
        if(isEmpty())
        {
            head = tail = new NodeClass(insertItem);
        }
        else
        {
            head = new NodeClass(insertItem, head);
        }
    }
    
    public Skateboard removeLast() throws EmptyListException
    {
       Skateboard removeItem = null;
       
       if(isEmpty())
           throw new EmptyListException(name);
           
       removeItem = tail.data; //retrieve data
       //reset the head and tail references
       if(head.equals(tail))
       {
           head = tail = null;
       }
       else
       {
           current = head;
           while(current.next != tail) //not last node
               current = current.next; //move to next node
           tail = current;
           current.next = null;
        }
        
       return removeItem;
    }
    
    public boolean isEmpty()
    { return head == null; }
    //sortName
    public void SortByNameAscending()
    {
        NodeClass current = head, tempo = null;
        Skateboard temp;
        
        if(head == null)
        { 
            return;
        }
        else
        {
            while(current != null)
            {
                tempo = current.next;
                while(tempo != null)
                {
                    if(((Skateboard)current.data).getName().compareTo(((Skateboard)tempo.data).getName()) > 0)
                    {
                        temp = current.data;
                        current.data = tempo.data;
                        tempo.data = temp;
                    }
                    tempo = tempo.next;
                }
                current = current.next;
            }
        }
    }
    
    public Object getFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            current = head;
            return current.data;
        }
    }
    
    public Object getNext()
    {
        if(current != tail)
        {
            current = current.next;
            return current.data;
        }
        else
        {
            return null;
        }
    }
    
    public int size()
    {
        int s = 0;
        current = head;
        while(current != null)
        {
            s++;
            current = current.next;
        }
        return s;
    }
    
    public void display()
    {
        current = head;
        
        if(head == null)
        {
            System.out.println("List is empty.");
        }
        else
        {
            while(current != null)
            {
                System.out.println(current.data + " ");
                current = current.next;
            }
        }
    }
}
