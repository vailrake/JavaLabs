package ua.lviv.iot.editor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor {

    public String deleteLetters(String text) {

        Pattern p = Pattern.compile("(\\w+)");
        Matcher m = p.matcher(text);
        return m.replaceAll(l -> {
            int consonant = l.group().replaceAll("[aeiouAIEUO]", "").length();
            if (consonant < l.group().length() - consonant) {
                return "";
            } else return l.group();
        }).trim().replaceAll(" +", " ");
    }
}