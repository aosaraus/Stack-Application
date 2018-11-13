import java.util.Scanner;

public class Project4 { 
   public static void main (String [] args) { 
      Scanner kb = new Scanner(System.in); 
     
      System.out.println("Please enter infix expression (or hit enter to exit): ");
      String expression = kb.nextLine();
      //allows the user to enter expressions until they hit enter to quit   
      while(!expression.equals("")) {
         InfixCalcA expressionA = new InfixCalcA(expression);
         if(expressionA.validateE()) {
            System.out.println("Prefix expression: " + expressionA.toPrefix());
            System.out.println("Postfix expression: " + expressionA.toPostFix());
            System.out.println("Please enter infix expression (or hit enter to exit): "); 
	    expression = kb.nextLine();
         } else {
            System.out.println("Invalid expression. try again");
            expression = kb.nextLine();
         }
      }
   }
}
