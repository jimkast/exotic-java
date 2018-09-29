package org.jimkast.exotic.parse;

import java.io.IOException;
import org.cactoos.io.InputStreamOf;
import org.jimkast.exotic.parse.scanner.dir;
import org.jimkast.exotic.parse.scanner.dir_regex;
import org.jimkast.exotic.parse.scanner.sdir;
import org.jimkast.exotic.parse.scanner.sdir_ignore;
import org.junit.Test;

public class scanner_sourceTest {

    @Test
    public void consume() throws IOException {
        target trg = new TrgLog();
        dir CRLR = new dir_regex("\\r\\n");
        scanned_source line = new sequence(
            new sdir("line:method", dir_regex.NOSP, trg),
            new sdir_ignore(dir_regex.SP),
            new sdir("line:uri", dir_regex.NOSP, trg),
            new sdir_ignore(dir_regex.SP),
            new sdir("line:protocol", dir_regex.NOSP, trg)
        );
        scanned_source header = new sequence(
            new sdir("header:name", new dir_regex("^:"), trg),
            new sdir("header:delim", new dir_regex(":"), trg),
            new sdir("header:value", dir_regex.NOSP, trg),
            new sdir("http:protocol", dir_regex.NOSP, trg)
        );
        new scanned(
            new sequence(
                line
            )
        ).consume(new InputStreamOf("GET   /bookings?aa=243rdfrg   HTTP1/1"));
    }


    @Test
    public void http() throws IOException {



        /*
        item('line',
            regex('(\\S+)\\s+(\\S+)\\s+(\\S+)\r\n'

                groups -> groups.at(0)
            ),

        )





        seq(
            item("line",
                seq(
                    item("method", NOSP),
                    SP,
                    item("uri", NOSP),
                    SP,
                    item("protocol", NOSP),
                ),
            ),
            CRLF,
            repeated(
                item("header",
                    seq(
                        item("name", NOSP),
                        SP,
                        fixed(":"),
                        SP,
                        item("value", NOCRLF),
                        CRLF
                    )
                )
            )
            CRLF,
        )
         */



    }


    @Test
    public void json() throws IOException {
        /*
        json = or(
            obj,
            array
        )

        obj =
            seq(
                fixed('{'),
                repeated(
                    item("pair",
                        seq(
                            STRING,
                            fixed(":"),
                            VALUE
                        )
                    )
                ),
                fixed('}')
            )


        obj =
            seq(
                fixed('{'),
                repeated(
                    item("pair",
                        seq(
                            item("name", STRING),
                            fixed(":"),
                            VALUE
                        )
                    )
                ),
                fixed('}')
            )
        */
    }
}