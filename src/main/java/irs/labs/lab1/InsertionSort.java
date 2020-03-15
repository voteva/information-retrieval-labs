package irs.labs.lab1;

import irs.labs.lab1.model.SortResult;

import javax.annotation.Nonnull;

public class InsertionSort implements Sorting {

    private int comparisons = 0;
    private int permutations = 0;

    @Nonnull
    @Override
    public SortResult sort(@Nonnull Integer[] items) {

        int key, j;
        for (int i = 1; i < items.length; i++) {
            key = items[i];
            j = i - 1;

            while (j >= 0 && items[j] > key) {
                comparisons++;

                permutations++;
                items[j + 1] = items[j];
                j = j - 1;
            }

            items[j + 1] = key;

            comparisons++;
        }

        return new SortResult()
                .setSortedItems(items)
                .setComparisons(comparisons)
                .setPermutations(permutations);
    }
}
