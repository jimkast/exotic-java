package org.jimkast.exotic.text;

import java.io.File;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;
import org.jimkast.exotic.possible.mapped;
import org.jimkast.exotic.possible.while_present;
import org.junit.Test;

public class split_chTest {
    private static final String DOC = new UncheckedText(new TextOf(new File("pom.xml"))).asString();

    @Test
    public void benchmark() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(DOC
                .substring(8)
                .toUpperCase()
                .substring(3, 83)
                .toLowerCase()
                .substring(30, 80)
            );
        }
    }


//    @Test
//    public void benchmark3() {
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(
//                new cached(
//                    new substring(
//                        new lowercase(
//                            new substring(
//                                new uppercase(
//                                    new substring(
//                                        new text.of(DOC),
//                                        8
//                                    )
//                                ),
//                                3, 80
//                            )
//                        ),
//                        30, 50
//                    )
//                ).chars()
//            );
//        }
//    }

    @Test
    public void benchmark_fluent() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(
                new fluent(DOC)
                    .substring(8)
                    .uppercase()
                    .substring(3, 80)
                    .lowercase()
                    .substring(30, 50)
                    .chars()
            );
        }
    }


    @Test
    public void supply() {
        System.out.println("index:::" +
            new indexof(new binary.of(
                "c345 3s45 | c34q45 3"
            ), new binary.of(" | ")).intValue()
        );

        System.out.println("substring_after:::" +
            new StringBuilder(
                new binary.as_charseq(
                    new substring_after(
                        new binary.of("c345 3s45 | 4ec34q453w45 3"),
                        new binary.of(" | ")
                    )
                )
            )
        );


        System.out.println("substring_before:::" +
            new StringBuilder(
                new binary.as_charseq(
                    new substring_before(
                        new binary.of("xdfgc345 3s45  | c34q45 3"),
                        new binary.of(" | ")
                    )
                )
            )
        );

//
        new while_present<>(
            new mapped<>(
                binary.as_charseq::new,
                new split(
                    new binary.of(
                        "aaa234235|bbb23845 | c345 3s  | a3q45 3"
                    ),
                    new binary.of(" | ")
                )
            )
        ).supply(text -> System.out.println("part ::: " + new StringBuilder(text)));
    }


}