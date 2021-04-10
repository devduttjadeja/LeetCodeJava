import java.util.Stack;

public class Basic_Calculator_II_227 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {

        // initilize
        int calculate = 0;
        char sign = '+';

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                calculate = calculate * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {

                if (sign == '+')
                    stack.push(calculate);
                else if (sign == '-')
                    stack.push(-calculate);
                else if (sign == '*')
                    stack.push(stack.pop() * calculate);
                else if (sign == '/')
                    stack.push(stack.pop() / calculate);

                sign = s.charAt(i);
                calculate = 0;
            }

        }
        int result = 0;
        for (int items: stack)
            result += items;
        return result;

    }

}
