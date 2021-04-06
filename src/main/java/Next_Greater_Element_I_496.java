import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I_496 {

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 10, 3, 2, 1, 7};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {

            while (!stack.empty() && nums2[i] > stack.peek()) {
                int value = stack.pop();
                map.put(value, nums2[i]);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }


}
