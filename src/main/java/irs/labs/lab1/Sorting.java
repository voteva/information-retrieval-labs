package irs.labs.lab1;

import irs.labs.lab1.model.SortResult;

import javax.annotation.Nonnull;

public interface Sorting {
    @Nonnull
    SortResult sort(@Nonnull Integer[] items);
}
