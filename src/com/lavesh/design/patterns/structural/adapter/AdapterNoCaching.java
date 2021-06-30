package com.lavesh.design.patterns.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */

class Point {

    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class Line {
    public Point start,end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!end.equals(line.end)) return false;
        if (!start.equals(line.start)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}

class VectorObject extends ArrayList<Line> { }

class VectorRectangle extends VectorObject {

    VectorRectangle(int x, int y, int height, int width) {
        add(new Line(new Point(x,y), new Point(x+width,y)));
        add(new Line(new Point(x+width,y), new Point(x+width,y + height)));
        add(new Line(new Point(x,y), new Point(x,y + height)));
        add(new Line(new Point(x,y + height), new Point(x+width,y + height)));
    }
}

class LineToPointAdapter extends ArrayList<Point> {

    private static int count = 0;

    public LineToPointAdapter(Line line) {
        System.out.println(
                String.format("%d: Generating points for line [%d,%d]-[%d,%d] (no caching)",
                        ++count, line.start.x, line.start.y, line.end.x, line.end.y));

        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0)
        {
            for (int y = top; y <= bottom; ++y)
            {
                add(new Point(left, y));
            }
        }
        else if (dy == 0)
        {
            for (int x = left; x <= right; ++x)
            {
                add(new Point(x, top));
            }
        }
    }

}


public class AdapterNoCaching {

    public static final List<VectorObject> vectorObjects = new ArrayList<VectorObject>(
            Arrays.asList(new VectorRectangle(1,1,10,10),
                    new VectorRectangle(1,1,15,15))
    );

    public static void drawPoint(Point p) {
        System.out.println(".");
    }

    public static void draw() {
         for (VectorObject vo: vectorObjects) {
             for (Line line : vo) {
                 LineToPointAdapter lpA = new LineToPointAdapter(line);
                 lpA.forEach(AdapterNoCaching::drawPoint);
             }
         }
    }

    public static void main(String[] args) {
         draw();
        draw();
    }

}
