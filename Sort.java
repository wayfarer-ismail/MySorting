import java.util.Comparator;
import java.util.List;

public class Sort <T> {

    public static <T extends Comparable<T>> void quick(final List<T> input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void quick(final T[] input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void bogo(final List<T> input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void bogo(final T[] input, final Comparator<T> compartor) {

    }


    public static <T extends Comparable<T>> void insertion(final List<T> input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void insertion(final T[] input, final Comparator<T> compartor) {

    }


    public static <T extends Comparable<T>> void selection(final List<T> input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void selection(final T[] input, final Comparator<T> compartor) {

    }

    public static <T extends Comparable<T>> void bubble(final List<T> input, final Comparator<T> compartor) {
        for (int i = 0; i < input.size(); i++) {
            if (compartor.compare(input.get(i), input.get(i+1)) < 0) {
                T temp = input.get(i);
                input.set(i, input.get(i+1));
                input.set(i+1, temp);
            }
        }
    }

    public static <T extends Comparable<T>> void bubble(final T[] input, final Comparator<T> compartor) {

    }
}
