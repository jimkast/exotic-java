package org.jimkast.exotic.parse.regex;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.while_present;
import org.jimkast.exotic.text.of_charseq;
import org.junit.Test;

public class regex_dirsTest {

    @Test
    public void supply() {
        binary input = new of_charseq("  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr");
        dir d = new dir_sequence(
            new dir_single_fixed('s'),
            new dir_any(new dir_single_range('t', 'w'), new dir_single_fixed('d')),
            new dir_times(2, 5, new dir_single_fixed('g')),
            new dir_single_range('r', 'w'),
            new dir_single_fixed('d')
        );
        while_present<match> loop = new while_present<>(
            new rgx_dir_matches(
                input,
                d
            )
        );
        Consumer<match> c = m -> System.out.println(m.start());
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < 100; i++) {
            new while_present<>(
                new rgx_dir_matches(
                    input, d
                )
            ).supply(c);
        }
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void suppsdgfly() {
        String s = "  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr";
        Pattern ptn = Pattern.compile("s[t-wd]g{2,5}[r-w]d");
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < 100; i++) {
            Matcher m = ptn.matcher(s);
            while (m.find()) {
                System.out.println(m.start());
            }
        }
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void gxdfgdfg() {
        binary input = new of_charseq("  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr");
        dir_sequence dir = new dir_sequence(
            new dir_single_fixed('s'),
            new dir_any(new dir_single_range('t', 'w'), new dir_single_fixed('d')),
            new dir_times(2, 5, new dir_single_fixed('g')),
            new dir_single_range('r', 'w'),
            new dir_single_fixed('d')
        );
        int len = input.length();
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < len; i++) {
            if(dir.test(input, i, Collections.emptyList()) > -1) {
                System.out.println(i);
            }
        }
        System.out.println(LocalDateTime.now());
//        dir.test(new of_charseq("  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr"), 7, Collections.emptyList());
    }


    @Test
    public void jdk() {
        String s = "  22 1sdgggsdfw4   6e476yr6   yufdfgsdggggwd  345 tra3s4t rgtsr";
        Pattern ptn = Pattern.compile("s[t-wd]g{2,5}[r-w]d");
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < s.length(); i++) {
            if(ptn.matcher(s).find(i)) {
                System.out.println(i);
            }
        }
        System.out.println(LocalDateTime.now());
    }
}