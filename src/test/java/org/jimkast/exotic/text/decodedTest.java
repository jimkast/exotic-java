package org.jimkast.exotic.text;

import java.nio.charset.Charset;
import org.junit.Assert;
import org.junit.Test;

public class decodedTest {

    @Test
    public void decode() throws Exception {
        String text = "sdf σφσδ 3 τδγ δ ~ιαςε0-τ ";
        Charset cs = Charset.forName("ISO-8859-7");
        Assert.assertArrayEquals(text.toCharArray(), new cached(
            new decoded(cs,
                new encoded(cs,
                    new decoded(cs,
                        new fixed8(text.getBytes(cs))
                    )
                )
            )
        ).chars());
    }

}