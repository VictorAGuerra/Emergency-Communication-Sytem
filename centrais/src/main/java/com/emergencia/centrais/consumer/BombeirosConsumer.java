package com.emergencia.centrais.consumer;

import com.emergencia.centrais.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
@Profile("bombeiros")
public class BombeirosConsumer {

    private final String queueName;

    public BombeirosConsumer(Queue filaBombeiros) {
        this.queueName = filaBombeiros.getName();
    }

    @RabbitListener(queues = "#{filaBombeiros.name}")
    public void receberMensagem(String mensagem) {
        System.out.println("[BOMBEIROS] Mensagem recebida na fila '" + queueName + "': " + mensagem);
    }
}
