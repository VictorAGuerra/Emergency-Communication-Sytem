package com.emergencia.centrais.consumer;

import com.emergencia.centrais.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("ambulancia")
public class AmbulanciaConsumer {

    @RabbitListener(queues = RabbitConfig.AMBULANCIA_QUEUE)
    public void receberMensagem(String mensagem) {
        System.out.println("[AMBULÂNCIA] Mensagem recebida: " + mensagem);
    }
}