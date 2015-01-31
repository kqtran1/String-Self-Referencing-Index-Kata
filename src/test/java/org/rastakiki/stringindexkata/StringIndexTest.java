package org.rastakiki.stringindexkata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringIndexTest {

    private StringIndex stringIndex = new StringIndex();

    @Test
    public void givenNullInput_returnEmptyArray() {
        assertThat(stringIndex.index(null)).isEmpty();
    }

    @Test
    public void givenEmptyInput_returnEmptyArray() {
        assertThat(stringIndex.index(null)).isEmpty();
    }

    @Test
    public void givenInputOfLength_X_returnIndexArrayOf_X_Elements() {
        assertThat(stringIndex.index("abc")).hasSize(3);
    }

    @Test
    public void from3rdElement_element_should_default_to_0() {
        int[] indexArray = stringIndex.index("abcd");

        assertThat(indexArray[2]).isEqualTo(0);
        assertThat(indexArray[3]).isEqualTo(0);
    }

    @Test
    public void first_value_should_always_be_minus_1() {
        assertThat(stringIndex.index("a")[0]).isEqualTo(-1);
        assertThat(stringIndex.index("abcd")[0]).isEqualTo(-1);
        assertThat(stringIndex.index("abcdefghijk")[0]).isEqualTo(-1);
    }

    @Test
    public void second_value_should_always_be_0() {
        assertThat(stringIndex.index("ab")[1]).isEqualTo(0);
        assertThat(stringIndex.index("abcd")[1]).isEqualTo(0);
        assertThat(stringIndex.index("abcdefghijk")[1]).isEqualTo(0);
    }

    @Test
    public void givenPreviousCharEqualToPreviousCharResultIndex_returnOnePlusIndexValueOfPreviousChar() {
        assertThat(stringIndex.index("aab")).containsExactly(-1, 0, 1);
        assertThat(stringIndex.index("abcabda")).containsExactly(-1, 0, 0, 0, 1, 2, 0);
    }

}
