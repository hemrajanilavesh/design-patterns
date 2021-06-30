package com.lavesh.design.patterns.behavioral.null_object;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */

interface LOG {
    // max # of elements in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);
}

class Account
{
    private LOG log;

    public Account(LOG log)
    {
        this.log = log;
    }

    public void someOperation() throws Exception
    {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if (c+1 != log.getRecordCount())
            throw new Exception();
        if (log.getRecordCount() >= log.getRecordLimit())
            throw new Exception();
    }
}

class NULLLog implements LOG
{
    private int recordCount = 0;
    public int getRecordLimit() {
        recordCount +=2;
        return recordCount;
    }

    // number of elements already in the log
    public int getRecordCount() {
        return recordCount++;
    }

    // expected to increment record count
    public void logInfo(String message) {

    }
}

public class Exercise {
    public static void main(String[] args) {
        Account a = new Account(new NULLLog());
        try {
            for (int i = 0; i < 100; ++i) {
                a.someOperation();
            }
        } catch (Exception e) {
            System.err.println("Exception was thrown.");
        }
        System.out.println("Exception was not thrown.");
    }
}
