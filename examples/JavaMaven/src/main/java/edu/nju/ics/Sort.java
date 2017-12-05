package edu.nju.ics;

public class Sort {
    public void sort(int[] arr) {
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) { //控制比较轮数

            for (int j = 0; j < arr.length - i - 1; j++) { //控制每轮的两两比较次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }

    }
    public void qSort(int[] arr) {
        //快速排序
        if (arr.length <= 1) {
            return;
        } else {
            partition(arr, 0, arr.length - 1);
        }

    }

    static void partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivotKey = arr[left]; //基准数

        while (i < j) {

            while (i < j && arr[j] >= pivotKey) {
                j--;
            }

            while (i < j && arr[i] <= pivotKey) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i != left) {
            arr[left] = arr[i];
            arr[i] = pivotKey;
        }

        if (i - left > 1) {
            partition(arr, left, i - 1);
        }

        if (right - j > 1) {
            partition(arr, j + 1, right);
        }

    }

}
