package org.jimkast.exotic.text.charset;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.jimkast.exotic.binary.bstream;
import org.junit.Test;

public class CodecEnUtf8Test {

    @Test
    public void consume() throws Exception {
        String s = "hello szfgσδφγξ ετ 54-0τ~ 94ε9πρτε  € \uD852\uDF62 σζφ3σς4 τ";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        bstream str = new CodecStream(
            new CodecDecUtf8(),
            in::read
        );
        int c;
        while ((c = str.read()) != -1) {
            System.out.println(c);
        }
        System.out.println("--------------");
        s.codePoints().forEach(System.out::println);
    }


    @Test
    public void ch() throws Exception {
        String s = "\u20AC";
        System.out.println(s);
        for (byte b : s.getBytes(StandardCharsets.UTF_8)) {
            System.out.println(b & 0xFF);
        }
        for (byte b : s.getBytes(StandardCharsets.UTF_16)) {
            System.out.println(b & 0xFF);
        }
    }
}