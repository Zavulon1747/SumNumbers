package org.shandakova;


/*
Functions that finds missing number in array with numbers 0,1,2,3...N

findLostNumber - if missing number only one (faster)
findLostNumberWithRepeated - for other cases

 */
public class NumberTask {

    //Function return smallest missing number or -1 for any array of non-negative numbers
    public int findLostNumberWithRepeated(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // return value not in 1...N
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int temp : arr) {
            if (temp < min) {
                min = temp;
            }
            if (temp > max) {
                max = temp;
            }
        }
        //fill array of occurrence
        boolean[] flags = new boolean[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int index = max - arr[i];
            flags[index] = true;
        }
        for (int i = flags.length - 1; i >= 0; i--) {
            if (!flags[i]) {
                //calculate element
                return max - i;
            }
        }
        return -1;
    }

    //Function return missing number or -1 for array of non-negative non-repeated numbers with only one missing number
    public int findLostNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // return value not in 1...N
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        //sum before of start sequence
        int notUsedSum = min != 0 ? calculateSum(min - 1) : 0;
        //expected sum of numbers
        int expectedSum = calculateSum(max) - notUsedSum;
        int missingNum = expectedSum - sum;
        return missingNum != 0 ? missingNum : -1;
    }

    //Function that calculate  = 0+..+N
    private static int calculateSum(int n) {
        return (n * n + n) / 2;
    }
}
