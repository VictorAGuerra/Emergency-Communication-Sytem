package com.emergencia.centrais.consumer;

import com.emergencia.centrais.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("policia")
public class PoliciaConsumer {

    @RabbitListener(queues = RabbitConfig.POLICIA_QUEUE)
    public void receberMensagem(String mensagem) {
        System.out.println("[POLÍCIA] Mensagem recebida: " + mensagem);
    }
}
