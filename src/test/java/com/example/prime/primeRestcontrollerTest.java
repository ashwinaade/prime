package com.example.prime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class primeRestcontrollerTest {
   
	@Parameter(value = 0)
    public Integer givenNumber;

	 @Parameter(value = 1)
	    public int output;
	
	 
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][]{
	        	    {-100000, 400}, {-1000, 400},{0, 400},{1, 400},{2,200},{100,200},{1000,200},{10000,200},{100000,200},{1000000,200}
	        });
	    }
	 
	 
    @Test
    public void test_valid_domain() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/prime/primes/"+givenNumber;
        URI uri = new URI(baseUrl); 
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");               
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertEquals(output, result.getStatusCodeValue());
    }

}