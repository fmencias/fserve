package com.clouway.friendlyserve;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsWrap implements Response {

  /**
   * Original response.
   */
  private final transient Response origin;

  public RsWrap(Response origin) {
    this.origin = origin;
  }

  @Override
  public Iterable<Cookie> cookies() {
    return origin.cookies();
  }

  @Override
  public Status status() {
    return origin.status();
  }

  @Override
  public final Map<String, String> header() throws IOException {
    return origin.header();
  }

  @Override
  public final InputStream body() throws IOException {
    return origin.body();
  }
}
