package csd201_as1_thienhtfx17332.funix.edu.vn;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main_Sort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);    
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        float[] arr = new float[n];
        System.out.println("Enter element: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextFloat();
        }
        String filename = "input.txt";
        int choice; 
        Algorithm algorithm = new  Algorithm();        
        while(true){
            System.out.println("+-------------------Menu------------------+");
            System.out.println("|  1. Input                               |");
            System.out.println("|  2. Output                              |");
            System.out.println("|  3. Bubble Sort                         |");
            System.out.println("|  4. Selecttion Sort                     |");
            System.out.println("|  5. Insertion Sort                      |");
            System.out.println("|  6. Linear Search                       |"); 
            System.out.println("|  7. Binary Search                       |"); 
            System.out.println("|  8. Time To Run Tree Algorithm          |");
            System.out.println("|  0. Exit                                |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Your selection (0 -> 8): ");
            choice = sc.nextInt();            
            System.out.println("Choice: " + choice);            
            if(choice == 0){
                
                System.out.println("Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1:                    
                    algorithm.writeFile(filename, arr);
                    break;
                case 2: 
                    algorithm.readFile(filename);
                    break;
                case 3:
                    algorithm.bubbleSort(arr);                    
                    break;                    
                 case 4:
                    algorithm.selectionSort(arr);                    
                    break;
                 case 5: 
                   algorithm.insertionSort(arr);                    
                    break; 
                 case 6:
                    System.out.print("Input value: ");
                    float x = sc.nextFloat();
                    algorithm.linearSearch(arr, x);                    
                    break;
                 case 7: 
                    int left = 0;
                    int right = arr.length -1;
                    System.out.print("Input value: ");
                    float value = sc.nextFloat();
                    algorithm.bSearch(arr, left, right, value);
                    break;
                 case 8:
                     algorithm.calcTimeToRunTreeAlgorithm();
                     break;
                default:
                    System.out.println("Invalid choice. Try again.  ");
            }
        }
    }
}
