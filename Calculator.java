//Author: Alexis Navarro
//Lab 8
//Last modification: 11/20/18

//PURPOSE OF THE PROGRAM: Is to understand how to use Stacks with postfix expressions which are required to be solved. 
//However, the postfix expressions are in a text file that needs to be read and inserted into a stack.
//then the expressions need to be validated by checking if the string at an index of the stack is a number or operator
//then I will be able to compute the result of the postfix expression.
import java.util.Scanner;
import java.io.*;
public class Calculator{


//CHECKS IF THE EXPRESSION IS VALID TO BE A POST FIX 
    public static boolean validatePostFix(String expression){
        String[] expressionSplit = expression.split(" "); 
        boolean is_number=false;
        
        for(int i=0; i<expressionSplit.length; i++){
            is_number = isNumber(expressionSplit[i]);

            if(is_number == true){
                System.out.println(is_number);
            }

            if(is_number == false){
                if(expressionSplit[i].equals("+")){
                    System.out.println("Operator detected: +");
                }
            }
            
            if(is_number == false){
                if(expressionSplit[i].equals("-")){
                    System.out.println("Operator detected: -");
                }
            }
            if(is_number == false){
                if(expressionSplit[i].equals("*")){
                    System.out.println("Operator detected: *");
                }
            }
            if(is_number == false){
                if(expressionSplit[i].equals("/")){
                    System.out.println("Operator detected: /");
                }
            }
        }
        return true;
    }//end VALIDATE POST FIX


//Validates if the current index is a number
    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }//END IS NUMBER


//METHOD TO CALCULATE THE POST FIX EXPRESSIONS
    public static int calculate(String line, GenericStack stack){
        Object result = new Object();

        String[] tokens = line.split(" ");
        for(String token: tokens){
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int val1 = (int)stack.pop();
                int val2 = (int)stack.pop();
                if(token.equals("+")){
                    stack.push(val1+val2);
                }else if(token.equals("-")){
                    stack.push(val1-val2);
                }else if(token.equals("*")){
                    stack.push(val1*val2);
                }else if(token.equals("/")){
                    stack.push(val1/val2);
                }
            }//end else
        }//end for 
       
            result = stack.pop();
            return (int) result;
    }//END CALCULATE 
    
    public static void main(String[] args){
        try{
            Scanner s = new Scanner(new File("input.txt"));
            GenericStack mystack = new GenericStack();

            while(s.hasNextLine()){
                String line = s.nextLine();
                boolean isValid=validatePostFix(line);

               if(isValid==true){  //CHECKS TO SEE IF THE EXPRESSION IS VALID THROUGH TO THE METHOD IT WAS CALLED
                    String[] aSplit=line.split(" ");

                    while(mystack.isEmpty()== false){
                        System.out.println(mystack.pop());                        
                      }

                    int result = calculate(line, mystack);          
                    System.out.println("\nEvaluated Stack: "+line+ " = "+result);  
                       
                }//end if
        }//end while
            s.close();
        }catch(FileNotFoundException e){
            System.out.println("not found");
        }
    }//end main
}//end Calculator