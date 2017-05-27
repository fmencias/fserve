package com.clouway.friendlyserve;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsWithBody extends RsWrap {

  public RsWithBody(String body) {
    this(new RsEmpty(), new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)));
  }

  public RsWithBody(InputStream in) {
    this(new RsEmpty(), in);
  }

  public RsWithBody(final Response response, final InputStream body) {
    super(new Response() {
      @Override
      public Iterable<Cookie> cookies() {
        return Collections.emptyList();
      }

      @Override
      public Status status() {
        return response.status();
      }

      @Override
      public Map<String, String> header() throws IOException {
        return response.header();
      }

      @Override
      public InputStream body() throws IOException {
        return body;
      }
    });
  }
}
