package abstract_data_structures;

/**
 *  implementation of a basic queue class
 *  might update in the future
 * 
 * working methods:
 * enqueue
 * dequeue
 * size
 * toString
 * 
 *  @author lorenzobarbagelata
 */


public class Queue<t>{
    
    class Node <t>{
        
        private t data;
        private Node next;
        
        public Node(t data)
        {
            this.data = data;
        }
        
        public t getData()
        {
            return data;
        }
        
        public void setData(t data)
        {
            this.data = data;
        }
        
        public Node getNext()
        {
            return next;
        }
        
        public void setNext(Node n)
        {
            next = n;
        }
        
        public String toString()
        {
            return ""+data;
        }
    }
    
    private Node head;
    
    public void enqueue(t data)
    {
        Node<t> temp = new Node<t>(data);
        temp.setNext(head);
        head = temp;
    }
    
    public t dequeue()
    {
        if(head==null){return null;}
        if(head.getNext()==null){return (t) head.getData();}
        return dequeue(head.getNext());
    }
    
    private t dequeue(Node n)
    {
        if(n.getNext()==null){return (t) n.getData();}
        return dequeue(n.getNext());
    }
    
    public int size()
    {
        if(head==null){return 0;}
        if(head.getNext()==null){return 1;}
        return 1+size(head.getNext());
    }
    
    public int size(Node n)
    {
        if(n==null){return 0;}
        return 1+size(n.getNext());
    }
    
    public String toString()
    {
        String ans = head.toString();
        Node temp = head;
        
        while(temp.getNext()!=null)
        {
            temp = temp.getNext();
            ans = ans + temp.toString();
        }
        
        return ans;
    }
}
