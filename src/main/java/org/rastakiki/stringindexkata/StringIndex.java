package org.rastakiki.stringindexkata;

public class StringIndex {

    public int[] index(String input) {
        if (input == null || input.equals("")) {
            return new int[]{};
        }

        int[] indexValue = new int[input.length()];
        indexValue[0] = -1;

        if (input.length() > 2) {
            indexValue[1] = 0;
            for (int i = 2; i < input.length(); i++) {
                int previousCharIndex = i - 1;
                if (input.charAt(previousCharIndex) == input.charAt(indexValue[previousCharIndex])) {
                    indexValue[i] = 1 + indexValue[previousCharIndex];
                }
            }
        }
        return indexValue;
    }

}
