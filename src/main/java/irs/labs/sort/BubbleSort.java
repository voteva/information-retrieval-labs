package irs.labs.sort;

import irs.labs.sort.model.SortResult;

import javax.annotation.Nonnull;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class BubbleSort
        implements Sortable {

    private int comparisons = 0;
    private int permutations = 0;

    @Nonnull
    @Override
    public SortResult sort(@Nonnull Integer[] items) {

        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - i - 1; j++) {

                comparisons++;
                if (items[j] > items[j + 1]) {

                    permutations++;
                    swap(items, j, j + 1);
                }
            }
        }

        return new SortResult()
                .setSortedItems(items)
                .setComparisons(comparisons)
                .setPermutations(permutations);
    }
}
