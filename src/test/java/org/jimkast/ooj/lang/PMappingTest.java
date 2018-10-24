package org.jimkast.ooj.lang;

import org.jimkast.ooj.cond.ChkLt;
import org.jimkast.ooj.map.Case;
import org.jimkast.ooj.map.Choose;
import org.jimkast.ooj.map.Fixed;
import org.junit.Test;

public class PMappingTest {

    @Test
    public void test() throws Exception {
        System.out.print(
            new Choose<>(
                "",
                new Fixed<>("333333333"),
                new Case<>(new ChkLt(4), "11111"),
                new Case<>(new ChkLt(8), "df23454564gd")
            ).map(5)
        );
    }
}