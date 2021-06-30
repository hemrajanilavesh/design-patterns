package com.lavesh.design.patterns.behavioral.state;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */

class CombinationLock
{
    private int [] combination;
    public String status;
    public static final String LOCKED = "LOCKED";
    public static final String OPEN = "OPEN";
    public static final String ERROR = "ERROR";

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        this.status = LOCKED;
    }

    public void enterDigit(int digit)
    {
        switch (status) {
            case LOCKED:
                status = "";
                status = String.valueOf(digit);
                break;
            default:
                status = status + String.valueOf(digit);
                if (status.length() == combination.length) {
                    String result = Arrays.toString(combination).replaceAll(",","").replaceAll(" ","");
                    result = result.substring(1,result.length()-1);
                    System.out.println(result);
                    if (status.equalsIgnoreCase(result)) {
                        status = OPEN;
                    } else {
                        status = ERROR;
                    }
                }
        }
    }

    @Override
    public String toString() {
        return "CombinationLock{" +
                "status='" + status + '\'' +
                '}';
    }
}


public class CombinationLockState {
    public static void main(String[] args) {
        CombinationLock c1 = new CombinationLock(new int[] {1,2,3,4});
        System.out.println(c1);
        c1.enterDigit(1);
        System.out.println(c1);
        c1.enterDigit(2);
        System.out.println(c1);
        c1.enterDigit(3);
        System.out.println(c1);
        c1.enterDigit(4);
        System.out.println(c1);
    }
}
