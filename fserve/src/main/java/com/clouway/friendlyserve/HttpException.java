package com.clouway.friendlyserve;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class HttpException extends RuntimeException {

  private final int code;

  public HttpException(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }
}
