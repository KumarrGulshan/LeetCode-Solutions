import java.util.Stack;

class Solution{
    public int calculate(String s){
        int num = 0;
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            int ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch -'0');
            }
            else if(ch =='+'){
                result += sign*num;
                sign = 1;
                num = 0;
            }
            else if(ch=='-'){
                result += sign*num;
                sign = -1;
                num =0;
            }
            else if(ch =='('){
                stack.push(result);
                stack.push(sign);
                sign =1;
                result =0;
            }
            else if (ch == ')') {
                result += sign * num;
                num = 0;
                int previousSign = stack.pop();
                int previousResult = stack.pop();
                result = previousResult + previousSign * result;
            }
        }
        result += sign * num;

        return result;
    }

}