package com.emergencia.centrais.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // Exchange
    public static final String EXCHANGE_NAME = "emergencia-topic-exchange";

    // Filas
    public static final String POLICIA_QUEUE = "fila-policia";
    public static final String BOMBEIROS_QUEUE = "fila-bombeiros";
    public static final String AMBULANCIA_QUEUE = "fila-ambulancia";

    // Routing Keys
    public static final String POLICIA_KEY = "emergencia.policia";
    public static final String BOMBEIROS_KEY = "emergencia.bombeiros";
    public static final String AMBULANCIA_KEY = "emergencia.ambulancia";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue filaPolicia() {
        return new Queue(POLICIA_QUEUE, true);
    }

    @Bean
    public Queue filaBombeiros() {
        return new Queue(BOMBEIROS_QUEUE, true);
    }

    @Bean
    public Queue filaAmbulancia() {
        return new Queue(AMBULANCIA_QUEUE, true);
    }

    @Bean
    public Binding bindingPolicia(Queue filaPolicia, TopicExchange exchange) {
        return BindingBuilder.bind(filaPolicia).to(exchange).with(POLICIA_KEY);
    }

    @Bean
    public Binding bindingBombeiros(Queue filaBombeiros, TopicExchange exchange) {
        return BindingBuilder.bind(filaBombeiros).to(exchange).with(BOMBEIROS_KEY);
    }

    @Bean
    public Binding bindingAmbulancia(Queue filaAmbulancia, TopicExchange exchange) {
        return BindingBuilder.bind(filaAmbulancia).to(exchange).with(AMBULANCIA_KEY);
    }
}

