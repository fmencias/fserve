package com.clouway.friendlyserve;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsWithStatusTest {

  @Test
  public void happyPath() throws Exception {
    RsWithStatus response = new RsWithStatus(200);
    assertThat(response.status().code, is(equalTo(200)));
  }
  
  @Test
  public void anotherStatus() throws Exception {
    RsWithStatus response = new RsWithStatus(404);
    assertThat(response.status().code, is(equalTo(404)));
  }
}
