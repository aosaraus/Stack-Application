public class NodeStack {
   protected Node head;
   protected int size; 
//constructor for linkedlist   
   public NodeStack(){
      head = null;
      size = 0; 
   } 
    //returns size
   public int size() { 
      return size; 
   }
//adds new node
   public void pushA (String c) {
      Node newHead = new Node(c,head);
      head = newHead;
      size++;
   }    
   public void push (char c) {
      Node newHead = new Node(c, head); 
      head = newHead;
      size++;
   }
//removes head 
   public String popA() {
      String removedExpression = head.getElementA();
      head = head.getNext();
      size--;
      return removedExpression; 
   }
      
   public char pop() {
      char removedExpression = head.getElement();
      head = head.getNext();
      size--;
      return removedExpression;
   }
 //returns value of element of the head
   public String peekA() {
      if(head != null) {
          return head.getElementA();
       } else {
          throw new RuntimeException ("Empty Stack");
       }
   }
  public char peek() {
     if(head != null) {
        char topOfStack = head.getElement();
        return topOfStack;
     } else {
        throw new RuntimeException("Empty Stack");
     }
  }
  public boolean isEmpty() {
     return size == 0;
  }
}
  
