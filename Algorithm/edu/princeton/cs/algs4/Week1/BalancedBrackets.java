package Week1;

import java.util.Stack;
import java.util.Scanner;
class BalancedBrackets {
    public static String solution (String input){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            char curr = input.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{'){
                s.push(curr);
            }
            else{
                if (s.isEmpty()){
                    return "NO";
                }
                else if (curr == ')' && s.peek() != '('){
                    return "NO";
                }
                else if (curr == ']' && s.peek() != '['){
                    return "NO";
                }
                else if (curr == '}' && s.peek() != '{'){
                    return "NO";
                }
                else{
                    s.pop();
                }
            }
        }
        if (s.isEmpty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] inputs = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++){
            inputs[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++){
            System.out.println(BalancedBrackets.solution(inputs[i]));
        }
    }
}