package com.clouway.friendlyserve;

import java.net.HttpURLConnection;

/**
 * RsUnAuthorized is a response that indicates that access was un-authorized.
 * 
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsUnAuthorized extends RsWrap {

  public RsUnAuthorized() {
    this(new RsEmpty());
  }

  public RsUnAuthorized(Response origin) {
    super(new RsWithStatus(HttpURLConnection.HTTP_UNAUTHORIZED, origin));
  }
}
