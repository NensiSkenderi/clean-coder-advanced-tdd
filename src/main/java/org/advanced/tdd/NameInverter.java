package org.advanced.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {
    private static String getPostNominals(List<String> names) {
        StringBuilder postNominalString = new StringBuilder();
        if (names.size() > 2) {
            List<String> postNominals = names.subList(2, names.size());
            for (String s : postNominals)
                postNominalString.append(s).append(" ");
        }
        return postNominalString.toString();
    }

    String invertName(String name) {
        if (name == null || name.length() == 0)
            return "";
        else
            return formatName(removeHonorifics(splitNames(name)));
    }

    private String formatName(List<String> names) {
        if (names.size() == 1)
            return names.get(0);
        else {
            return formatMultiElementName(names);
        }
    }

    private String formatMultiElementName(List<String> names) {
        String postNominals = NameInverter.getPostNominals(names);
        String firstName = names.get(0);
        String lastName = names.get(1);
        return String.format("%s %s %s", lastName, firstName, postNominals).trim();
    }

    private List<String> removeHonorifics(List<String> names) {
        if (names.size() > 1 && isHonorific(names.get(0)))
            names.remove(0);

        return names;
    }

    private boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }
}
