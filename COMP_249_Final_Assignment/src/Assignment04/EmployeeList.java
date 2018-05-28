//------------------------------------------------------
//
// Assignment #4
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------

package Assignment04;

public class EmployeeList
{
    
    public Node head;
    public EmployeeList()
    {
        head = null;
    }
    
    public void addNode(Employee e)
    {
        head = new Node(e, head);
    }
    
    public class Node
    {
         Node next;
         Employee e;
        
        public Node()
        {
            next = null;
            e = null;
        }
        
        public Node(Employee e, Node n)
        {
            this.e = e;
            this.next = n;    
        }
    }    
    
}
    