package org.mylife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// It will be picked by Eureka Server, discoveryClient is latest, irrespective of discovery solution!
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class GeoLocationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoLocationTrackerApplication.class, args);
	}
}
//  [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_UNKNOWN/Laptop-vimal.fritz.box:0 - registration status: 204