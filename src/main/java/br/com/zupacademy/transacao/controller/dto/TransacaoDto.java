package br.com.zupacademy.transacao.controller.dto;

import java.math.BigDecimal;

import br.com.zupacademy.transacao.modelo.Transacao;

public class TransacaoDto {
	
	private String id;
	private String efetivadaEm;
	private BigDecimal valor;
	private String cartaoId;
	private String estabelecimentoId;
	

	public TransacaoDto(Transacao transacao) {
		this.id = transacao.getId();
		this.efetivadaEm = transacao.getEfetivadaEm().toString();
		this.valor = transacao.getValor();
		this.cartaoId = transacao.getCartao().getId();
		this.estabelecimentoId = transacao.getEstabelecimento().getId();
	}


	public String getId() {
		return id;
	}


	public String getEfetivadaEm() {
		return efetivadaEm;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public String getCartaoId() {
		return cartaoId;
	}


	public String getEstabelecimentoId() {
		return estabelecimentoId;
	}
	
}
