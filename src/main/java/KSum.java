import java.util.*;
import java.util.stream.Collectors;

public class KSum {

    public static void main(String[] args) throws Exception {

        int[] nums = {1, 0, -1, 0, -2, 2};
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> list : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(list);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList(target - nums[i], nums[i]));
                }
            }
            s.add(nums[i]);
        }
        return res;
    }
}