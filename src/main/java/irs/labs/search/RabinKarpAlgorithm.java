package irs.labs.search;

public class RabinKarpAlgorithm
        implements Searchable {

    private static final int BASE = 31;

    @Override
    public boolean contains(String string, String substring) {
        if (string == null || substring == null || string.length() < substring.length()) {
            return false;
        }

        final int substrHash = hashCode(substring);
        String targetSubstr;

        for (int i = 0; i <= (string.length() - substring.length()); i++) {

            targetSubstr = string.substring(i, i + substring.length());

            if (substrHash == hashCode(targetSubstr)) {
                if (targetSubstr.equals(substring)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int hashCode(String str) {
        int hashCode = 0;
        int power = 1;

        for (int i = 0; i < str.length(); i++) {
            hashCode = hashCode + str.charAt(i) * power;
            power *= BASE;
        }

        return hashCode;
    }
}
