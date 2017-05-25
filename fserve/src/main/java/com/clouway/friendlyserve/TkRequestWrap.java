package com.clouway.friendlyserve;

import com.google.common.collect.Lists;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class TkRequestWrap implements RequestExt {
  private final transient HttpServletRequest req;

  public TkRequestWrap(HttpServletRequest req) {
    this.req = req;
  }

  @Override
  public String path() {
    return req.getRequestURI();
  }

  @Override
  public String param(String name) {
    return req.getParameter(name);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterable<String> names() {
    return req.getParameterMap().keySet();
  }

  @Override
  public Iterable<String> cookie(String name) {
    Cookie[] cookies = req.getCookies();
    if (cookies == null) {
      return Collections.emptyList();
    }

    List<String> values = Lists.newLinkedList();
    for (Cookie each : cookies) {
      if (name.equalsIgnoreCase(each.getName())) {
        values.add(each.getValue());
      }
    }
    return values;
  }

  @Override
  public String header(String name) {
    return req.getHeader(name);
  }

  @Override
  public InputStream body() throws IOException {
    return req.getInputStream();
  }

  @Override
  public String method() {
    return req.getMethod();
  }

  @Override
  public StringBuffer url() {
    return req.getRequestURL();
  }

  @Override
  public String queryString() {
    return req.getQueryString();
  }

  @Override
  public String contentType() {
    return req.getContentType();
  }

  @Override
  @SuppressWarnings("unchecked")
  public Iterable<String> headerNames() {
    return Collections.list(req.getHeaderNames());
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, String[]> params() {
    return req.getParameterMap();
  }

  @Override
  public String remoteAddress() {
    return req.getRemoteAddr();
  }
}
