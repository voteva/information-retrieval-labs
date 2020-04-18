package irs.labs.sort;

import irs.labs.sort.model.SortResult;

import javax.annotation.Nonnull;

public interface Sortable {
    @Nonnull
    SortResult sort(@Nonnull Integer[] items);
}
