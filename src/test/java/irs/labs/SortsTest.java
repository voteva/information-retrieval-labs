package irs.labs;

import irs.labs.sort.BinaryTreeSort;
import irs.labs.sort.BubbleSort;
import irs.labs.sort.InsertionSort;
import irs.labs.sort.QSort;
import irs.labs.sort.Sortable;
import irs.labs.sort.model.SortResult;
import org.junit.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

public class SortsTest {
    private static final List<Integer> ARRAY_SIZE_LIST = asList(10, 20, 40);

    @Test
    public void testSortRandomOrder() {

        System.out.println("\n=== RandomOrder ===");

        ARRAY_SIZE_LIST.forEach(
                size -> {
                    System.out.println(format("\n* Array size: %s", size));

                    Integer[] items = buildArray(size, null);

                    final List<Sortable> sortingList = asList(
                            new BubbleSort(),
                            new InsertionSort(),
                            new BinaryTreeSort(),
                            new QSort());

                    sortingList.forEach(sorting -> executeSort(sorting, items));
                });
    }

    @Test
    public void testSortOrdered() {

        System.out.println("\n=== Ordered ===");

        ARRAY_SIZE_LIST.forEach(
                size -> {
                    System.out.println(format("\n* Array size: %s", size));

                    Integer[] items = buildArray(size, Comparator.comparingInt(a -> a));

                    final List<Sortable> sortingList = asList(
                            new BubbleSort(),
                            new InsertionSort(),
                            new BinaryTreeSort(),
                            new QSort());

                    sortingList.forEach(sorting -> executeSort(sorting, items));
                });
    }

    @Test
    public void testSortInvertedOrder() {

        System.out.println("\n=== InvertedOrder ===");

        ARRAY_SIZE_LIST.forEach(
                size -> {
                    System.out.println(format("\n* Array size: %s", size));

                    Integer[] items = buildArray(size, (a, b) -> b - a);

                    final List<Sortable> sortingList = asList(
                            new BubbleSort(),
                            new InsertionSort(),
                            new BinaryTreeSort(),
                            new QSort());

                    sortingList.forEach(sorting -> executeSort(sorting, items));
                });
    }

    private void executeSort(@Nonnull Sortable sorting, @Nonnull Integer[] items) {
        SortResult result = sorting
                .sort(copyOf(items, items.length));

        System.out.println(format("%s: comparisons - %s, permutations - %s",
                sorting.getClass().getSimpleName(),
                result.getComparisons(),
                result.getPermutations()));
    }


    @Nonnull
    private Integer[] buildArray(int size, @Nullable Comparator<Integer> comparator) {
        Integer[] items = new Integer[size];

        for (int i = 0; i < size; i++) {
            items[i] = (int) (Math.random() * 100);
        }

        if (comparator != null) {
            sort(items, comparator);
        }

        return items;
    }
}
