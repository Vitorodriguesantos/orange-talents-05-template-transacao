package br.com.zupacademy.transacao.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
public class Transacao {

	@Id
    private String id;
	@NotNull
    private BigDecimal valor;
	@ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;
	@ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}
