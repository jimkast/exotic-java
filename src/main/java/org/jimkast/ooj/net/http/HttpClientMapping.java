package org.jimkast.ooj.net.http;

import java.io.IOException;

public interface HttpClientMapping {
    HttpIn exchange(HttpOut request) throws IOException;
}
