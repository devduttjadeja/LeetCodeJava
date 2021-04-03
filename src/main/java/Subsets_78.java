import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        subsetsHelper(nums, result, current, 0); // [1, 2, 3, 4]

        return result;
    }

    public static void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> current, int depth){

        result.add(new ArrayList<Integer>(current));

        for(int i = depth; i < nums.length; i++){
            current.add(nums[i]);
            subsetsHelper(nums, result, current, i+1);
            current.remove(current.size()-1);
        }
    }


}
