package org.advanced.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverterTest {

    @Test
    public void givenNull_returnsEmptyString() {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnsEmptyString() {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnSimpleName() {
        assertInverted("Nensi", "Nensi");
    }

    @Test
    public void givenFirstLast_returnLastFirst() {
        assertInverted("First Last", "Last First");
    }

    public void givenASimpleNameWithSpaces_returnSimpleNameWithoutSpaces() {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst() {
        assertInverted(" First     Last    ", "Last First");
    }

    @Test
    public void ignoreHonorifics() {
        assertInverted("Mr. First Last", "Last First");
        assertInverted("Mrs. First Last", "Last First");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, invertName(originalName));
    }

    private String invertName(String name) {
        if (name == null || name.length() == 0) {
            return "";
        } else {
            List<String> names = splitNames(name);
            if (names.size() > 1 && isHonorific(names.get(0)))
                names.remove(0);
            if (names.size() == 1)
                return names.get(0);
            else
                return String.format("%s %s", names.get(1), names.get(0));
        }
    }

    private static boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private static ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }
}
