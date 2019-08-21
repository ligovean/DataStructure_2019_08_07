package ru.geekbrains.datastructure.lesson5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Anagramm {

    private char[] chars;

    public static void main(String[] args) {
        Set<String> result = new Anagramm().getAnagramms("abcd");
        for (String anagramm : result) {
            System.out.println(anagramm);
        }
    }

    private Set<String> getAnagramms(String word) {
        if (word.length() == 1) {
            return Collections.singleton(word);
        }

        this.chars = word.toCharArray();
        Set<String> result = new HashSet<>();

        collectAnagramms(word.length(), result);
        return result;
    }

    private void collectAnagramms(int length, Set<String> result) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            collectAnagramms(length - 1, result);
            result.add(String.valueOf(chars));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = chars.length - length;
        char temp = chars[pos];

        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }

        chars[chars.length - 1] = temp;
    }
}
