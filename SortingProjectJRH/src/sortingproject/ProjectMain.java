/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class is your driver class. It will control the flow of your program.
 * It holds the code for testing whether different components work.
 *
 * While no code in this file needs to be changed, you should plan to comment out
 * sections that you are not ready to test. Because of how this is written, simply
 * comment out the method calls in main.
 */
package sortingproject;

import java.util.ArrayList;

/**
 * @version starter code
 * @author timmermank1
 */
public class ProjectMain {

    public static void main(String[] args) {

        
        testingDCircularLL();

       
    }

    /**
     * Method tests the selection sort and insertion sort on Arrays.
     */
    private static void testArraySorts() {
        System.out.println("*** TESTING ARRAY SORTING METHODS ***\n");
        //create lists
        int[] array = Sorts.createUnsortedArray();

        //Selection Sort
        System.out.println("\nSelection Sort");
        System.out.println("Before: " + Sorts.getArrayString(array));
        Sorts.selectionSortOnArray(array);
        System.out.println("After:  " + Sorts.getArrayString(array));
        System.out.println("\n");

        array = Sorts.createUnsortedArray();
        System.out.println("Insertion Sort");
        System.out.println("Before: " + Sorts.getArrayString(array));
        Sorts.insertionSortOnArray(array);
        System.out.println("After:  " + Sorts.getArrayString(array));
        System.out.println("\n\n");
    }

    /**
     * This method tests selection and radix sort on ArrayLists.
     */
    private static void testArrayListSorts() {
        System.out.println("*** TESTING ARRAYLIST SORTING METHODS ***\n");
        //create lists
        ArrayList<Integer> arrayList = Sorts.createUnsortedArrayList();

        //Selection Sort
        System.out.println("Selection Sort");
        System.out.println("Before: " + arrayList);
        Sorts.selectionSortOnArrayList(arrayList);
        System.out.println("After:  " + arrayList);
        System.out.println("\n");

        arrayList = Sorts.createUnsortedArrayList();

        //Radix Sort
        System.out.println("Radix Sort");
        System.out.println("Before: " + arrayList);
        Sorts.radixSortOnArrayList(arrayList);
        System.out.println("After:  " + arrayList);

    }

    /**
     * This method tests the functionality of DCircularLL
     */
    private static void testingDCircularLL() {

        System.out.println("*** TESTING CONSTRUCTOR ***");
        DCircularLL list = new DCircularLL();
        System.out.println("List should be []: " + list);

        System.out.println("\n*** TESTING ADD ***");
        list.add(12);
        list.add(10);
        System.out.println("The list should be [10 12]: " + list);

        System.out.println("\n*** TESTING APPEND ***");
        list.append(14);
        System.out.println("The list should be [10 12 14]: " + list);

        System.out.println("\n*** TESTING REMOVE(ITEM) ***");
        list.remove(10);
        System.out.println("The list should be [12 14]: " + list);

        System.out.println("\n*** TESTING REMOVE ***");
        list.remove();
        System.out.println("The list should be [14]: " + list);

        System.out.println("\n*** TESTING REMOVE(ITEM) on 1-item list ***");
        list.remove(14);
        System.out.println("The list should be []: " + list);
        
        System.out.println("\n*** TEST ADD on Empty LIST ***");
        list.add(6);
        System.out.println("The list should be [6]: " + list);
        
        System.out.println("\n*** REMOVING ONLY ELEMENT IN LIST ***");
        list.remove();
        System.out.println("The list should be []: " + list);
        
        System.out.println("\n*** TESTING APPEND TO EMPTY LIST ***");
        list.append(50);
        System.out.println("The list should be [50]: " + list);
        
        System.out.println("\n*** TESTING ADD AFTER REMOVE ***");
        list.add(12);
        list.add(8);
        System.out.println("The list should be [8 12 50]: " + list);

        System.out.println("\n*** TESTING INDEXOF ***");
        System.out.println("The index of 8 should be 0: " + list.indexOf(8));
        System.out.println("The index of 50 should be 2: " + list.indexOf(50));
        System.out.println("The index of 9 should be -1: " + list.indexOf(9));

        System.out.println("\n*** TESTING INDEXOF AFTER REMOVE ***");
        list.remove(12);
        System.out.println("The list should be [8 50]: " + list);
        System.out.println("The index of 12 should be -1: " + list.indexOf(12));

        System.out.println("\n*** TESTING EMPTY ***");
        list.empty();
        System.out.println("The list should be []: " + list);
        System.out.println("The index of 8 should be -1: " + list.indexOf(8));

        System.out.println("\n*** TESTING METHODS AFTER EMPTY ***");
        list.add(6);
        list.append(9);
        list.add(4);
        list.add(3);
        list.add(2);
        list.append(10);

        System.out.println("The list should be [2 3 4 6 9 10]: " + list);
        list.remove(2);
        System.out.println("The list should be [3 4 6 9 10]: " + list);
        list.remove(10);
        System.out.println("The list should be [3 4 6 9]: " + list);

        System.out.println("The index of 2 should be -1: " + list.indexOf(2));
        System.out.println("The index of 10 should be -1: " + list.indexOf(10));
        System.out.println("The index of 3 should be 0: " + list.indexOf(3));
        System.out.println("The index of 9 should be 3: " + list.indexOf(9));
        System.out.println("\n\n\n");
    }// End test LL method

    /**
     * This method tests insertion sort and radix sort on DCircularLL
     */
    private static void testLinkedListSorts() {
        System.out.println("*** TESTING LINKEDLIST SORTING METHODS ***\n");

        //create lists
        DCircularLL list = DCircularLL.createUnsortedLL();

        //Insertion Sort
        System.out.println("Insertion Sort");
        System.out.println("Before: " + list);
        list.insertionSort();
        System.out.println("After:  " + list);
        System.out.println("\n");

        //Radix Sort
        list = DCircularLL.createUnsortedLL();
        System.out.println("Radix Sort");
        System.out.println("Before: " + list);
        list.radixSort();
        System.out.println("After:  " + list);

    }// end test LL sorts
}
