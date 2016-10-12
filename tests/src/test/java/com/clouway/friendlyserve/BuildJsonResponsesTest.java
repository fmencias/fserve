package com.clouway.friendlyserve;

import com.clouway.friendlyserve.testing.RsPrint;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;


/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class BuildJsonResponsesTest {

  @Test
  public void happyPath() throws IOException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("key1", "value1");
    RsJson json = new RsJson(jsonObject);
    assertThat(new RsPrint(json).print(), is(equalTo("Content-Type: application/json; charset=utf-8\r\n{\"key1\":\"value1\"}")));
  }

  @Test
  public void responseWithMultipleProperties() throws IOException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("::key1::", "::value1::");
    jsonObject.addProperty("::key2::", "::value2::");
    RsJson json = new RsJson(jsonObject);
    assertThat(new RsPrint(json).print(), is(equalTo("Content-Type: application/json; charset=utf-8\r\n{\"::key1::\":\"::value1::\",\"::key2::\":\"::value2::\"}")));
  }

  @Test
  public void handleContentInUtf8() throws IOException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("::key1::", "тестова стойност");
    RsJson json = new RsJson(jsonObject);

    CharsetDecoder cs = StandardCharsets.UTF_8.newDecoder();
    try {
      cs.decode(ByteBuffer.wrap(ByteStreams.toByteArray(json.body())));
    } catch (CharacterCodingException e) {
      fail("decoding to utf8 failed with: " + e.getMessage());
    }
  }

}