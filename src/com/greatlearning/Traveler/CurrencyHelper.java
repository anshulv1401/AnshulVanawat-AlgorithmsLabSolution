package com.greatlearning.Traveler;

import com.greatlearning.sort.MergeSort;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrencyHelper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for size of currency denominations
        System.out.println("Enter the size of currency denominations");
        int denominationsSize = sc.nextInt();
        int[] denominations = new int[denominationsSize];

        // Take input for currency denominations values
        System.out.println("Enter the currency denominations value");
        for (int i = 0; i < denominations.length; i++) {
            denominations[i] = sc.nextInt();
        }

        // Take input for amount payable
        System.out.println("Enter the amount you want to pay");
        int payment = sc.nextInt();

        // call getMinimumNotes method
        var noteArray = getMinimumNotes(denominations, payment);

        // Print min no of notes required to pay the amount
        if (noteArray.size() > 0) {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (var notes : noteArray) {
                System.out.println(notes.denominations + ":" + notes.count);
            }
        }
    }

    private static ArrayList<Notes> getMinimumNotes(int[] denominations, int paymentAmt) {
        // Sort denominations in desc order
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray(denominations);

        //Print sorted array;
        //mergeSort.printValues(denominations);

        // loop till the payment is complete
        ArrayList<Notes> noteArray = new ArrayList<Notes>();

        for (int i = 0; i < denominations.length; i++) {
            int numberOfNotes = (int) (paymentAmt / denominations[i]);
            if (numberOfNotes > 0) {
                noteArray.add(new Notes(denominations[i], numberOfNotes));
                paymentAmt = paymentAmt - (numberOfNotes * denominations[i]);
                if (paymentAmt <= 0) {
                    break;
                }
            }
        }

        if (paymentAmt > 0) {
            System.out.println("Can't pay completed amount. Amount pending : " + paymentAmt);
            return new ArrayList<Notes>();
        }
        return noteArray;
    }
}
