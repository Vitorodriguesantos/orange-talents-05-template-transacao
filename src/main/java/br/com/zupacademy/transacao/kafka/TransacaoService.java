package br.com.zupacademy.transacao.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.modelo.Transacao;
import br.com.zupacademy.transacao.repository.TransacaoRepository;

@Component
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository tRepository;

    @KafkaListener(topics = "transacoes")
    public void ouvir(TransacaoTransfere eventoDeTransacao) {

        System.out.println("TRANSACAO -------> "+eventoDeTransacao);
        Transacao aTransacao = eventoDeTransacao.converter();
        tRepository.save(aTransacao);
    }
}
