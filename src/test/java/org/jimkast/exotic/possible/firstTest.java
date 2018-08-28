package org.jimkast.exotic.possible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.gte;
import org.jimkast.exotic.bool.lte;
import org.jimkast.exotic.possible.adapter.iterable;
import org.jimkast.exotic.possible.adapter.of;
import org.jimkast.exotic.possible.gen.fibonnaci;
import org.jimkast.exotic.possible.gen.integers;
import org.junit.Assert;
import org.junit.Test;

public class firstTest {

    @Test
    public void supply() throws Exception {
        Assert.assertEquals(4, (int) new orelse<>(
            new first<Integer>(
                i -> new gte(i, 4),
                new range(1, 10)
            ),
            5
        ).value());
    }

    @Test
    public void supply2() throws Exception {
        Assert.assertEquals(5, (int) new orelse<>(
            new first<Integer>(
                i -> new gte(i, 11),
                new range(1, 10)
            ),
            5
        ).value());
    }

    @Test
    public void any() throws Exception {
        Assert.assertTrue(
            new any<>(
                i -> new gte(i, 10),
                new range(1, 10)
            ).choose(true, false)
        );
    }

    @Test
    public void any2() throws Exception {
        Assert.assertFalse(
            new any<>(
                i -> new lte(i, -1),
                new range(1, 10)
            ).choose(true, false)
        );
    }

    @Test
    public void all() throws Exception {
        Assert.assertTrue(
            new all<>(
                i -> new lte(i, 10),
                new range(1, 10)
            ).choose(true, false)
        );
    }

    @Test
    public void sorted() throws Exception {
        List<Integer> values = new ArrayList<>();
        new while_present<>(new sorted<>(new of<>(5, 10, 6, 1, 9, 0))).supply(values::add);
        Assert.assertEquals(Arrays.asList(0, 1, 5, 6, 9, 10), values);
    }


    @Test
    public void joined() throws Exception {
        possible<Integer> p = new joined<>(
            new range(1, 10),
            new range(20, 30),
            new range(30, 40)
        );
        p.supply(System.out::println);
        p.supply(System.out::println);
        p.supply(System.out::println);
        p.supply(System.out::println);
        new while_present<>(p).supply(System.out::println);
    }

    @Test
    public void iterable() throws Exception {
        new while_present<>(new iterable<>(7, 4, 5, 6)).supply(System.out::println);
    }

    @Test
    public void count() throws Exception {
        Assert.assertEquals(
            5,
            new count(new while_present<>(new iterable<>(7, 4, 5, 6, 10))).intValue()
        );
    }

    @Test
    public void sticky() throws Exception {
        new while_present<>(new sticky<>(new range(1, 10))).supply(System.out::println);
    }

    @Test
    public void reduced2() throws Exception {
        new while_present<>(new reduced2<>((i1, i2) -> i1 + i2, new range(1, 10))).supply(System.out::println);
    }

    @Test
    public void last() throws Exception {
        possible<Integer> p = new last<>(new range(1, 10));
        p.supply(System.out::println);
        p.supply(System.out::println);
    }

    @Test
    public void fibonnaci() throws Exception {
        Scalar<Integer> f = new fibonnaci();
        for (int i = 0; i < 10; i++) {
            System.out.println(f.value());
        }
        System.out.println("***");
        f = new integers(5, 2);
        new while_present<>(
            new range(1, 10)
        ).supply(System.out::println);
        System.out.println("***");
        for (int i = 0; i < 10; i++) {
            System.out.println(f.value());
        }
    }
}