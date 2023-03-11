import java.util.Comparator;
import java.util.List;

public class Sort <T> {

    public static <T extends Comparable<T>> void quick(final List<T> input, final Comparator<T> comparator) {

    }

    public static <T extends Comparable<T>> void quick(final T[] input, final Comparator<T> comparator) {

    }

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
            merge(array, comparator, lo, mid, hi);
        }
    }


    private static <T extends Comparable<T>> void merge(T[] array, final Comparator<T> comparator, int lo, int mid, int hi) {
        T[] temp = (T[]) new Comparable[array.length];

        //copy into the aux array only the required elements
        if (hi + 1 - lo >= 0) System.arraycopy(array, lo, temp, lo, hi + 1 - lo);

        int i = lo;       //increments from left index to middle
        int j = mid + 1; //increments from middle index to right
        int k = lo;     //the index used to load elements into the aux array
        while (i <= mid && j <= hi) {
            if (comparator.compare(temp[i], temp[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }
}
