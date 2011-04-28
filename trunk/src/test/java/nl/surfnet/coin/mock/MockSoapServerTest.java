/**
 * Copyright 2010
 */
package nl.surfnet.coin.mock;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * {@link Test} for {@link AbstractMockSoapServerTest}
 * 
 * @author oharsta
 * 
 */
public class MockSoapServerTest extends AbstractMockHttpServerTest {

  private boolean securityHandlerHit;

  /**
   * Test the MockHttpServer.
   * 
   * @throws Exception
   */
  @Test
  public void testMockHappyFlow() throws Exception {
    ClassPathResource responseResource = new ClassPathResource("test.json");
    super.setResponseResource(responseResource);
    HttpClient client = new DefaultHttpClient();
    HttpResponse response = client.execute(new HttpGet(
        "http://localhost:8088/testUrl"));
    String contentType = response.getHeaders("Content-Type")[0].getValue();
    Assert.assertEquals("application/json", contentType);
    InputStream is = response.getEntity().getContent();
    OutputStream output = new ByteArrayOutputStream();
    IOUtils.copy(is, output);
    Assert.assertEquals(IOUtils.toString(responseResource.getInputStream()),
        output.toString());
  }

}
