package mirana;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    public static Set<String> classSet = new HashSet<>();

    public static Set<String> newClassSet = new HashSet<>();

    public static void putAllClass(String className) {
        String regular = "(\\w+)";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(className);
        while (matcher.find()) {
            if (classSet.contains(matcher.group())) {
                continue;
            }
            newClassSet.add(matcher.group());
            classSet.add(matcher.group());
        }
    }
}
