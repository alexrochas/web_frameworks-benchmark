package br.com.alex.web.benchmark.camel.route;

import br.com.alex.web.benchmark.camel.repository.IntensiveDataRepository;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class IntensiveProcessingRoute extends RouteBuilder {

	private IntensiveDataRepository intensiveDataRepository;

	public IntensiveProcessingRoute(IntensiveDataRepository intensiveDataRepository) {
		this.intensiveDataRepository = intensiveDataRepository;
	}

	@Override
	public void configure() throws Exception {
		restConfiguration().port(8080);

		rest("/intensive-processing")
				.get()
				.route()
                .routeId("intensive-processing")
                .process(exchange -> {
					String description = (String) exchange.getIn().getHeader("description");
					exchange.getIn().setBody(intensiveDataRepository.findAll()
							.stream()
							.filter(data -> data.getDescription().contains(description))
							.collect(Collectors.toList()));
				})
                .marshal()
                .json(JsonLibrary.Jackson);

	}
}
