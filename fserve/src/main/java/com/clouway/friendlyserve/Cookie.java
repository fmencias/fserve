package com.clouway.friendlyserve;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class Cookie {

  public static class Builder {
    private String path = "";
    private String name = "";
    private String value = "";
    private int expirationTimeInSeconds = -1;

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public Builder expiresAfter(int timeInSeconds) {
      this.expirationTimeInSeconds = timeInSeconds;
      return this;
    }

    public Cookie build() {
      return new Cookie(path, name, value, expirationTimeInSeconds);
    }
  }

  private String path;
  private String name;
  private String value;
  private int expirationTimeInSeconds;

  public Cookie(String path, String name, String value, int expirationTimeInSeconds) {
    this.path = path;
    this.name = name;
    this.value = value;
    this.expirationTimeInSeconds = expirationTimeInSeconds;
  }

  public String path() {
    return path;
  }

  public String name() {
    return name;
  }

  public String value() {
    return value;
  }

  public int expirationTimeInSeconds() {
    return expirationTimeInSeconds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cookie cookie = (Cookie) o;
    return expirationTimeInSeconds == cookie.expirationTimeInSeconds &&
            Objects.equals(path, cookie.path) &&
            Objects.equals(name, cookie.name) &&
            Objects.equals(value, cookie.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, name, value, expirationTimeInSeconds);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("value", value)
            .toString();
  }

}
