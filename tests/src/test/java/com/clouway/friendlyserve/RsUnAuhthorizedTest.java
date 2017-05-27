package com.clouway.friendlyserve;

import com.clouway.friendlyserve.testing.RsPrint;
import org.junit.Test;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsUnAuhthorizedTest {

  @Test
  public void onlyStatusIsReturned() throws Exception {

    RsUnAuthorized unAuthorized = new RsUnAuthorized();
    assertThat(unAuthorized.status().code, is(equalTo(HttpURLConnection.HTTP_UNAUTHORIZED)));
  }

  @Test
  public void appendToAnotherResponse() throws Exception {
    RsUnAuthorized unAuthorized = new RsUnAuthorized(new RsWithBody("::body::"));
    
    assertThat(unAuthorized.status().code, is(equalTo(HttpURLConnection.HTTP_UNAUTHORIZED)));
    assertThat(new RsPrint(unAuthorized).printBody(), is(equalTo("::body::")));
  }
}
