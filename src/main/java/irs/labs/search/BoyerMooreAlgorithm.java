package irs.labs.search;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm
        implements Searchable {

    @Override
    public boolean contains(String string, String substring) {
        if (string == null || substring == null || string.length() < substring.length()) {
            return false;
        }

        final Map<Character, Integer> mismatchTable = preComputeTable(substring);
        int numOfSkips;

        for (int i = 0; i <= string.length() - substring.length(); i += numOfSkips) {
            numOfSkips = 0;

            for (int j = substring.length() - 1; j >= 0; j--) {
                if (substring.charAt(j) != string.charAt(i + j)) {

                    if (mismatchTable.get(substring.charAt(j)) != null) {
                        numOfSkips = mismatchTable.get(substring.charAt(j));
                        break;

                    } else {
                        numOfSkips = substring.length();
                        break;
                    }
                }
            }

            if (numOfSkips == 0) {
                return true;
            }
        }

        return false;
    }

    private Map<Character, Integer> preComputeTable(String substring) {
        final Map<Character, Integer> mismatchTable = new HashMap<>();
        int lengthOfPattern = substring.length();

        for (int i = 0; i < lengthOfPattern; i++) {
            char actualCharacter = substring.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            mismatchTable.put(actualCharacter, maxShift);
        }

        return mismatchTable;
    }
}
