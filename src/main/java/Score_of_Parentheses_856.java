import java.util.Stack;

public class Score_of_Parentheses_856 {
    public static void main(String[] args) {

        System.out.println(scoreOfParentheses("()"));
    }

    public static int scoreOfParentheses(String input) {

        // store the scores for the upcoming character
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        for (char ch : input.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } else {

                // else take the last 2 top items from stack and push updated score
                // updatedscore = top2 + max(2 * top1, 1)
                int top1 = stack.pop();
                int top2 = stack.pop();

                int updatedScore = top2 + Math.max(2 * top1, 1);
                stack.push(updatedScore);
            }


        }

        return stack.pop();
    }

}
