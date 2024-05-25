package com.example.Attendence;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String s1 = "09:10:15";
        String s2 = "17:05:10";

        int[] arr =  calculateTime(s1,s2);
        for(int time :arr){
            System.out.print(time+" : ");
        }

    }

    public static int[] calculateTime(String in, String out){
         String[] arr1 = in.split(":");
        String[] arr2 = out.split(":");
        int[] ans = new int[3];



// Create integer arrays to store the converted values
        int[] Arr1 = new int[arr1.length];
        int[] Arr2 = new int[arr2.length];

// Convert string arrays to integer arrays
        for (int i = 0; i < arr1.length; i++) {
            Arr1[i] = Integer.parseInt(arr1[i]);
            System.out.print("arr1 "+Arr1[i]);
        }
        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            Arr2[i] = Integer.parseInt(arr2[i]);
            System.out.print( "arr2 "+Arr2[i]);

        }

        System.out.println();

         int i = Arr1.length-1;
         int j = Arr2.length-1;

         while(i>=0){
            int In = Arr1[i];
            int Out = Arr2[j];
             if(Out<In){
                 Arr2[j] = Arr2[j-1]-1;
                 Arr2[j]+=60;
             }
             ans[i] = Arr2[j]-Arr1[i];
             i--;
             j--;

         }


        return ans;
    }
}
