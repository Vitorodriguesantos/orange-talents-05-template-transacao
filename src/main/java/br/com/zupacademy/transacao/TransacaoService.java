package br.com.zupacademy.transacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoService {

    @KafkaListener(topics = "transacoes")
    public void ouvir(Transacao eventoDeTransacao) {

        System.out.println("TRANSACAO -------> "+eventoDeTransacao);
    }
}
