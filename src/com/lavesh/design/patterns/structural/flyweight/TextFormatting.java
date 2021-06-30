package com.lavesh.design.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */

class OldFashionFormattedText {

    String plainText ;
    private boolean [] capitalize;

    OldFashionFormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void setCapitalize(int start, int end) {
        for (int i = start; i<= end; i++) {
            capitalize[i] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < plainText.length(); c++) {
           char ch = plainText.charAt(c);
            sb.append(capitalize[c] ? Character.toUpperCase(ch) : ch);
        }

        return sb.toString();
    }
}

class FlyweightFormattedText {
    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    FlyweightFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange textRange = new TextRange(start,end);
        formatting.add(textRange);
        return textRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < plainText.length(); c++) {
            char ch = plainText.charAt(c);
            for (TextRange tr: formatting) {
                if (tr.covers(c) && tr.capitalize) {
                    ch = Character.toUpperCase(ch);
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }

    class TextRange {
        public int start,end;
        public boolean bold, italic, capitalize;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers (int index) {
            return index >= start && index <= end;
        }
    }


}

public class TextFormatting {
    public static void main(String[] args) {
        String text = "Make America Great Again";
        OldFashionFormattedText oldFashionFormattedText = new OldFashionFormattedText(text);
        oldFashionFormattedText.setCapitalize(5,11);
        System.out.println("Old Fashion Non Optimized : " + oldFashionFormattedText.toString());

        FlyweightFormattedText flyweightFormattedText = new FlyweightFormattedText(text);
        flyweightFormattedText.getRange(5,11).capitalize = true;
        System.out.println("Optimized Text Formatting : " + flyweightFormattedText.toString());

    }
}
