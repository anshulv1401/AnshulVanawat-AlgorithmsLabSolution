package com.greatlearning.PayMoney;

import java.util.Scanner;

public class Transactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get the size of transaction from user
        System.out.println("Enter the size of transaction array");
        int trSize = sc.nextInt();

        // allocate an array of provided size
        int[] transactions = new int[trSize];

        // get the elements of the array (in a loop)
        System.out.println("Enter the values of array");
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = sc.nextInt();
        }

        // get the number of targets as numTargets
        System.out.println("Enter the total no of targets that needs to be achieved");
        int numTargets = sc.nextInt();

        // loop targetSize number of times
        for (int i = 0; i < numTargets; i++) {
            // Get TargetValue
            System.out.println("Enter the value of target");
            int targetValue = sc.nextInt();

            // start a new loop to calculate the sum
            int transactionSum = 0;
            int targetAchievedIndex = -1;
            for (int j = 0; j < transactions.length; j++) {
                transactionSum += transactions[j];
                if (transactionSum >= targetValue) {
                    //Break the loop if the target is achieved
                    targetAchievedIndex = j + 1;
                    break;
                }
            }

            // check if target is reached
            if (targetAchievedIndex != -1) {
                System.out.println("Target achieved after " + targetAchievedIndex + " transactions");
            } else {
                System.out.println("Given target is not achieved");
            }
            System.out.println();
        }
    }
}
