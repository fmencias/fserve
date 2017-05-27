package com.clouway.friendlyserve;

import org.junit.Test;

import java.net.HttpURLConnection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class RsRedirectTest {

  @Test
  public void temporaryRedirect() throws Exception {
    Response response = RsRedirect.temporary("/error");
    
    assertThat(response.status().code, is(equalTo(HttpURLConnection.HTTP_MOVED_TEMP)));
    assertThat(response.status().redirectUrl, is(equalTo("/error")));
  }
  
  @Test
  public void permanentRedirectWithCookies() throws Exception {
    RsWithCookie response = new RsWithCookie(
            RsRedirect.permanent("/"),
            new Cookie.Builder()
                    .name("SID")
                    .value("::session id::")
                    .expiresAfter(30)
                    .build()
    );

    assertThat(response.status().code, is(equalTo(HttpURLConnection.HTTP_MOVED_PERM)));
    assertThat(response.status().redirectUrl, is(equalTo("/")));
    assertThat(response.cookies(), hasItem(new Cookie.Builder()
            .name("SID")
            .value("::session id::")
            .expiresAfter(30)
            .build()));

  }
}
