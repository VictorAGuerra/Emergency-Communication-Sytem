package com.emergencia.centrais.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
@Profile("ambulancia")
public class AmbulanciaConsumer {

    private final String queueName;

    public AmbulanciaConsumer(Queue filaAmbulancia) {
        this.queueName = filaAmbulancia.getName();
    }

    @RabbitListener(queues = "#{filaAmbulancia.name}")
    public void receberMensagem(String mensagem) {
        System.out.println("[AMBULÂNCIA] Mensagem recebida na fila '" + queueName + "': " + mensagem);
    }
}
