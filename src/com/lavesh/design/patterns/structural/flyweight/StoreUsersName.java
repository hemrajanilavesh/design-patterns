package com.lavesh.design.patterns.structural.flyweight;

//import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */

class User {
    /*static List<String> users = new ArrayList<>();
    public int[] nameIndices;


    User(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = users.indexOf(s);
            if (idx != 1) return idx;
            else {
                users.add(s);
                return users.size() - 1;
            }
        };

        nameIndices = Arrays.stream(fullName.split(" "))
                .mapToInt(s -> getOrAdd.apply(s))
                .toArray();
    }

    public String getFullName() {
        return Arrays.stream(nameIndices)
                .mapToObj(i -> users.get(i))
                .collect(Collectors.joining(","));
    }*/

}


public class StoreUsersName {

    public static void main(String[] args) {
        /*User user1 = new User("Lavesh Hemrajani");
        User user2 = new User("Lavesh Vinod Hemrajani");
        System.out.println(user1.getFullName());
        System.out.println(user2.getFullName());*/
    }

}
