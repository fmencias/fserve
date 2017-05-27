package com.clouway.friendlyserve;

import java.net.HttpURLConnection;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsRedirect extends RsWrap {

  public static RsRedirect permanently(String redirectUrl) {
    return new RsRedirect(redirectUrl, HttpURLConnection.HTTP_MOVED_PERM);
  }
  
  public static RsRedirect temporary(String redirectUrl) {
    return new RsRedirect(redirectUrl, HttpURLConnection.HTTP_MOVED_TEMP);
  }


  private final String redirectUrl;
  private final int statusCode;

  public RsRedirect(String redirectUrl) {
    this(redirectUrl, HttpURLConnection.HTTP_MOVED_TEMP);
  }

  private RsRedirect(String redirectUrl, int statusCode) {
    super(new RsEmpty());
    this.redirectUrl = redirectUrl;
    this.statusCode = statusCode;
  }

  @Override
  public Status status() {
    return new Status(statusCode, redirectUrl);
  }

}
