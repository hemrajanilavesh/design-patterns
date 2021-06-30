package com.lavesh.design.patterns.structural.adapter;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */


class LineToPointAdapter2 implements Iterable<Point> {

    private static int count = 0;
    private static Map<Integer, List<Point>> cache = new HashMap<>();
    private int hash;

    LineToPointAdapter2(Line line) {
        hash = line.hashCode();
        if (cache.get(hash) != null) return; // we already have it

        System.out.println(
                String.format("%d: Generating points for line [%d,%d]-[%d,%d] (with caching)",
                        ++count, line.start.x, line.start.y, line.end.x, line.end.y));

        ArrayList<Point> points = new ArrayList<>();

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
                points.add(new Point(left, y));
            }
        }
        else if (dy == 0)
        {
            for (int x = left; x <= right; ++x)
            {
                points.add(new Point(x, top));
            }
        }

        cache.put(hash, points);
    }

    @Override
    public Iterator<Point> iterator() {
       return cache.get(hash).iterator();
    }

    @Override
    public void forEach(Consumer<? super Point> action) {
        cache.get(hash).forEach(action);
    }

    @Override
    public Spliterator<Point> spliterator() {
        return cache.get(hash).spliterator();
    }
}

public class AdapterWithCaching {
    public static final List<VectorObject> vectorObjects = new ArrayList<VectorObject>(
            Arrays.asList(new VectorRectangle(1,1,10,10),
                    new VectorRectangle(1,1,15,15))
    );

    public static void drawPoint(Point p) {
        System.out.println(".");
    }

    public static void draw() {
        for (VectorObject vo: vectorObjects) {
            for (Line line: vo) {
                LineToPointAdapter2 lpA2 = new LineToPointAdapter2(line);
                lpA2.forEach(AdapterWithCaching:: drawPoint);
            }
        }
    }

    public static void main(String[] args) {
        draw();
        draw();
    }


}
