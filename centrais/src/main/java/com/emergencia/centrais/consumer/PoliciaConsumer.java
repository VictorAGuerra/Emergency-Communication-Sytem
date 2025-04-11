package com.emergencia.centrais.consumer;

import com.emergencia.centrais.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
@Profile("policia")
public class PoliciaConsumer {

    private final String queueName;

    public PoliciaConsumer(Queue filaPolicia) {
        this.queueName = filaPolicia.getName();
    }

    @RabbitListener(queues = "#{filaPolicia.name}")
    public void receberMensagem(String mensagem) {
        System.out.println("[POLÍCIA] Mensagem recebida na fila '" + queueName + "': " + mensagem);
    }
}
