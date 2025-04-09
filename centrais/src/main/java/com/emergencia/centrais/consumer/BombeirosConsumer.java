package com.emergencia.centrais.consumer;

import com.emergencia.centrais.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("bombeiros")
public class BombeirosConsumer {

    @RabbitListener(queues = RabbitConfig.BOMBEIROS_QUEUE)
    public void receberMensagem(String mensagem) {
        System.out.println("[BOMBEIROS] Mensagem recebida: " + mensagem);
    }
}