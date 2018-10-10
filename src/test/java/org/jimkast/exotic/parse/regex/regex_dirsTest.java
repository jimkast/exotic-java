package org.jimkast.exotic.parse.regex;

import org.jimkast.exotic.possible.while_present;
import org.jimkast.exotic.text.fluent;
import org.jimkast.exotic.text.of_charseq;
import org.junit.Test;

public class regex_dirsTest {

    @Test
    public void supply() {
        new while_present<>(
            new regex_dirs(
                new of_charseq("  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr"),
                new dir_sequence(
                    new dir_single_fixed('s'),
                    new dir_any(new dir_single_range('t', 'w'), new dir_single_fixed('d')),
                    new dir_times(2, 5, new dir_single_fixed('g')),
                    new dir_single_range('r', 'w'),
                    new dir_single_fixed('d')
                )
            )
        ).supply(binary -> System.out.println(new fluent(binary).chars()));
    }


    @Test
    public void test222() {
        new regex_dirs(
            new of_charseq("sdgggsdf"),
            new dir_sequence(
                new dir_single_fixed('s'),
                new dir_any(new dir_single_range('r', 'w'), new dir_single_fixed('d')),
                new dir_times(2, 5, new dir_single_fixed('g')),
                new dir_single_range('r', 'w'),
                new dir_single_fixed('d')
            )
        ).supply(binary -> System.out.println(new fluent(binary).chars()));
    }
}