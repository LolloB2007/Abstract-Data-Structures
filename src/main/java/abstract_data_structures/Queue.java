package abstract_data_structures;

/**
 *  implementation of a basic queue class
 *  might update in the future
 * 
 * working methods:
 * enqueue
 * peek
 * size
 * (private) peekN --> peek last node
 * retrieve
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
    
    public t peek()
    {
        if(head==null){return null;}
        if(head.getNext()==null){return (t) head.getData();}
        return peek(head.getNext());
    }
    
    private t peek(Node n)
    {
        if(n.getNext()==null){return (t) n.getData();}
        return peek(n.getNext());
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
    
    private Node peekN()
    {
        if(head==null){return null;}
        if(head.getNext()==null){return head;}
        return peekN(head.getNext());
    }
    
    private Node peekN(Node n)
    {
        if(n.getNext()==null){return n;}
        return peekN(n.getNext());
    }
    
    public t retrieve()
    {
        if(size()==0){return null;}
        if(size()==1)
        {
            Node temp = head;
            head = null;
            return (t) temp.getData();
        }
        
        Node last = peekN();
        Node temp = head;
        
        while(temp.getNext()!=last)
        {
            temp = temp.getNext();
        }
        
        temp.setNext(null);
        return (t) last.getData();
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
