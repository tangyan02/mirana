package mirana.util.base;

import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagUtil {

    public static List<String> getTagText(FieldDoc fieldDoc, String tagName) {
        Tag[] tags = fieldDoc.tags(tagName);
        return getTagTexts(tags);
    }

    public static List<String> getTagText(MethodDoc methodDoc, String tagName) {
        Tag[] tags = methodDoc.tags(tagName);
        return getTagTexts(tags);
    }

    private static List<String> getTagTexts(Tag[] tags) {
        if (tags.length > 0) {
            List<String> result = new ArrayList<>();
            for (Tag tag : tags) {
                result.add(tag.text());
            }
            return result;
        }
        return new ArrayList<>();
    }
}
