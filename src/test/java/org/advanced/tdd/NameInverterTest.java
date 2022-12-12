package org.advanced.tdd;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NameInverterTest {

    @Test
    public void givenNull_returnsEmptyString(){
        assertInverted("", null);
    }

    @Test
    public void givenEmptyString_returnsEmptyString(){
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnSimpleName(){
        assertInverted("Nensi", "Nensi");
    }

    @Test
    public void givenFirstLast_returnLastFirst(){
        assertInverted("First Last", "Last First");
    }
    public void givenASimpleNameWithSpaces_returnSimpleNameWithoutSpaces(){
        assertInverted(" Name ", "Name");
    }
    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst(){
        assertInverted(" First     Last    ", "Last First");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, invertName(originalName));
    }

    private String invertName(String name) {
        if (name == null || name.length() <= 0) {
            return "";
        }
        else {
            name = name.trim();
            String[] names = name.split("\\s+"); //regex to check for extra spaces
            if(names.length == 1){
                return name;
            }
            return String.format("%s %s", names[1], names[0]);
        }
    }
}
