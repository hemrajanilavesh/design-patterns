package com.lavesh.design.patterns.creational.builder.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */

class Field {
    public String type, name;

    public Field(String name, String type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("  public %s %s;",type,name);
    }
}

class Class {
    public String name;
    public List<Field> fields = new ArrayList<>();

    public Class() { }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        sb.append("public class " + name);
        sb.append(lineSeparator);
        sb.append("{");
        sb.append(lineSeparator);
        for (Field field: fields) {
            sb.append(field.toString());
            sb.append(lineSeparator);
        }
        sb.append("}");
        return sb.toString();
    }
}

class CodeBuilder {
    private Class theClass = new Class();

    public CodeBuilder(String className)
    {
        theClass.name = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        theClass.fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString()
    {
        return theClass.toString();
    }
}

public class CodeBuilderDemo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name","String").addField("age","int");
        System.out.println(cb);
    }
}
