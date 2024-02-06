

public class StringOps {
    int counts;

    public int linearSearch(String[] array, String query, int l, int r) {
        //checks each individual index for passed query and returns the index number if found
        for (int i = l; i < r; i++){
            if (array[i].equals(query)){
                return i;
            }
        }
        // returns -1 if the query is not in the array
        return -1;
    }


    public int binarySearch(String[] sortedArray, String query, int l, int r) {
        // variable stores the middle index (to left value if an even number)
        int mid = (r+l)/2;

        // checks if index matches query
        if (query.equals(sortedArray[mid])) {
            return mid;

        // edge case if no query is found
        } else if (l >= r) {
            return -1;

        // calls function again if the value of the comparison is less than 0
        // passes mid as new right value
        } else if (query.compareTo(sortedArray[mid]) < 0){
            return binarySearch(sortedArray, query, l, mid - 1);

        // calls function again if the value of the comparison is less than 0
        // passes mid as new right value
        } else if (query.compareTo(sortedArray[mid]) > 0) {
            return binarySearch(sortedArray, query, mid + 1, r);

        }
        return 0;
    }


    public void swapemSort(String[] array) {
        // initialize variable to call

        String tempHolder;
        int counter = 1;
        while (counter > 0) {
            counter = 0;

            // loops over array and swaps two places if their order is off
            // continues to loop until process is done
            for (int i = 1; i < array.length; i++) {
                if (array[i-1].compareTo(array[i])>0){
                    tempHolder = array[i];
                    array[i] = array[i-1];
                    array[i-1] = tempHolder;
                    counter++;
                }
            }
        }
        return;
    }


    public void insertSort(String[] array) {
        // initialize temporary holder of index value
        String temp;

        // loops over array with another loop for each index
        for (int i = 1; i < array.length; i++ ){
            int j = i;
            temp = array[j];

            // compares the value of each index before
            // moves the up the array and inserts current value in correct index
            while ( j > 0 && (array[j-1].compareTo(temp) > 0)){
                array[j] = array[j-1];
                array[j-1] = temp;
                j = j-1;

            }
        }

         return;
    }

    /**
     * _ Part 5: Implement this method _
     *
     * Approach:
     * Do this in two stages.
     *
     * For the first stage, create an array big enough to hold all
     * items in both array1 and array2, and fill it with unique items
     * from array1 and array2.
     *
     * For the second stage, create an array just big enough for the
     * unique items and copy them from the array created in the previous
     * step
     *
     * Hint: should you generally use equals() or == with Strings?
     *
     * NOTE:
     * You should only use String arrays and primitive types
     * for your implementation.
     *
     * @param array1 - the first array of Strings
     * @param array2 - the second array of Strings
     * @return a new array holding all unique items in array1 and array2
     */
    public String[] union(String[] array1, String[] array2) {
        // TODO: implement this
        return null;
    }

    /**
     * _ Part 6: Implement this method _
     *
     * Approach:
     * Do this in two stages.
     *
     * For the first stage, create an array big enough to hold all
     * items in the smaller of array1 or array2, and fill it items that
     * occur in both arrays. However, the resulting array should be
     * a set (only contain unique items) even if array1 or array2 is
     * not a set.
     *
     * For the second stage, create an array just big enough for the
     * items above and copy them from the array created in the previous
     * step
     *
     * Hint: should you generally use equals() or == with Strings?
     * Hint: use Math.min
     *
     * NOTE:
     * You should only use String arrays and primitive types
     * for your implementation.
     *
     * @param array1 - the first array of Strings
     * @param array2 - the second array of Strings
     * @return a new array holding items that occur in both array1 and array2
     */
    public String[] intersection(String[] array1, String[] array2) {
        // TODO: implement this
        return null;
    }

}
