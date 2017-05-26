package com.clouway.friendlyserve;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsWithCookie extends RsWrap {

  public RsWithCookie(Cookie cookie) {
    this(new RsEmpty(), cookie);
  }

  public RsWithCookie(final Response origin, final Cookie... cookie) {
    super(new Response() {
      @Override
      public Iterable<Cookie> cookies() {
        return Arrays.asList(cookie);
      }

      @Override
      public Status status() {
        return origin.status();
      }

      @Override
      public Map<String, String> header() throws IOException {
        return origin.header();
      }

      @Override
      public InputStream body() throws IOException {
        return origin.body();
      }
    });
  }
}
