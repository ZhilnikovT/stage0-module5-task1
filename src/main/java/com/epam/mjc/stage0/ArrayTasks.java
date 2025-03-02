package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = new String[] {"winter", "spring", "summer", "autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++){
            numbers[i] = i+1;
            //System.out.println(numbers[i]);
        }
        return numbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        //System.out.println(sum);
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++){
            
            if(arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        int center = arr.length/2;
        for (int i = 0; i < center; i++){
            String current = arr[(arr.length - 1) - i];
            arr[(arr.length - 1) - i] = arr[i];
            arr[i] = current;
        }
//        for (int i = 0; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }
        
        return arr;
    }
    
    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
             int[] currentArr = new int[arr.length];
        for (int i = 0; i < currentArr.length; i++){
           currentArr[i] = 0;
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                currentArr[j] = arr[i];
                j++;
            }
        }
        int[] newArr = new int[j];
        for (int i = 0; i < j; i++){
            newArr[i] = currentArr[i];
            System.out.println(newArr[i]);
        }
        return newArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
          
        class Foo {
            public int[] sort(int[] arr1D) {
                int[] newArr1D = new int[arr1D.length];
                
                boolean[] b = new boolean[arr1D.length];
                for(int i = 0; i < newArr1D.length; i++){ b[i] = true; }
                
                int aMax, aMin, iMax = -1, iMin = -1;
                int midle = newArr1D.length/2 + 1;
                
                for(int k = 0; k <= midle; k++){
                    aMin = 2147483647;
                    aMax = -2147483646;
                    for(int i = 0; i < arr1D.length; i++){
                        if(b[i]){
                            if(aMax < arr1D[i]){
                                aMax = arr1D[i];
                                iMax = i;      
                            }
                            if(aMin > arr1D[i]){
                                aMin = arr1D[i];
                                iMin = i;      
                            }
                        }
                    }
                    if(aMin != 2147483647 || aMax != -2147483646){
                        b[iMax] = false;
                        b[iMin] = false;
                        newArr1D[k] = aMin;
                        newArr1D[arr1D.length - 1 - k] = aMax;
                    }
                }
                return newArr1D;
            }
        };
        
        for(int i = 0; i < arr.length; i++){
            int[] sortArray = new int[arr[i].length];
            Foo f = new Foo();
            sortArray = f.sort(arr[i]);
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = sortArray[j];
                //System.out.println("arr[" + i + "] [" + j + "] = " + arr[i][j]);
            }
        }
        
        
        int[] sortFline = new int[arr.length];

        for(int j = 0; j < arr.length; j++){
            sortFline[j] = arr[j].length;
        }
        Foo f = new Foo();
        sortFline = f.sort(sortFline);
        for(int j = 0; j < sortFline.length; j++){
                //System.out.println("sortFline[" + j + "] = " + sortFline[j]);
            } 
        
        boolean[] c = new boolean[sortFline.length];
        
        
        int[][] arrOut = new int[sortFline.length][];
        for(int i = 0; i < arrOut.length; i++){ c[i] = true; }
        
        for(int i = 0; i < arrOut.length; i++){
            for(int ii = 0; ii < arrOut.length; ii++){
                if(sortFline[i] == arr[ii].length && c[ii]){
                    arrOut[i] = new int[arr[ii].length]; 
                    for(int j = 0; j < arr[ii].length; j++){
                        arrOut[i][j] = arr[ii][j];
                        c[ii] = false;
                    }
                }
            }
        }
        
        //for(int i = 0; i < arrOut.length; i++){
            //for(int j = 0; j < arrOut[i].length; j++){
                //System.out.println("arrOut[" + i + "] [" + j + "] = " + arrOut[i][j]);
            //}
        //}
        
        return arrOut;
    }
}
