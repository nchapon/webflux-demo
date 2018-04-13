package fr.isedia.springboot.webfluxdemo.handlers;

import fr.isedia.springboot.webfluxdemo.domain.ShowEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

/**
 * Created by nchapon on 13/04/18.
 */
@Component
public class ShowEventHandler {

    public Mono<ServerResponse> events(ServerRequest serverRequest){
        String showId = serverRequest.pathVariable("id");
        Flux<ShowEvent> showEvents = Flux.<ShowEvent>generate(sink -> sink.next(new ShowEvent(showId, new Date()))).delayElements(Duration.ofSeconds(1));
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(showEvents,ShowEvent.class);
    }


}
