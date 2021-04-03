public class Number_Of_Missing_Element_In_Sorted_Array_1060 {

    public static void main(String[] args) {
        /*

        Example 1:
        Input: A = [4,7,9,10], K = 1
        Output: 5
        Explanation:
        The first missing number is 5.
        Example 2:

        Input: A = [4,7,9,10], K = 3
        Output: 8
        Explanation:
        The missing numbers are [5,6,8,...], hence the third missing number is 8.
        Example 3:

        Input: A = [1,2,4], K = 3
        Output: 6
        Explanation:
        The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
         */

        int[] input = {4, 7, 9, 10, 13, 15, 25};
        int k = 7;
        System.out.println(missingElement(input, k));
    }

    public static int missingElement(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;

        // find the first index left s.t. nMissing(left) >= k
        while (left < right) {

            int mid = left + (right - left) / 2;

            int missing = numberOfMissingElement(nums, mid);

            if (missing <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        return nums[left - 1] + (k - numberOfMissingElement(nums, left - 1));
    }

    // # of missing numbers in [nums[0], nums[index]]
    private static int numberOfMissingElement(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}