package br.com.zupacademy.transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.transacao.controller.dto.TransacaoDto;
import br.com.zupacademy.transacao.repository.CartaoRepository;
import br.com.zupacademy.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	@Autowired
	private CartaoRepository cRepository;
	@Autowired
	private TransacaoRepository tRepository;
	
	@GetMapping("/{idCartao}")
	public ResponseEntity<?> buscarTransacoes(@PathVariable String idCartao){
		
		return cRepository.findById(idCartao).isEmpty() ?
				ResponseEntity.notFound().build() :
				ResponseEntity.ok(tRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao)
						.stream().map(TransacaoDto::new));
	}
	

}
