package irs.labs.lab1;

import irs.labs.lab1.model.SortResult;

import javax.annotation.Nonnull;

public class BinaryTreeSort implements Sorting {

    @Nonnull
    @Override
    public SortResult sort(@Nonnull Integer[] items) {
        int comparisons = 0;
        int permutations = 0;

        return new SortResult()
                .setSortedItems(items)
                .setComparisons(comparisons)
                .setPermutations(permutations);
    }
}
