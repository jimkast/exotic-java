package org.jimkast.ooj.lang;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import org.jimkast.ooj.cond.ChkLt;
import org.jimkast.ooj.map.Case;
import org.jimkast.ooj.map.Choose;
import org.jimkast.ooj.map.PMapping;
import org.junit.Test;

public class PMappingTest {

    @Test
    public void test() throws Exception {
        System.out.print(
            new Choose<>(
                "",
                new PMapping.Fixed<>("333333333"),
                new Case<>(new ChkLt(4), "11111"),
                new Case<>(new ChkLt(8), "df23454564gd")
            ).map(5)
        );
    }


    @Test
    public void utf() throws Exception {
        String s = "hellp  σγθ  ι454 τσ tr34ti Θ";
        byte[] b = new byte[16];
        new Random().nextBytes(b);
        byte[] utf8bytes = s.getBytes(StandardCharsets.UTF_8);
        byte[] fake = Arrays.copyOf(utf8bytes, utf8bytes.length - 1);
        String utf8 = new String(fake, StandardCharsets.UTF_8);
        for (char c : utf8.toCharArray()) {
            System.out.println((int) c);
        }
        System.out.println(utf8);
    }
}