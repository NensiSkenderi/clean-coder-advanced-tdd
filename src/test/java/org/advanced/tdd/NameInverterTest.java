package org.advanced.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameInverterTest {

    private NameInverter nameInverter;

    @Before
    public void setup(){
        nameInverter = new NameInverter();
    }

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

    @Test
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

    @Test
    public void postNominals_stayAtEnd() {
        assertInverted("First Last Sr.", "Last First Sr.");
        assertInverted("First Last BS. Phd.", "Last First BS. Phd.");
    }

    @Test
    public void givenAllCases_returnCorrectName() {
        assertInverted("  Mrs.  Nensi   Skenderi    BS.    MSc.",
                "Skenderi Nensi BS. MSc.");
    }

    protected void assertInverted(String originalName, String invertedName) {
       assertEquals(invertedName, nameInverter.invertName(originalName));
    }

}
