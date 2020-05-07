package edu.miu.cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class MovieServiceClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	  @Autowired
	    private EurekaClient eurekaClient;
	
	@Value("${sample-springdata-service}")
	  private String serviceName;

    // @HystrixCommand(fallbackMethod = "defaultFortune")
    public List<MovieResponse> getMovies() {
        return restTemplate.getForObject(lookupUrlFor(serviceName) + "/?fetch-all=true", List.class);
    }

    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }

}
