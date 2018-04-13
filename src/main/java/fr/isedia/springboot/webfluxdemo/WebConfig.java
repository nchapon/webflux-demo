package fr.isedia.springboot.webfluxdemo;

import fr.isedia.springboot.webfluxdemo.handlers.ShowEventHandler;
import fr.isedia.springboot.webfluxdemo.handlers.ShowHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.*;

/**
 * Created by nchapon on 13/04/18.
 */

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> routeShow(ShowHandler showHandler, ShowEventHandler showEventHandler){

        return RouterFunctions
                .route(RequestPredicates.GET("/shows/{id}/events"),showEventHandler::events)
                .andRoute(RequestPredicates.GET("/shows/{id}"),showHandler::byId)
                .andRoute(RequestPredicates.GET("/shows"),showHandler::all);

    }



}
