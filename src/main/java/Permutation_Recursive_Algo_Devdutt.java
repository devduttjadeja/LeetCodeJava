public class Permutation_Recursive_Algo_Devdutt {

    public static void main(String[] args) {
        String word = "ABCD";
        allPermutationOfString(word.toCharArray(),0,word.length()-1);
    }

    private static void allPermutationOfString(char[] line, int first, int last) {

        if(first == last) {
            System.out.println(line);
        }

        for(int i = first; i <= last; i++) {
            swap(line,first,i);
            allPermutationOfString(line,first+1,last);
            swap(line,first,i);
        }
    }

    private static void swap(char[] line, int i, int j) {
        char temp = line[i];
        line[i] = line[j];
        line[j] = temp;
    }


}