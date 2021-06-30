package com.lavesh.design.patterns.single_responsibility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/19/18
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */

class Journal
{
    private final List<String> entries = new ArrayList<>();

    private static int count = 0;

    public void addEntry(String text)
    {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index)
    {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}


// saving to file is a separate concern
// hence moving the task to another class
class JouenalPersistor {

    public static void saveToFile(Journal journal, String fileName, boolean overwrite) {
        System.out.println("Saving to file...");
        if (overwrite || new File(fileName).exists()) {
            try(PrintStream out = new PrintStream(fileName)) {
                   out.println(journal.toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}


public class SRP {
    public static void main(String[] args) {
        String txt1 = "Hey There !";
        String txt2 = "Welcome to Design Patterns in Java.";
        Journal journal = new Journal();
        journal.addEntry(txt1); journal.addEntry(txt2);
        String fileName = "jouenal.txt";
        JouenalPersistor.saveToFile(journal, fileName,true);

    }
}
