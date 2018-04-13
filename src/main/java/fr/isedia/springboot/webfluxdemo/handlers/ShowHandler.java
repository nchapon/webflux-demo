package fr.isedia.springboot.webfluxdemo.handlers;

import fr.isedia.springboot.webfluxdemo.domain.Show;
import fr.isedia.springboot.webfluxdemo.repositories.ReactiveShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by nchapon on 13/04/18.
 */
@Component
public class ShowHandler {

    private final ReactiveShowRepository showRepository;

    public ShowHandler(ReactiveShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Mono<ServerResponse> all(ServerRequest serverRequest){
        Flux<Show> shows = showRepository.findAll();
        return ServerResponse.ok().body(shows,Show.class);
    }

    public Mono<ServerResponse> byId(ServerRequest serverRequest){
        Mono<Show> show = showRepository.findById(serverRequest.pathVariable("id"));
        return ServerResponse.ok().body(show,Show.class);
    }



}
