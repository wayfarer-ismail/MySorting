import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    Comparator<Integer> comparator = (x, y) -> x > y? 1: x < y? -1: 0;

    @Test
    void bubbleList() {
        List<Integer> list = generateRandomList(10);
        List<Integer> sortedList = new ArrayList<>(list);

        Sort.bubble(list, comparator);
        sortedList.sort(Integer::compareTo);

        assertEquals(sortedList, list);
    }

    @Test
    void bubbleList2() {
        List<Integer> list = generateRandomList(1000);
        List<Integer> sortedList = new ArrayList<>(list);

        Sort.bubble(list, comparator);
        sortedList.sort(Integer::compareTo);

        assertEquals(sortedList, list);
    }

    @Test
    void bubbleArray() {
        Integer[] sortedList = generateRandomList(10).toArray(new Integer[10]);
        Integer[] list = sortedList.clone();

        Sort.bubble(list, comparator);
        Arrays.sort(sortedList, comparator);

        assertArrayEquals(sortedList, list);
    }

    @Test
    public void mergeSortTest() {
        final Integer[] integerArray = generateRandomList(10).toArray(new Integer[10]);
        Integer[] list = integerArray.clone();

        Sort.mergeSort(integerArray, comparator);
        Arrays.sort(list, comparator);

        assertArrayEquals(integerArray, list);
    }

    private ArrayList<Integer> generateRandomList(int size) {
        ArrayList<Integer> al = new ArrayList<>(size);
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            al.add(r.nextInt(size)); //add random number
        }
        return al;
    }
}