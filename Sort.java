import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort <T> {

    public static <T extends Comparable<T>> void bogo(final List<T> input, final Comparator<T> comparator) {

    }

    public static <T extends Comparable<T>> void bogo(final T[] input, final Comparator<T> comparator) {

    }


    public static <T extends Comparable<T>> void insertion(final List<T> input, final Comparator<T> comparator) {

    }

    public static <T extends Comparable<T>> void insertion(final T[] input, final Comparator<T> comparator) {

    }


    public static <T extends Comparable<T>> void selection(final List<T> input, final Comparator<T> comparator) {

    }

    public static <T extends Comparable<T>> void selection(final T[] input, final Comparator<T> comparator) {

    }

    public static <T extends Comparable<T>> void bubble(final List<T> input, final Comparator<T> comparator) {
        for (int i = 0; i < input.size()-1; i++) {
            for (int j = 1; j < input.size()-i; j++) {
                if (comparator.compare(input.get(j-1), input.get(j)) > 0) {
                    T temp = input.remove(j-1);
                    input.add(j, temp);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubble(final T[] input, final Comparator<T> comparator) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length-i; j++) {
                if (comparator.compare(input[j-1], input[j]) > 0) {
                    T temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }

    /**
     * recursively sorts a list by splitting it into two roughly equal halves until the list only contains 1 element
     *  and then merging them,
     *
     * Time complexity:
     * Best case: O(log n), due to the optimisation in the helper function the merge method is not called if
     *      both arrays are sorted so there are log(n) calls to the helper function and log(n) comparisons.
     * Average case: O(n log n)
     * Worst case: O(n log n) the regular case between best and worst.
     * These two values are the same due to the fact that the list is split in half each time regardless of how
     *      sorted it is and that is log(n), and the merge function is O(n) because it has to compare all elements in
     *      both lists to merge them.
     *
     */
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        if (list == null || list.size() == 0) {
            return;
        }
        mergeSortHelper(list, comparator, 0, list.size() - 1);
    }

    /**
     * recursively sorts a list by splitting it into two roughly equal halves until the list only contains 1 element
     */
    private static <T extends Comparable<T>> void mergeSortHelper(List<T> list, Comparator<T> comparator, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2; //find the middle of the list
            mergeSortHelper(list, comparator, lo, mid);         //sort left half
            mergeSortHelper(list, comparator, mid + 1, hi); //sort right half

            if (comparator.compare(list.get(mid), list.get(mid + 1)) > 0)
                merge(list, comparator, lo, mid, hi);
        }
    }

    /**
     * merges two sorted segments of a list using an auxiliary list
     * @param lo - lower index
     * @param mid - middle index, last element of the left list
     * @param hi - higher index
     */
    private static <T extends Comparable<T>> void merge(List<T> list, Comparator<T> comparator, int lo, int mid, int hi) {
        List<T> temp = new ArrayList<T>(hi - lo + 1);

        //copy into the aux array only the required elements
        for (int i = lo; i <= hi; i++) {
            temp.add(list.get(i));
        }

        int i = 0;  //index of left list
        int j = mid + 1 - lo; //index of right list
        int k = lo; //index used for the aux list

        while (i <= mid -lo && j <= hi - lo) {
            if (comparator.compare(temp.get(i), temp.get(j)) <= 0) { //if the left element is smaller or equal to the right element
                list.set(k, temp.get(i++));
            } else {
                list.set(k, temp.get(j++));
            }
            k++;
        }

        while (i <= mid -lo) {
            list.set(k++, temp.get(i++));
        }
    }

    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSortHelper(array, comparator,0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSortHelper(final T[] array, final Comparator<T> comparator, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSortHelper(array, comparator, lo, mid);
            mergeSortHelper(array, comparator, mid + 1, hi);

            if (comparator.compare(array[mid], array[mid + 1]) > 0)
                merge(array, comparator, lo, mid, hi);
        }
    }


    private static <T extends Comparable<T>> void merge(T[] array, final Comparator<T> comparator, int lo, int mid, int hi) {
        T[] temp = (T[]) new Comparable[hi - lo + 1];

        //copy into the aux array only the required elements
        if (hi > lo) System.arraycopy(array, lo, temp, 0, hi - lo + 1);

        int i = 0;       //increments from left index to middle
        int j = mid + 1 -lo; //increments from middle index to right
        int k = lo;     //the index used to load elements into the aux array
        while (i <= mid -lo && j <= hi -lo) {
            if (comparator.compare(temp[i], temp[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid -lo) {
            array[k++] = temp[i++];
        }
    }

    /**
     * recursively sorts a list by moving all elements smaller than the pivot to the left and
     * all elements greater than the pivot to the right and then sorts each half recursively,
     * this implementation picks the first element as the pivot each time for simplicity
     *
     * Time complexity:
     * Best case: O(n log n) The best case occurs when the pivot is always the median element in the list,
     * Average case: O(2 ln n) This figure is between the best and worst case.
     * Worst case: O(1/2 n^2)  The worst case occurs when the pivot is always the smallest or largest element in the list,
     *      which causes the list to be split into two lists of size n-1 and 0, which is O(1/2 * n^2)
     */
    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        if (list == null || list.size() <= 1) return;

        quickSortHelper(list, comparator, 0, list.size() - 1, 0);
    }

    /**
     * partitions a list around a pivot element by moving all elements smaller than the pivot to the left and
     * all elements greater than the pivot to the right and then switching the pivot with the element at the right pointer,
     * then sorts each half recursively
     */
    private static <T extends Comparable<T>> void quickSortHelper(final List<T> list, final Comparator<T> comparator, int lo, int hi, int pivot) {
        if (lo < hi) {
            int p = partition(list, comparator, lo, hi, pivot); //sort the array according to the pivot and return its new location
            //element at p is now in its final position, sort the left and right halves
            quickSortHelper(list, comparator, lo, p - 1, lo);
            quickSortHelper(list, comparator, p + 1, hi, p+1);
        }
    }

    /**
     * partitions a list around a pivot element by moving all elements smaller than the pivot to the left and
     * all elements greater than the pivot to the right and then switching the pivot with the element at the right pointer
     * @param lo - lower index
     * @param hi - higher index
     * @param pivot - index of the pivot element
     * @return index of the pivot element after the partition
     */
    private static <T extends Comparable<T>> int partition(List<T> list, Comparator<T> comparator, int lo, int hi, int pivot) {
        int i = lo, j = hi; //set i as the left pointer and j as the right pointer

        while (i <= j) {    //while the pointers don't cross
            if (comparator.compare(list.get(i), list.get(pivot)) <= 0) {      //if the element at i is less than the pivot (in position), move i to the right
                i++;
            } else if (comparator.compare(list.get(j), list.get(pivot)) > 0) { //if the element at j is greater than the pivot (in position), move j to the left
                j--;
            } else { //if the element at i is greater than the pivot and the element at j is less than the pivot, swap them
                swap(list, i++, j--);
            }
        }
        //– no larger entry to the left of j
        //– no smaller entry to the right of j
        swap(list, pivot, j);   //swap the pivot with the element at j
        return j;
    }

    private static <T extends Comparable<T>> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSortHelper(array, comparator,0, array.length - 1, 0);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] array, Comparator<T> comparator, int lo, int hi, int pivot) {
        if (lo < hi) {
            int p = partition(array, comparator, lo, hi, pivot); //sort the array according to the pivot and return its new location
            quickSortHelper(array, comparator, lo, p - 1, lo);
            quickSortHelper(array, comparator, p + 1, hi, p+1);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, Comparator<T> comparator, int lo, int hi, int pivot) {

        int i = lo, j = hi; //set i as the left pointer and j as the right pointer

        while (i <= j) {    //while the pointers don't cross
            if (comparator.compare(array[i], array[pivot]) <= 0) {      //if the element at i is less than the pivot (in position), move i to the right
                i++;
            } else if (comparator.compare(array[j], array[pivot]) > 0) { //if the element at j is greater than the pivot (in position), move j to the left
                j--;
            } else {        //if the element at i is greater than the pivot and the element at j is less than the pivot, swap them
                swap(array, i++, j--);
            }
        }
        //– no larger entry to the left of j
        //– no smaller entry to the right of j
        swap(array, pivot, j); //move the pivot to its final place
        return j; //return the pivot's final place
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
