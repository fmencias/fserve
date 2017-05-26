package com.clouway.friendlyserve.testing;

import com.clouway.friendlyserve.Cookie;
import com.clouway.friendlyserve.Request;
import com.google.common.collect.ImmutableMap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FakeRequest implements Request {

  public static Builder aNewRequest() {
    return new Builder();
  }

  public static class Builder {
    private String path = "/";
    private Map<String, String> params = new LinkedHashMap<>();
    private Map<String, String> headers = new LinkedHashMap<>();
    private List<Cookie> cookies = new LinkedList<>();
    private byte[] body = new byte[] {  };

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public Builder param(String key, String value) {
      params.put(key, value);
      return this;
    }

    public Builder params(Map<String, String> params) {
      this.params = params;
      return this;
    }

    public Builder header(String name, String value) {
      headers.put(name, value);
      return this;
    }

    public Builder headers(Map<String, String> headers) {
      this.headers = headers;
      return this;
    }

    public Builder cookie(Cookie cookie) {
      cookies.add(cookie);
      return this;
    }

    public Builder body(byte[] body) {
      this.body = body;
      return this;
    }

    public Request build() {
      return new FakeRequest(path, params, headers, cookies, body);
    }
  }

  private final String path;
  private final Map<String, String> params;
  private final Map<String, String> headers;
  private final List<Cookie> cookies;
  private final byte[] body;


  public FakeRequest(String path, Map<String, String> params, Map<String, String> headers, List<Cookie> cookies, byte[] content) {
    this.path = path;
    this.params = ImmutableMap.copyOf(params);
    this.headers = ImmutableMap.copyOf(headers);
    this.cookies = cookies;
    this.body = Arrays.copyOf(content, content.length);
  }

  public FakeRequest(String path, Map<String, String> params, Map<String, String> headers, byte[] content) {
    this(path, params, headers, Collections.<Cookie>emptyList(), content);
  }

  public FakeRequest(Map<String, String> params, Map<String, String> headers) {
    this("/", params, headers, new byte[]{});
  }

  public FakeRequest(String path, Map<String, String> params, byte[] content) {
    this(path, params, new LinkedHashMap<String, String>(), content);
  }


  @Override
  public String path() {
    return path;
  }

  @Override
  public String param(String name) {
    return params.get(name);
  }

  @Override
  public Iterable<String> names() {
    return params.keySet();
  }

  @Override
  public Iterable<String> cookie(String name) {
    List<String> values = new LinkedList<>();
    for (Cookie each : cookies) {
      if (each.name().equalsIgnoreCase(name)) {
        values.add(each.value());
      }
    }
    return values;
  }

  @Override
  public String header(String name) {
    return headers.get(name);
  }

  @Override
  public InputStream body() {
    return new ByteArrayInputStream(body);
  }
}