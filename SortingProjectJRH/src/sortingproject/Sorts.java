/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class contains the sort methods for sorts performed on arrays and
 * ArrayLists. The sorts for LL are in that class.
 * 
 * This method also contains a final variable for list size.  Make sure you test on
 * lists of various sizes.
 * 
 * You need to implement these methods:
 * selectionSortOnArray(int[] list) 
 * insertionSortOnArray(int [] list) 
 * selectionSortOnArrayList(ArrayList<Integer> list)
 * radixSortOnArrayList(ArrayList<Integer> list)
 * 
 * These methods have already been implemented and need no changes:
 * public static int[] createUnsortedArray() 
 * public static ArrayList<Integer> createUnsortedArrayList()  
 * public static String getArrayString(int[] ary) 
 * 
 */
package sortingproject;

import java.util.ArrayList;

/**
 * @version Starter Code
 * @author Jack Hoeting
 */
public class Sorts {

    //You should change this size as you are testing your program
    final static int LIST_SIZE = 24;

    /**
     * Sorts the list using selection sort.
     * @param list array to be sorted
     */
    public static void selectionSortOnArray(int[] list) {
       for (int i = 0; i < list.length-1; i++)
       {//Calls the findSmallest method on the smallIndex and finds the index of the smallest element in the unsorted portion
          int smallIndex = findSmallest(list, i, list.length-1 );
       // swaps the values from the list
       int temp = list[i];
       list[i] = list[smallIndex];
       list[smallIndex] = temp;
       }
    }
    
    private static int findSmallest(int [] arr, int startIndex, int endIndex){
       for (int i = startIndex; i <= endIndex; i++)
     {
         if (arr[i] < arr[startIndex]) //we are comparing the elements at index i and smallestIndex 
             //to determine if the current element is smaller
         {
             startIndex = i; //if it is, we update the startIndex to index i 
         }
     }
       return startIndex;
    }

    /**
     * Sorts the list using insertion sort
     * @param list array to be sorted
     */
    public static void insertionSortOnArray(int [] list) {
        for (int i = 1; i < list.length; i++)
        {
            int j = i;
            //Insert list[i] into sorted part
            //stopping once list[i] in correct position
            while(j > 0 && list[j] < list[j-1])
            {
                //Swapping list[j] and list[j - 1]
                int temp = list[j];
                list[j] = list[j-1];
                list[j-1] = temp;
                j--;
            }
        }
    }

    /**
     * Sorts the list using selection sort
     * @param list ArrayList to be sorted
     */
    public static void selectionSortOnArrayList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++)
       {//Calls the findSmallest method on the smallIndex and finds the index of the smallest element in the unsorted portion
          int smallIndex = findSmallest(list, i, list.size()-1 );
       // swaps the values from the list
       int temp = list.get(i);
       list.set(i, list.get(smallIndex));
       list.set(smallIndex, temp);
       }
    }
    
    private static int findSmallest(ArrayList<Integer> list, int startIndex, int endIndex)
    {
        for (int i = startIndex; i <= endIndex; i++)
     {
         if (list.get(i) < list.get(startIndex)) //we are comparing the elements at index i and smallestIndex 
             //to determine if the current element is smaller
         {
             startIndex = i; //if it is, we update the startIndex to index i 
         }
     }
       return startIndex;
    }

    /**
     * Sorts the list using radix sort
     * @param list ArrayList to be sorted
     */
    public static void radixSortOnArrayList(ArrayList<Integer> list) {
        ArrayList<Integer> [] buckets = new ArrayList[10];
        //create an arraylist of 10 buckets
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        int maxDigits = RadixGetMaxLength(list); 
        // Start with the least significant digit
        int pow10 = 1;
        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++)
        {
            // Distribute elements into buckets
            for (int i = 0; i < list.size(); i++)
            {
                int bucketIndex = Math.abs(list.get(i) / pow10) % 10;
                buckets[bucketIndex].add(list.get(i));
            }
            
            // Merges elements from buckets back into the arraylist
        int listIndex = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                list.set(listIndex++, buckets[i].get(j));
            }
            // Clears the bucket
            buckets[i].clear();
        }

        // Move to the next digit
        pow10 = pow10 * 10;
        }
        
    }
    // // Returns the maximum length, in number of digits, out of all elements in the ArrayList
    public static int RadixGetMaxLength(ArrayList<Integer> list)
    {
        int maxDigits = 0;
        for (int i = 0; i < list.size(); i++)
        {
            //call the radixGetLength method to get the number of digits for the current element
            int digitCount = radixGetLength(list.get(i));
            // Updates the maxDigits if the current element has more digits
            if (digitCount > maxDigits) {
                maxDigits = digitCount;
            }
        }
        return maxDigits;
    }
    
    // Returns the length, in number of digits, of a value
    public static int radixGetLength(int value)
    {
        ////If the value is 0, it has one digit
       if (value == 0) 
       {
           return 1;
       }
       
       int digits = 0;
       // enters a while loop that continues as long as value is not equal to 0
       //increments the digit value
       while (value != 0)  
       {
           digits = digits + 1;
           value = value / 10; //Removes the last digit by dividing by 10
       }
       
       return digits;
    }
    
    
        
    
   
  
    /****************** Below methods already implemented ****************************/
    
    /**
     * Creates an array of LIST_SIZE that is filled with random integers between
     * 0 and 999.
     * @return unsorted array of random numbers
     */
    public static int[] createUnsortedArray() {
        int[] ary = new int[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            ary[i] = (int) (Math.random() * 1000);
        }
        return ary;
    }
    
    /**
     * Creates an ArrayList of LIST_SIZE that is filled with random integers between
     * 0 and 999.
     * @return unsorted ArrayList of random numbers
     */
    public static ArrayList<Integer> createUnsortedArrayList() {
        ArrayList<Integer> ary = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            ary.add( (int) (Math.random() * 1000) );
        }
        return ary;
    }

    /**
     * @return a string representation of array ary as "[ n1 n2 n3 ]"
     */
    public static String getArrayString(int[] ary) {
        String s = "[ ";
        for (int i = 0; i < ary.length; i++) {
            s += ary[i] + " ";
        }
        s += "]";
        return s;
    }
}
