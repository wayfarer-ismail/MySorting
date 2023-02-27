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
}
