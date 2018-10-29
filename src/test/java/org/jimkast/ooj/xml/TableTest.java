package org.jimkast.ooj.xml;

import org.junit.Test;
import org.magicwerk.brownies.collections.primitive.IntGapList;

public class TableTest {

    @Test
    public void get() {
        new IntGapList(10);
        int[][] nodes = new int[][]{
            {0, 0, 0},
            {1, 0, 0},
            {2, 1, 0},
            {3, 2, 0},
            {4, 2, 3},
            {5, 1, 0},
            {6, 5, 0},
            {7, 6, 0},
            {8, 7, 0},
            {9, 7, 8},
            {10, 9, 0},
            {11, 9, 10},
            {12, 7, 9},
            {13, 6, 7},
        };
    }
}