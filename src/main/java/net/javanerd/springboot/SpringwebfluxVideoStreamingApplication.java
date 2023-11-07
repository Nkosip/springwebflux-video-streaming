package net.javanerd.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class SpringwebfluxVideoStreamingApplication {

	@Autowired
	private StreamingService streamingService;
	@GetMapping(value = "video/{title}",produces = "video/mp4")
	public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("range") String range) {
		System.out.println("range in byte: "+range);
		return streamingService.getVideo(title);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxVideoStreamingApplication.class, args);
	}

}
