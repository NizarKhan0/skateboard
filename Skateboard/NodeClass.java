public class NodeClass
{
    Skateboard data;
    NodeClass next;
    
    public NodeClass(Skateboard data)
    { this.data = data; }
    
    NodeClass(Skateboard o, NodeClass nextNode)
    {
        data = o;
        next = nextNode;
    }
    
    Skateboard getObject() { return data; }
    
    NodeClass temp;
    int count = 0;
    public int countNodes()
    {
        while(temp != null)
        {
            temp = temp.next;
            count++;
        }
        
        return count;
    }
    
    NodeClass getLink() { return next; }
}
