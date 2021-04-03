import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {

        //https://youtu.be/RkXl5iYoQn4 - all backtracking
        //https://youtu.be/GCm7m5671Ps - nice

        boolean[] visited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums, visited, permutation, res);
        // here boolean array plays an important role beause the it sets true
        // for those element which are visited and false will be set for those available in decision space
        return res;
    }

    public void helper(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> res) {

        // when size of choosen sublist permutation is equal to size of nums
        // we get one possible combination
        // add to result
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true; //choose
            permutation.add(nums[i]); //choose
            helper(nums, visited, permutation, res); //explore
            permutation.remove(permutation.size() - 1); // remove last choosen element
            visited[i] = false; //unchoose

        }

    }
}
