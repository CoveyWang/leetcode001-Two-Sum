import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1, 2);
        hashMap.put(1, 3);
        //System.out.println(hashMap.get(1));
        //System.out.println(hashMap.get(2));

        int[] numbers = {3, 2, 4, 5};
        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, 6);
        System.out.println(result[0] + "  " + result[1]);
    }
}
