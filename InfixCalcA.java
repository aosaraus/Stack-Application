public class InfixCalcA {

   private String expression;
   private NodeStack opStack = new NodeStack();
   private NodeStack validStack = new NodeStack();//check if expression is valid

   public InfixCalcA(String expression) {
      this.expression = expression;
      System.out.println(this.expression);
   }
   //returns true of char is an operator
   public boolean isOperator(char c){
      if(c =='+' || c == '-' || c == '/' || c == '*' || c == '(' || c == ')') {
         return true;
      } else {
         return false;
      }
   }
   //checks if there is a parentehsis error
   public boolean validateE() throws RuntimeException {
      boolean valid = true;
      for (int i = 0; i < expression.length(); i++) {
         char c = expression.charAt(i);
         if(!isOperator(c) && !Character.isLetter(c) && !Character.isDigit(c)) {
            valid = false;
         }
         if (c == '(' ) {
            validStack.push( '(' );
	 } else if ( c == ')' ) {
            if ( validStack.isEmpty() ) {
               valid = false;               
	    } else {
     	    validStack.pop();
            }
	 }
      }
      if(!validStack.isEmpty()){
         valid = false;
      }
      return valid;
   } 
   //converts infix to prefix
   public String toPrefix() {
      String result = "";
      NodeStack valStack = new NodeStack();
      NodeStack oStack = new NodeStack();
      NodeStack finalStack = new NodeStack();
      for(int i = 0; i < expression.length(); i++) {
         boolean stop = false;
         String c = String.valueOf(expression.charAt(i));
         if(!isOperator(expression.charAt(i))) {
            valStack.pushA(c);
         } else {
            if(c.equals("(")) {
               oStack.pushA(c);
            }else if (c.equals("*") || c.equals("/")){
               while(!stop) {
                  if(oStack.isEmpty() || oStack.peekA().equals("+") || oStack.peekA().equals("-") || oStack.peekA().equals("(")) {
                     oStack.pushA(c);
                     stop = true;
                  } else { 
                     String rightOp = valStack.popA();
                     String leftOp = valStack.popA();
                     String operator = oStack.popA();
                     result =  operator + leftOp + rightOp;
                     valStack.pushA(result);
                  }
               }
            }else if(c.equals("+") || c.equals("-")) {
               while(!stop) {
                  if (oStack.isEmpty() || oStack.peekA().equals("(")){
                     oStack.pushA(c);
                     stop = true;
                  } else {
                     String rightOp = valStack.popA();
                     String leftOp = valStack.popA();
                     String operator = oStack.popA();
                     result =  operator + leftOp + rightOp;
                     valStack.pushA(result);
                  }
               }
            } else if(c.equals(")")) {
               while(!oStack.peekA().equals("(")){
                  String rightOp = valStack.popA();
                  String leftOp = valStack.popA();
                  String operator = oStack.popA();
                  result =  operator + leftOp + rightOp;
                  valStack.pushA(result);
               }
               if(!oStack.isEmpty()) {
                  oStack.pop();
               }
            }
         }
      }

      while(!oStack.isEmpty()) {
         String rightOp = valStack.popA();
         String leftOp = valStack.popA();
         String operator = oStack.popA();
         result =  operator + leftOp + rightOp;
         valStack.pushA(result);
      }

      String finalExpression = "";
      while(!valStack.isEmpty()){
         finalStack.pushA(valStack.popA());
      }
   
      while(!finalStack.isEmpty()){
         finalExpression += finalStack.popA();
      }
      return finalExpression.replaceAll("[()]",""); 
   }
   //converts infix to postfix
   public String toPostFix() {
      String result = "";
      for(int i = 0; i < expression.length(); i++) {
         char c = expression.charAt(i);
         if(isOperator(c)==false) {
            result += c;
         } else {
            if(opStack.isEmpty() == true) {
               opStack.push(c);
            } else {
               if(c == '(') {
                  opStack.push(c);
               } else if (c == '*' || c == '/'){
                  if(opStack.peek() == '+' || opStack.peek() == '-' || opStack.peek() == '(') {
                     opStack.push(c);
                  } else {
                     result += opStack.pop();
                     opStack.push(c);
                  }
               }else if(c == '+' || c == '-') {
                  result += opStack.pop();
                  if(opStack.isEmpty() || opStack.peek() == '(') {
                     opStack.push(c);
                  } else if( opStack.peek() == '+' || opStack.peek() == '-') {
                     result += opStack.pop();
                     opStack.push(c);
                  }else {
                     opStack.push(c);
                  }
               } else if(c == ')') {
                  for(int j = 0; j < opStack.size(); j++) {
                     if(opStack.peek() != '(') {
                       result += opStack.pop();
                     } 
                  }
               }
            }
         }
      }
      //pops any operators at end of expression 
      while (!opStack.isEmpty()) {
         result += opStack.pop();
      }
      return result.replaceAll("[()]","");
   } 

}

