/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class is your DCircularLL. You will be implementing the methods in accordance
 * of the project description.
 * 
 * REMEMBER: A circular linked list only uses a tail pointer - no head pointer.
 *
 * Methods you will implement:
 * public void add(int value)
 * public void append(int value) 
 * public void remove(int item)
 * public void remove()
 * public void empty()
 * public int indexOf(int value) 
 * public void insertionSort() 
 * public void mergeSort()
 * 
 * Methods and Classes Already implemented for you:
 * public DCircularLL()
 * public static DCircularLL createUnsortedLL() 
 * public String toString() 
 * private static class Node  <-- Inner Node class
 * 
 */
package sortingproject;


/**
 * @version Starter Code
 * @author Jack Hoeting
 */
class DCircularLL {

    private Node tail;

    /**
     * creates an empty list
     */
    public DCircularLL() {
        tail = null;
    }

    /**
     * Adds value to the start of the list
     *
     * @param value to be added
     */
    public void add(int value) {
    Node n = new Node(value);
    if (tail == null) {
            tail = n; // Set the tail pointer to the new node
            tail.next = n;// Make the new node point to itself as it's the only node
            n.prev = n;
            n.next = n;
        } else // if not empty
    {
            n.next = tail.next; //head pointer also refers to tail.next
            tail.next.prev = n;
            tail.next = n;
        }

    }

    /**
     * Adds value to the end of the list
     *
     * @param value to be added
     */
    public void append(int value) {
  Node n = new Node(value);
  if (tail == null)
  {
      tail = n;
      tail.next = n;
      tail.prev = n;
  }
  else {
      n.next = tail.next;
      tail.next = n;
      n.prev = tail;
      tail = n;
  }
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item to be removed
     */
    public void remove(int item) {
    Node n = find(item);
    
    if (n == null)
    {
        return;
        
    } 
        
    else if (n == tail && tail == tail.next)
    {
        remove();
    }
   
    
    
    
    else {
    
    Node sucNode = n.next;
    Node predNode = n.prev;
    
   
    
    if (sucNode != null)
    {
        sucNode.prev = predNode;
    }
    if (predNode != null)
    {
        predNode.next = sucNode;
    }
    
    if (n == tail.next) // If the item to remove is the last node, update tail
    {
        tail.next = sucNode;
    }
    if (n == tail) // If the item to remove is the first node, update tail.next
    {
        tail = predNode;
        
    }  
    }
    } 
    
        

    
    
private Node find(int item)
{
    if (tail == null)
    {
        return null;
    }
    else if (tail == tail.next)
    {
        if (tail.value == item)
        {
            return tail;
        }
        return null;
    }
    else
    {
        Node curr = tail.next;
        while(curr != tail)
        {
            if (curr.value == item)
            {
                return curr;
            }
            curr = curr.next;
        }
        if (curr.value == item)
        {
            return curr;
           
        }
        else
        {
            return null;
        }
    }
}
    /**
     * Removes the first value in the list
     */
    public void remove() {
    if(tail == null) {
        tail = null;
    }
      if (tail == tail.next) {
                // If there is only one node, make the list empty
        tail = null;
            } else {
                // Remove the first item
                tail.next = tail.next.next;
                tail.next.prev = tail;
            }
      
        
    }
    /**
     * Empties the list
     */
    public void empty() {
    tail = null;
    }

    /**
     * Returns the location of the first occurrence of the value in the list.
     * 
     * @param value value to be located
     * @return 0 if it is the first item. Return -1 if it isn't in the list
     */
    public int indexOf(int value) {
        if (tail != null) {
        int index = 0; //place it at 0 to track the position
        // Start from the first node in the list
        Node current = tail.next;
        // We check if the value at the current node matches the target value
        while (current != tail) {
            if (current.value == value) {
                return index;
            }
            current = current.next; // Move to the next node and increment the index
            index++;
        }
        if (tail.value == value) {
            return index; // we return the index if it's found at the last position
        }
    }
    return -1; // value not found in the list
}
    

    /**
     * Sorts the list using insertion sort
     */
    public void insertionSort() {
        
    }
    
    /**
     * Sorts the list using radix sort
     */
    public void radixSort(){
        
    }
    
    /**
     * Creates a DCircularLL of LIST_SIZE that is filled with random integers
 between 0 and 999.
 * @return random list
     */
    public static DCircularLL createUnsortedLL() {
        DCircularLL linkedList = new DCircularLL();
        for (int i = 0; i < Sorts.LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            linkedList.add(value);
        }
        return linkedList;
    }
    
  
    /**
     * This is the method called when a DCircularLL is passed to System.out.print It
     * determines what is printed.
     * 
     * For this project I printed the list forward and backward.
     */
    @Override
    public String toString() {
        if (tail == null) {
            return "[]";
        }
        String strRepresentation = "Forward: [ ";
        Node cur = tail.next;
        while (cur != tail) {
            strRepresentation += cur.value + " ";
            cur = cur.next;
        }
        strRepresentation += cur.value + "]\nBackward: [ ";
        
        cur = tail;
        while (cur != tail.next) {
            strRepresentation += cur.value + " ";
            cur = cur.prev;
        }
        strRepresentation += cur.value + "]";
        return strRepresentation;
    }

    

    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {

        public Node prev;
        public Node next;
        public int value;

        /**
         * Constructor for Node
         * @param value value contained in Node
         */
        public Node(int value) {
            this.prev = null;
            this.value = value;
            this.next = null;
        }

        /**
         * Constructor for Node
         * @param prev previous pointer
         * @param value value contained in Node
         * @param next next pointer
         */
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}
