package com.tomtom.brownbag.reference;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ReferenceDemoControllerTests {

//	@Autowired
//	 @MockBean
     @SpyBean
	private ReferenceDemoController demoController;
	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();

	@Test // (expected = RuntimeException.class)
	public void demoController() {
//		doThrow(new RuntimeException("Other behavior")).when(demoController).key();

        String result = template.getForObject("http://localhost:" + port + "/key", String.class);

        assertThat(result).isEqualTo("value");
    }

}
