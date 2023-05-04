package AQA.Task3;

// V10.
// Array Rotation: Write a Java program that takes an array of integers and rotates it by a given number of positions. Your program should prompt the user to enter the array size and the elements of the array, and then the number of positions to rotate the array. Finally, your program should output the rotated array.
// Make LinkedList from the result array and performs the following operations: a) Add an element to the beginning of the list; b) Add an element to the end of the list; c) Remove the first element from the list; d) Remove the last element from the list; e) Print the elements of the list in reverse order;
// Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.

import java.util.LinkedList;
import java.util.Scanner;



class Task3 {
    public static void main(String[] args) {


        try (
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Number of rotation: ");
            int n = scanner.nextInt();
            System.out.println("Array size: ");
            int Asize = scanner.nextInt();

            int[] arr = new int[Asize];
            System.out.println("Enter the elements of the array: ");
            for(int i=0; i<Asize; i++)
            {

                arr[i]=scanner.nextInt();
            }
            System.out.println("Original array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            for(int i = 0; i < n; i++){
                int j, last;

                last = arr[arr.length-1];

                for(j = arr.length-1; j > 0; j--){

                    arr[j] = arr[j-1];
                }

                arr[0] = last;
            }

            System.out.println("Array after rotation: ");
            for(int i = 0; i< arr.length; i++){
                System.out.print(arr[i] + " ");
            }

            LinkedList<Integer>list = new LinkedList<Integer>();
            for (int i = 0; i < arr.length; i++){

                list.add(i, arr[i]);


            }
            System.out.println("LinkedList of above array : "
                    + list);
            list.add(2);
            list.add(0,2);
            System.out.println("Add element first and last: "
                    + list);
            list.remove(0);
            list.remove(n-1);
            System.out.println("Remove element first and last: "
                    + list);
            LinkedList<Integer> linkedli = new LinkedList<Integer>();
            linkedli = reverseLinkedList(list);
            System.out.print("\nElements after reversing: " + linkedli);
            try {
                Integer.parseInt(null);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println();


    }
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> llist)
    {
        LinkedList<Integer> revLinkedList = new LinkedList<Integer>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revLinkedList.add(llist.get(i));
        }
        // Return the reversed arraylist
        return revLinkedList;
    }

}