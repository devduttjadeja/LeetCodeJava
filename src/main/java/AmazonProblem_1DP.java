import java.util.LinkedList;
import java.util.List;

public class AmazonProblem_1DP {
    public static void main(String[] args) {
        List<Integer> jeans = new LinkedList<>();
        jeans.add(1);
        jeans.add(2);
        jeans.add(3);
        jeans.add(4);


        List<Integer> shoes = new LinkedList<>();
        shoes.add(4);
        shoes.add(4);
        shoes.add(4);
        shoes.add(4);
        shoes.add(4);

        List<Integer> skirts = new LinkedList<>();
        skirts.add(3);
        skirts.add(3);
        skirts.add(3);
        skirts.add(3);

        List<Integer> tops = new LinkedList<>();
        tops.add(1);
        tops.add(2);
        tops.add(3);
        tops.add(4);

        int dollors = 15;

        int answer = getNumberOfOptions(jeans, shoes, skirts, tops, dollors);

        System.out.println(answer);
    }

    private static int getNumberOfOptions(List<Integer> jeans, List<Integer> shoes, List<Integer> skirts, List<Integer> tops, int dollors) {

        List<List<Integer>> products = new LinkedList<>();
        products.add(jeans);
        products.add(shoes);
        products.add(skirts);
        products.add(tops);

        int currentProduct = 0;

        return getWays(products, dollors, currentProduct);
    }

    private static int getWays(List<List<Integer>> products, int dollors, int currentProduct) {

        // if no dollars left or all 4 products are already added then return 0
        if(dollors < 0 || currentProduct > products.size()){
            return 0;
        }

        // bought all the products from all 4 list and we still has some dollars left then
        // we got 1 way of choosing
        if(dollors >= 0 && currentProduct == products.size()){
            return 1;
        }

        int count = 0;
        List<Integer> product = products.get(currentProduct);

        for (Integer price : product) {
            int ways = getWays(products, dollors - price, currentProduct + 1);
            count = count + ways;
        }

        return count;

    }
}

