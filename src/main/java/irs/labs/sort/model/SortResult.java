package irs.labs.sort.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SortResult {
    private Integer[] sortedItems;
    private int comparisons;
    private int permutations;
}