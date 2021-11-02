package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int[] numArray = {1,20,13,6,-5,3};
        //a)
        printArray(numArray);
        //b)
        printMax(numArray);
        //c)
        printMin(numArray);
        //d)
        printMean(numArray);
        //e)
        System.out.println("sort with bubble");
        sortBubble(numArray);
        printArray(numArray);
        //f)
        numArray = new int[] {1,20,13,6,-5,3};
        System.out.println("sort with selection");
        sortSlection(numArray);
        printArray(numArray);
        //g)
        numArray = new int[] {1,20,13,6,-5,3};
        System.out.println("sort with insertion");
        sortInsertion(numArray);
        printArray(numArray);
        //h)
        numArray = new int[] {1,20,13,6,-5,3};
        System.out.println("sort with quicksort");
        quicksort(numArray, 0, numArray.length-1);
        printArray(numArray);
        //i)
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        System.out.println("Write a number to search: ");
        answer = sc.nextInt();
        searchLineal(numArray, answer);
        sc.nextLine();
        //j)
        answer = 0;
        System.out.println("Write a number to search: ");
        answer = sc.nextInt();
        searchBinary(numArray, 0, numArray.length, answer);
        sc.nextLine();

    }
    public static void printArray(int[] num){
        System.out.print("Array = ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] +" ");
        }
        System.out.println();
    }
    public static void printMax(int[] num){
        int max = num[1];
        for (int i = 0; i < num.length; i++){
            if (num[i] > max){
                max = num [i];
            }
        }
        System.out.println("max = "+max);
    }
    public static void printMin(int[] num) {
        int min = num[1];
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        System.out.println("min = "+min);
    }
    public static void printMean(int[] num){
        int mean = 0;
        for (int i = 0; i < num.length; i++) {
            mean += num[i];
        }
        mean = mean/num.length;
        System.out.println("mean = "+mean);
    }
    public static void sortBubble(int[] num){
        int aux = 0;
        for (int j = 0 ; j < num.length -1; j++) {
            for (int i = 0; i < num.length - 1; i++) {
                if (num[i] > num[i + 1]) {
                    aux = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = aux;
                }
            }
        }
    }
    public static void sortSlection(int[] num){
        for (int j = 0; j < num.length; j++) {
            int aux = num[j];
            int position = j;
            for (int i = num.length - 1; i > j; i--) {
                if (num[i] < aux) {
                    aux = num[i];
                    position = i;
                }
            }
            num[position] = num[j];
            num[j] = aux;
        }
    }
    public static void sortInsertion(int[] num){
        for (int i = 2; i < num.length; i++){
            for (int j = i; j > 0; j--){
                if (num[j]< num[j-1]){
                    int aux = num[j-1];
                    num [j-1] = num[j];
                    num[j] = aux;
                }
            }
        }
    }
    static int partition(int a[], int start, int end) {
        int pivot = a[end];
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        int aux = a[i + 1];
        a[i + 1] = a[end];
        a[end] = aux;
        return (i + 1);
    }
    public static void quicksort(int num[], int start, int end) {
        if (start < end) {
            int p = partition(num, start, end);
            quicksort(num, start, p - 1);
            quicksort(num, p + 1, end);

        }
    }
    public static void searchLineal(int num[], int itemToSearch){
        int position = -1;
        for(int i = 0; i < num.length; i++){
            if (num[i]== itemToSearch){
                position = i;
            }
        }
        if (position != -1){
            System.out.println("the element is in position: [" + position +"/"+(position+1) +"]");
        } else {
            System.out.println("the element is not on the list");
        }
    }
    public static void searchBinary(int[] num,int start, int end, int itemToSearch) {
        end = ((start + end)/2);
        if (start < end){
            if (itemToSearch < num[end]) {
                searchBinary(num, start, end, itemToSearch);
            } else if (itemToSearch > num[end]){
                searchBinary(num, end, end*2, itemToSearch);
            } else {
                System.out.println("the element is in position: [" + end +"/"+(end+1) +"]");
            }
        } else {
            System.out.println("the element is not on the list");
        }
    }
}
