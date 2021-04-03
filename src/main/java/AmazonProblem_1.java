import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AmazonProblem_1 {

    public static void main(String[] args) {

        List<Integer> jeans = new LinkedList<>();
        jeans.add(2);
        jeans.add(3);

        List<Integer> shoes = new LinkedList<>();
        shoes.add(4);

        List<Integer> skirts = new LinkedList<>();
        skirts.add(2);

        List<Integer> tops = new LinkedList<>();
        tops.add(1);
        tops.add(2);
        tops.add(3);

        int dollors = 10;

        int answer = getNumberOfOptions(jeans, shoes, skirts, tops, dollors);

        System.out.println(answer);

    }

    private static int getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
            List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {

        int longest = Math.max(priceOfJeans.size(),
                Math.max(priceOfShoes.size(), Math.max(priceOfSkirts.size(), priceOfTops.size())));

        if (priceOfTops.size() == longest) {
            return helper(priceOfTops, priceOfJeans, priceOfShoes, priceOfSkirts, dollars);
        }

        if (priceOfSkirts.size() == longest) {
            return helper(priceOfSkirts, priceOfJeans, priceOfShoes, priceOfTops, dollars);
        }

        if (priceOfShoes.size() == longest) {
            return helper(priceOfShoes, priceOfJeans, priceOfSkirts, priceOfTops, dollars);
        }

        return helper(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, dollars);
    }



    private static int helper(List<Integer> longest, List<Integer> a, List<Integer> b, List<Integer> c, int dollars) {

        Collections.sort(longest);
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);

        int[] abSum = new int[a.size() * b.size()];
        int abIndex = 0;

        for (int ai : a) {

            if (ai >= dollars) {
                break;
            }

            for (int bi : b) {

                if (bi >= dollars) {
                    break;
                }

                if (ai + bi < dollars) {
                    abSum[abIndex] = ai + bi;
                    abIndex++;
                } else {
                    break;
                }

            }

        }

        int[] abcSum = new int[abSum.length * c.size()];
        int abcIndex = 0;

        for (int abi : abSum) {

            if (abi == 0) {
                break;
            }

            for (int ci : c) {

                if (ci >= dollars) {
                    break;
                }

                if (abi + ci < dollars) {
                    abcSum[abcIndex] = abi + ci;
                    abcIndex++;
                } else {
                    break;
                }

            }

        }

        int result = 0;

        for (int abci : abcSum) {

            if (abci == 0) {
                break;
            }

            for (int di : longest) {
                if (abci + di <= dollars) {
                    result++;
                } else {
                    break;
                }
            }

        }

        return result;
    }
}