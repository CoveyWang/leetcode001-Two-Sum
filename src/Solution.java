import java.util.HashMap;

/**
 * Created by Covey on 2015/1/28.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i + 1);
        }

        int[] result = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            int number1 = numbers[i];
            int number2 = target - number1;
            Integer index2 = hashMap.get(number2);
            if (index2 != null) {
                Integer index1 = hashMap.get(number1);
                if (number1 == number2) {
                    result = this.doubleNumbers(numbers, number1);
                    if (result[0] != 0 & result[1] != 0) {
                        break;
                    }
                } else {
                    result[0] = index1;
                    result[1] = index2;
                    if (result[0] > result[1]) {
                        int temp = result[0];
                        result[0] = result[1];
                        result[1] = temp;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public int[] doubleNumbers(int[] numbers, int value) {
        int[] result = {0, 0};
        boolean findFirst = false;
        for (int i = 0; i < numbers.length; i++) {
            if (findFirst && numbers[i] == value) {
                result[1] = i + 1;
                break;
            }
            if (!findFirst && numbers[i] == value) {
                findFirst = true;
                result[0] = i + 1;
            }
        }
        return result;
    }
}