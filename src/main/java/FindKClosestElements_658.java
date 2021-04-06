import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements_658 {
    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int index = binarySearch(arr, x);
        int left = index;
        int right = index + 1;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            if (left >= 0 && right <= arr.length - 1) {

                int leftDiff = Math.abs(arr[left] - x);
                int rightDiff = Math.abs(arr[right] - x);

                if (leftDiff <= rightDiff) {
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
            } else if (right <= arr.length - 1) {
                res.add(arr[right]);
                right++;
            } else if (left >= 0) {
                res.add(arr[left]);
                left--;
            }
        }

        Collections.sort(res);
        return res;
    }

    public int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        return left - 1;
    }
}
