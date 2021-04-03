import java.util.ArrayList;
import java.util.List;

public class PrimeArrange {

    private static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println(findAllValidPermutation(list));
        System.out.println(count);
    }

    private static List<List<Integer>> findAllValidPermutation(List<Integer> nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];

        if (nums.size() == 0) {
            return result;
        }

        dfs(nums, used, permutation, result);
        return result;
    }

    private static void dfs(List<Integer> nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {

        //here need to hit the condition while in the subset size does not matter
        // what to do when we find the permutation.?
        if (permutation.size() == nums.size()) {
            if (isValid(permutation)) {
                result.add(new ArrayList<>(permutation)); // preparing answer
                count++; // updated count
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {

                if (used[i]) {
                    continue;
                }

                used[i] = true;//choose
                permutation.add(nums.get(i));//choose

                dfs(nums, used, permutation, result); //explore

                permutation.remove(permutation.size() - 1); //unchoose
                used[i] = false; //unchoose
            }
        }
    }

    private static boolean isValid(List<Integer> permutation) {
        for (int i = 1; i < permutation.size(); i++) {
            if (!isPrime(permutation.get(i - 1) + permutation.get(i))) {
                return false;
            }
        }
        return isPrime(permutation.get(0) + permutation.get(permutation.size() - 1));
    }

    private static boolean isPrime(int num) {

        if (num == 1) {
            return true;
        }

        if (num < 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

