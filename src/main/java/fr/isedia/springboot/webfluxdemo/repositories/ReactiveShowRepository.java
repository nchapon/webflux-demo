package fr.isedia.springboot.webfluxdemo.repositories;

import fr.isedia.springboot.webfluxdemo.domain.Show;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by nchapon on 13/04/18.
 */
@Repository
public class ReactiveShowRepository implements ReactiveCrudRepository<Show,String> {

    private final Map<String,Show> shows = new ConcurrentHashMap<>();

    public ReactiveShowRepository() {
        shows.put("1", new Show("1","Title1"));
        shows.put("2", new Show("2","Title2"));
        shows.put("3", new Show("3","Title3"));
        shows.put("4", new Show("4","Title4"));
        shows.put("5", new Show("5","Title5"));
        shows.put("6", new Show("6","Title6"));
    }

    @Override
    public <S extends Show> Mono<S> save(S s) {
        return null;
    }

    @Override
    public <S extends Show> Flux<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Show> Flux<S> saveAll(Publisher<S> publisher) {
        return null;
    }

    @Override
    public Mono<Show> findById(String id) {
        return Mono.justOrEmpty(shows.get(id));
    }

    @Override
    public Mono<Show> findById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Flux<Show> findAll() {
        return Flux.fromIterable(shows.values());
    }

    @Override
    public Flux<Show> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public Flux<Show> findAllById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> publisher) {
        return null;
    }

    @Override
    public Mono<Void> delete(Show show) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Show> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Show> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
