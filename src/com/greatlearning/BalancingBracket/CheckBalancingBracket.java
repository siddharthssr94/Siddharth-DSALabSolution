package com.greatlearning.BalancingBracket;
import java.util.Scanner;
import java.util.Stack;

public class CheckBalancingBracket {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        CheckBalancingBracket bb = new CheckBalancingBracket();

        System.out.println("Enter the expression to be checked for balanced brackets :");
        String inp = sc.nextLine();
        boolean flag = bb.checkBracket(inp);

        if(flag)
            System.out.println("The entered String has Balanced Brackets.");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets.");

    }

    public boolean checkBracket(String expression)
    {
        //Return false if odd number of characters input
        if(expression.length()%2!=0)
        {
            return false;
        }
        Stack<Character> bracketStack = new Stack<>();

        for(int i=0; i<expression.length();i++)
        {
            char bracket = expression.charAt(i);

            //Push if Opening bracket
            if(bracket =='{' || bracket =='[' || bracket =='(')
            {
                bracketStack.push(bracket);
            }


            else
            {
                char top = bracketStack.pop();

                //Check if top matches popped character.
                switch(bracket)
                {
                    case '}':
                        if(top=='['||top=='(')
                        {
                            return false;
                        }

                        else
                            return true;

                    case ']':
                        if(top=='{'||top=='(')
                        {
                            return false;
                        }
                        else
                            return true;

                    case ')':
                        if(top=='['||top=='{')
                        {
                            return false;
                        }
                        else
                            return true;

                    default: return bracketStack.isEmpty();

                }
            }
        }
        return false;
    }
}