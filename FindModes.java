//Max Hite
/*On my honor as a student I have not given nor recieved any unauthorized assitance on this assignment*/

import java.util.*;
/*
This program will randomly generate a sequence of random numbers and
determine the mode(s) of the sequence
This is done using a partially-filled array of NumEntry objects. The
filled portion of the array is
sorted in descending order by frequency. Elements with the highest
frequency contain mode values.
@author Kimberly A. Baram
@version 3.0
*/
public class FindModes{
/**
are null
* Returns the first null index of data, or -1 if none of data's elements
*/
   public static int firstAvailable(NumEntry[] data){
      for (int i = 0; i < data.length; i++)
      {
         if(data[i] == null)
         {
            return i; 
         
         }
      }
      return -1;
   }
/**
* Prints only the non-null elements of data
*/
   public static void printArray(NumEntry[] data){
      for(int i = 0; i < data.length; i++)
      {
         if(data[i] != null)
         {
            System.out.println(data[i] + "   ");
         }
      }
   }
/**
* Returns the index of data in which num is the numerical value of the
entry, or
* -1 if there is no entry in data containing num as its value
*/
   public static int indexOf(NumEntry[] data, int num){
      for(int i = 0; i < data.length; i++)
      {
         if((data[i] != null) && (num == data[i].getValue()))
         {
            return i;
         }
      }
      return -1;
   }
/*
Checks to see if data contains an entry with a value of num.
If so, accesses that entry and records a copy.
If not, creates a new NumEntry object and stores it in the
first available index of data.
*/
   public static void addNumToData(NumEntry[] data, int num){
      int index = indexOf(data, num);
      if(index != -1)
      {
         data[index].recordCopy();
      }
      else
      {
         NumEntry temp = new NumEntry(num);
         index = firstAvailable(data);
         data[index] = temp;
      }
   
   }
/**
* Swaps data[a] with data[b]
*/
   public static void swap(NumEntry[] data, int a, int b){
      NumEntry c = new NumEntry(0);
      c = data[a];
      data[a] = data[b];
      data[b]=c; 
   }
/**
* Sorts the non-null elements of data by decreasing frequency order.
*/
   public static void sortByDescendingFrequency(NumEntry[] data){
         for(int i = 0; i < data.length - 1; i++)
         {
            for(int j = 1+1; j < data.length; j++)
            {
               if(data[i] != null && data[j] != null && data[i].getFrequency() < data[j].getFrequency())
               {
                  swap(data,i,j);
               }
            }
         }  
   }
/*
mode will be any element that
*/
//Prints the mode(s) of data. If the array is properly sorted, then a
//contains the same frequency as data[0]
   public static void printModes(NumEntry[] data){   
      System.out.print(data[0].getValue() + "            ");
      for(int i = 1; i < data.length; i++)
      {
         if(data[i] != null && data[i].getFrequency() == data[0].getFrequency())
         {
            System.out.print(data[i].getValue() + "         ");
         }
      }
   }
   public static void main(String[] args){
      NumEntry[] data = new NumEntry[15];
      System.out.println("Initial Data:");
      for (int i = 0; i < data.length; i++){
         int num = (int)(Math.random() * 10) + 1;
         addNumToData(data, num);
         System.out.print(num + "\t");
      }
      System.out.println();
      sortByDescendingFrequency(data);
      System.out.println("Array Data:");
      printArray(data);
      System.out.println();
      System.out.println("Modes:");
      printModes(data);
   }
}