package com.clouway.friendlyserve;

import java.util.Map;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public interface RequestExt extends Request {

  /**
   * The request method as any of "GET", "PUT", "POST", "DELETE"
   *
   * @return the request method
   */
  String method();

  /**
   * Gets fully clafied name of the URL that was called by the caller.
   *
   * @return the url that causes this request to be created
   */
  StringBuffer url();

  /**
   * Gets the query part of the URL, i.e everything after the "?" char.
   *
   * @return the query string
   */
  String queryString();


  /**
   * Returns the content type of the request body.
   *
   * @return the content type
   */
  String contentType();

  /**
   * Gets the callers IP address. It's usually the IP address of the client that is sending the
   * request.
   *
   * @return the remote address
   */
  Iterable<String> headerNames();

  /**
   * Returns all available params in the request.
   *
   * @return all params associated by there key in a map
   */
  Map<String, String[]> params();

  /**
   * Gets the callers IP address. It's usually the IP address of the client that is sending the
   * request.
   *
   * @return the remote address
   */
  String remoteAddress();

}
