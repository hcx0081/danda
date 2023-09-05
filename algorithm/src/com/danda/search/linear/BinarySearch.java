package com.danda.search.linear;

/**
 * {@code @description:}
 */
public class BinarySearch {
    static int binarySearch(int[] arr, int key) {
        int lowIndex = 0;
        int midIndex;
        int highIndex = arr.length - 1;
        while (lowIndex <= highIndex) {
            midIndex = (lowIndex + highIndex) / 2;
            if (key > arr[midIndex]) {
                lowIndex = midIndex + 1;
            } else if (key < arr[midIndex]) {
                highIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
    }
}