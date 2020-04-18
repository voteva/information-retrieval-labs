package irs.labs.sort;

import irs.labs.sort.model.SortResult;

import javax.annotation.Nonnull;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class QSort
        implements Sortable {

    private int comparisons = 0;
    private int permutations = 0;

    @Nonnull
    @Override
    public SortResult sort(@Nonnull Integer[] items) {

        sort(items, 0, items.length - 1);

        return new SortResult()
                .setSortedItems(items)
                .setComparisons(comparisons)
                .setPermutations(permutations);
    }

    private void sort(@Nonnull Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(@Nonnull Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {

            comparisons++;
            if (arr[j] <= pivot) {
                i++;

                if (i != j) {
                    permutations++;
                    swap(arr, i, j);
                }
            }
        }

        if (i + 1 != high) {
            permutations++;
            swap(arr, i + 1, high);
        }

        return i + 1;
    }
}
