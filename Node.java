public class Node { 
   private char element;
   private String elementA; 
   private Node next;
   //node constructor for a char element
   public Node(char element, Node n) {
      this.element = element; 
      next = n; 
   } 
  //node constructor for stringlemeent
   public Node(String element, Node n) {
      this.elementA = element;
      next = n;
   }
   //returns char element
   public char getElement() {
      return element; 
   }
//returns string element
   public String getElementA() {
      return elementA;
   }
//returns next node
   public Node getNext() {
      return next; 
   }
  //sets element
   public void setElement(char newE) {
      element = newE;
   } 
   //sets next
   public void setNext(Node newN) {
      next = newN;
   }
}

