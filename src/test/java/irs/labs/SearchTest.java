package irs.labs;

import irs.labs.search.FiniteStateAutomatonAlgorithm;
import irs.labs.search.BoyerMooreAlgorithm;
import irs.labs.search.KnutMorrisPrattAlgorithm;
import irs.labs.search.LinearSearchAlgorithm;
import irs.labs.search.RabinKarpAlgorithm;
import irs.labs.search.Searchable;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SearchTest {
    private final List<Searchable> algorithms = asList(
            new LinearSearchAlgorithm(),
            new RabinKarpAlgorithm(),
            new FiniteStateAutomatonAlgorithm(),
            new KnutMorrisPrattAlgorithm(),
            new BoyerMooreAlgorithm()
    );

    @Test
    public void contains() {
        algorithms.forEach(algorithm -> {
            assertTrue(algorithm.contains("abc", "abc"));
            assertTrue(algorithm.contains("abc", "ab"));
            assertTrue(algorithm.contains("abc", "bc"));
            assertTrue(algorithm.contains("abc", "a"));
            assertTrue(algorithm.contains("abc", "b"));
            assertTrue(algorithm.contains("abc", "c"));
            assertTrue(algorithm.contains("aabc", "abc"));
            assertTrue(algorithm.contains("aabcc", "abc"));
            assertTrue(algorithm.contains("asdsdaaaabcaaawdwda", "abc"));
            assertTrue(algorithm.contains("abcabcabceabc", "abcabce"));
        });
    }

    @Test
    public void notContains() {
        algorithms.forEach(algorithm -> {
            assertFalse(algorithm.contains(null, "abc"));
            assertFalse(algorithm.contains("abc", null));
            assertFalse(algorithm.contains("abc", "abcd"));
            assertFalse(algorithm.contains("abc", "def"));
            assertFalse(algorithm.contains("abc", "n"));
            assertFalse(algorithm.contains("abc", "ac"));
            assertFalse(algorithm.contains("abc", "cba"));
            assertFalse(algorithm.contains("aabbcc", "abc"));
        });
    }
}