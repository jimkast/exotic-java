package org.jimkast.eshop;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class AppTest {

    @Test
    public void main() {
        Pattern ptn = Pattern.compile("^(?<scheme>[^:]+)://(?<authority>(?:(?<userinfo>[^@]+)@)?(?<host>[^:/]+)(?::(?<port>\\d+))?)(?<path>[^?]*)(?:\\?(?<query>[^#]*))?(?:#(?<fragment>.*))?$");

//        Pattern ptn = Pattern.compile("^((http[s]?|ftp):/)?/?([^:/\\s]+)((/\\w+)*/)([\\w\\-.]+[^#?\\s]+)(.*)?(#[\\w\\-]+)?$");
        String url = "https://john.doe@www.example.com:123/forum/questions/?tag=networking&order=newest#top";
        Matcher matcher = ptn.matcher(url);
        if (matcher.find()) {
            System.out.println("scheme:     " + matcher.group("scheme"));
            System.out.println("authority:  " + matcher.group("authority"));
            System.out.println("userinfo:   " + matcher.group("userinfo"));
            System.out.println("host:       " + matcher.group("host"));
            System.out.println("port:       " + matcher.group("port"));
            System.out.println("path:       " + matcher.group("path"));
            System.out.println("query:      " + matcher.group("query"));
            System.out.println("fragment:   " + matcher.group("fragment"));
        }

        System.out.println("\n-------\n");

        URI uri = URI.create(url);

        System.out.println("scheme:     " + uri.getScheme());
        System.out.println("authority:  " + uri.getAuthority());
        System.out.println("userinfo:   " + uri.getUserInfo());
        System.out.println("host:       " + uri.getHost());
        System.out.println("port:       " + uri.getPort());
        System.out.println("path:       " + uri.getPath());
        System.out.println("query:      " + uri.getQuery());
        System.out.println("fragment:   " + uri.getFragment());
    }
}