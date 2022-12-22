package csd201_as1_thienhtfx17332.funix.edu.vn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Algorithm {
    public void writeFile(String fileName, float arr[]) throws FileNotFoundException, IOException{      
        try {
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i] + " ");   
            }
            System.out.println("Input number of elements: " + arr.length);
            System.out.print("Input elements: " );
            display(arr);
            fw.close();
        } catch (Exception e)  {
            System.out.println(e);
        }
        
    }
    /**
     * FileReader return byte type
     * BufferedReader read data from FileReader return
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public float[] readFile(String fileName) throws FileNotFoundException, IOException{ 
        FileReader fr = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(fr);         
        String s = bf.readLine();
        String[] s1 = s.split("\\s");            
        float[] arr = new float[s1.length];
        for (int i = 0; i < s1.length; i++) {
             arr[i] = Float.parseFloat(s1[i]);
        }   
        System.out.println("Read from file");
        System.out.print("Array a: ");
        display(arr);
        bf.close();
        fr.close();
        return arr;
    }
    public void display(float arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    /**
     * len - 1 - i: i is value after sorted 
     * @param arr
     * @return
     * @throws IOException 
     */
    public float[] bubbleSort(float arr[]) throws IOException{
        float[] bSArr =  new float[arr.length];
        copyArrAToArrB(arr, bSArr);
        int len = bSArr.length;
        System.out.println("Bubble sort: ");
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(bSArr[j] > bSArr[j + 1]){
                    float tmp = bSArr[j];
                    bSArr[j] = bSArr[j + 1];
                    bSArr[j+1] = tmp;                    
                }
            }            
            display(bSArr);            
        }
        String fileName = "OUTPUT1.TXT";
        writeArray(fileName, bSArr);
        return bSArr;
    }
    public  void writeArray(String fileName, float arr[]){
        try {
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i] + " ");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public float[] selectionSort(float arr[]){
        float[] sLArr = new  float[arr.length];
        copyArrAToArrB(arr, sLArr);
        int len = sLArr.length;
        System.out.println("Selection sort: ");
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(sLArr[j] < sLArr[minIndex]){
                    minIndex = j;
                }                
            }
            if(minIndex != i){
                float tmp = sLArr[minIndex];
                sLArr[minIndex] = sLArr[i];
                sLArr[i] = tmp;
            } 
            display(sLArr);
        }
        String fileName = "OUTPUT2.TXT";
        writeArray(fileName, sLArr);
        return sLArr;    
    }
    public  float[] insertionSort(float arr[]){
        float[] iSArr = new float[arr.length];
        copyArrAToArrB(arr, iSArr);
        int len = iSArr.length;
        System.out.println("Insertion sort: ");
        for (int i = 0; i < len; i++) {
            float tmp = iSArr[i];
            int j = i - 1;
            while(j >= 0 && tmp < iSArr[j]){
                iSArr[j + 1] = iSArr[j];
                j--;                
            }   
            iSArr[j+1] = tmp;
            display(iSArr);
        }
        String fileName = "OUTPUT3.TXT";
        writeArray(fileName, iSArr);
        return iSArr;
    }
    public void linearSearch(float arr[], float x){
        int len = arr.length;
        float[] arr1 = new float[arr.length];
        int j = 0;         
        System.out.print("Index: ");
        for (int i = 0; i < len; i++) {
            if(arr[i] > x){
                arr1[j++] = i;
                System.out.print(i + " ");  
            }            
        }
        if(j <= 0){
            System.out.println("Not found value.");
        }  
        String fileName = "OUTPUT4.TXT";
        writeArray(fileName, arr1);
        System.out.println("");
    }
    public void copyArrAToArrB(float arrA[], float arrB[]){
        for (int i = 0; i < arrA.length; i++) {
             arrB[i]= arrA[i];
        }
    }
    /**
     * if arr[mid] < value, it's mean value need to find at right of mid
     * if arr[mid] > value, it's mean value need to find at left of mid
     * arr[left] == value return first element == value
     * return -1, it's mean not found value in the array
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return 
     */
    public int binarySearch(float arr[], int left, int right, float value){
        arr = selectionSortCalc(arr);      
        while(left < right){
            int mid = (left + right)/2;
            if(arr[mid] < value){
                left = mid + 1;
            }else{
                right = mid;
            }     
        }
        if(arr[left] == value ){
            return left;           
        }
        return -1;
    }
    public void bSearch(float arr[], int left, int right, float value) throws IOException{
        float result = binarySearch(arr, left, right, value);
        String fileName = "OUTPUT5.TXT";
        FileWriter fw = new FileWriter(fileName);
        if(result == -1){
            System.out.println("Not found value.");
        }else{
            int index = (int)result;            
            System.out.println("Index of first element: " + index);    
            String str = String.valueOf(index);            
            fw.write(str);
            fw.close();
        }
    }
    /**
     * function to create random array with 1000 element
     * @return 
     */
    public float[] createRandomArr(){       
        float[] arr = new float[1000];
        Random rd = new Random();
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] < arr.length){
                arr[i] = rd.nextInt(1000);
            }
        }
        return  arr;
    }
    /**
     * function to sort array from big to small
     * use selection sort
     * @param arr 
     */
    public void selecttionSortArrayBigToSmall(float arr[]){
        float[] sLArr = new  float[arr.length];       
        int len = sLArr.length;
            for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(sLArr[j] > sLArr[minIndex]){
                    minIndex = j;
                }                
            }
            if(minIndex != i){
                float tmp = sLArr[minIndex];
                sLArr[minIndex] = sLArr[i];
                sLArr[i] = tmp;
            }             
        }       
    }
    /**
     * function to sort half array
     * use selection sort
     * @param arr
     * @return 
     */
    public float[] arrayDataSorted(float arr[]){
        float[] sLArr = new  float[arr.length];       
        int len = (sLArr.length);
            for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(sLArr[j] > sLArr[minIndex]){
                    minIndex = j;
                }                
            }
            if(minIndex != i){
                float tmp = sLArr[minIndex];
                sLArr[minIndex] = sLArr[i];
                sLArr[i] = tmp;
            }             
        }
        return arr;
    }
    public void calcTimeToRunTreeAlgorithm() throws IOException{
        calcBigToSmallData();
        calcSortedData();
        calcRandomData();
    }
    public void calcBigToSmallData() throws IOException{        
        //create random array
        float[] arr = createRandomArr();
        //use selection sort to sort array big to small
        selecttionSortArrayBigToSmall(arr);
        //copy random array to arr1
        float[] arr1 = new float[arr.length];
        copyArrAToArrB(arr, arr1);
        //copy random array to arr2
        float[] arr2 = new float[arr.length];
        copyArrAToArrB(arr, arr2);
        //copy random array to arr3
        float[] arr3 = new float[arr.length];
        copyArrAToArrB(arr, arr3); 
        //calculate insertion sort
        long startTime = System.nanoTime();
        insertionSortCalc(arr1);
        long endTime = System.nanoTime();
        long time = endTime - startTime; 
        //calculate seletion sort 
        long startTime1 = System.nanoTime();
        selectionSortCalc(arr2);
        long endTime1 = System.nanoTime();
        long time1 = endTime1 - startTime1;  
        //calculate bubble sort  
        long startTime2 = System.nanoTime();
        bubbleSortCalc(arr3);
        long endTime2 = System.nanoTime();
        long time2 = endTime2 - startTime2;
        System.out.println("Time BigtoSmall data insertion Sort: " + time + " nano second");
        System.out.println("Time BigtoSmall data selection Sort: " + time1 + " nano second");
        System.out.println("Time BigtoSmall data Buble Sort: " + time2 + " nano second");  
        System.out.println("");
    }
    public void calcSortedData() throws IOException{
        float[] arr = createRandomArr();        
        //sort array and copy array to ensure use the same data
        arrayDataSorted(arr);
        float[] arr1  = new float[arr.length];
        copyArrAToArrB(arr, arr1);
        float[] arr2 = new float[arr.length];
        copyArrAToArrB(arr, arr2);
        float[] arr3 = new float[arr.length];
        copyArrAToArrB(arr, arr3);
        //insertionSort
        long startTime = System.nanoTime();
        insertionSortCalc(arr1);
        long endTime = System.nanoTime();
        long time = endTime - startTime;        
        //selectionSort
        long startTime1 = System.nanoTime();
        selectionSortCalc(arr2);
        long endTime1 = System.nanoTime();
        long time1 = endTime1 - startTime1;        
        //Bubble sort       
        long startTime2 = System.nanoTime();
        bubbleSortCalc(arr3);
        long endTime2 = System.nanoTime();
        long time2 = endTime2 - startTime2;
        System.out.println("Time Data Sorted with insertion Sort: " + time + " nano second");
        System.out.println("Time Data Sorted with selection Sort: " + time1 + " nano second");
        System.out.println("Time Data Sorted with bubble Sort: " + time2 + " nano second");
        System.out.println("");
    }
    public void calcRandomData() throws IOException{
        //create random data
        float[] arr = createRandomArr(); 
        //copy array to ensure use the same data
        float[] arr1 = new float[arr.length];
        copyArrAToArrB(arr, arr1);
        float[] arr2 = new float[arr.length];
        copyArrAToArrB(arr, arr2);
        float[] arr3 = new float[arr.length];
        copyArrAToArrB(arr, arr3);        
        //insertionSort
        long startTime = System.nanoTime();
        insertionSortCalc(arr1);
        long endTime = System.nanoTime();
        long time = endTime - startTime;                
        //selectionsort
        long startTime1 = System.nanoTime();
        selectionSortCalc(arr2);
        long endTime1 = System.nanoTime();
        long time1 = endTime1 - startTime1;        
        //Bubble sort
        long startTime2 = System.nanoTime();
        bubbleSortCalc(arr3);
        long endTime2 = System.nanoTime();
        long time2 = endTime2 - startTime2;
        System.out.println("Time random data insertionSort: " + time + " nano second");
        System.out.println("Time random data SelectionSort: " + time1 + " nano second");
        System.out.println("Time random data Bubble sort: " + time2 + " nano second");
    }
    /**
     * function use calculate time run algorithm, don't display array after sort and don't write to file
     * @param arr
     * @return
     * @throws IOException 
     */
     public float[] bubbleSortCalc(float arr[]) throws IOException{        
        int len = arr.length;
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    float tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = tmp;                    
                }
            }           
        }
        return arr;
    }
     /**
      * function use calculate time run algorithm, don't display array after sort and don't write to file
      * @param arr
      * @return 
      */
     public float[] selectionSortCalc(float arr[]){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }                
            }
            if(minIndex != i){
                float tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;    
    }
     /**
      * function use calculate time run algorithm, don't display array after sort and don't write to file
      * @param arr
      * @return 
      */
     public  float[] insertionSortCalc(float arr[]){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            float tmp = arr[i];
            int j = i - 1;
            while(j >= 0 && tmp < arr[j]){
                arr[j + 1] = arr[j];
                j--;                
            }
            arr[j+1] = tmp;
        }
        return arr;
    }         
    
}
