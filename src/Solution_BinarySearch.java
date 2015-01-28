/**
 * Created by Covey on 2015/1/28.
 */
public class Solution_BinarySearch {
    public int[] twoSum(int[] numbers, int target) {

        int[] origin_array = new int[numbers.length];
        System.arraycopy(numbers, 0, origin_array, 0, numbers.length);

        this.quickSort(numbers, 0, numbers.length - 1);

        int[] result = new int[2];
        int number1 = 0, number2 = 0, index1 = 0, index2 = 0;
        boolean find = false;
        for (int i = 0; i < numbers.length; i++) {
            if (!find) {
                number1 = numbers[i];
                number2 = target - number1;
                if (this.binarySearch(numbers, 0, numbers.length - 1, number2) != 0) {
                    find = true;
                }
            }
        }

        if (number1 != number2) {
            for (int i = 0; i < origin_array.length; i++) {
                if (origin_array[i] == number1) {
                    index1 = i + 1;
                }
                if (origin_array[i] == number2) {
                    index2 = i + 1;
                }
            }

            if (index1 > index2) {
                int temp = index1;
                index1 = index2;
                index2 = temp;
            }
        } else {
            for (int i = 0; i < origin_array.length; i++) {
                if (index1 == 0 && origin_array[i] == number1) {
                    index1 = i + 1;
                }
                if (index1 != 0 && origin_array[i] == number1) {
                    index2 = i + 1;
                }
            }

        }

        result[0] = index1;
        result[1] = index2;
        return result;
    }

    public int binarySearch(int[] numbers, int first, int last, int value) {
        int mid = (first + last) / 2;
        if (numbers[mid] == value) {
            return mid;
        }

        if (first == last) {
            return 0;
        }

        if (value < numbers[mid]) {
            return binarySearch(numbers, first, mid, value);
        } else {
            return binarySearch(numbers, mid + 1, last, value);
        }
    }

    public int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

}