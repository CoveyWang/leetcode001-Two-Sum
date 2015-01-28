import java.util.Arrays;

/**
 * Created by Covey on 2015/1/28.
 */
class Pair implements Comparable<Pair> {
    public int value;
    public int position;

    public Pair(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}

public class Solution_Iterator {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(numbers[i], i + 1);
        }
        Arrays.sort(pairs);
        int[] result = new int[2];
        int begin = 0;
        int end = n - 1;
        int number1 = 0, number2 = 0;
        while (begin < end) {
            number1 = pairs[begin].value;
            number2 = pairs[end].value;
            if (number1 + number2 == target) {
                if (pairs[begin].position < pairs[end].position) {
                    result[0] = pairs[begin].position;
                    result[1] = pairs[end].position;
                } else {
                    result[0] = pairs[end].position;
                    result[1] = pairs[begin].position;
                }
                break;
            } else {
                if (number1 + number2 > target) {
                    end--;
                } else {
                    begin++;
                }
            }
        }
        return result;
    }
}