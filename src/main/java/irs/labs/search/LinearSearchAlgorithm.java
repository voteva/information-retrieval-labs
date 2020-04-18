package irs.labs.search;

public class LinearSearchAlgorithm
        implements Searchable {

    @Override
    public boolean contains(String string, String substring) {
        if (string == null || substring == null || string.length() < substring.length()) {
            return false;
        }

        int offset = 0;
        int index = 0;

        while (offset <= string.length() - substring.length()) {
            if (string.charAt(index + offset) == substring.charAt(index)) {
                index++;
                if (index == substring.length()) {
                    return true;
                }
            } else {
                offset++;
                index = 0;
            }
        }

        return false;
    }
}
