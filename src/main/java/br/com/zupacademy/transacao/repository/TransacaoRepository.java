package br.com.zupacademy.transacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.transacao.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String idCartao);

}
