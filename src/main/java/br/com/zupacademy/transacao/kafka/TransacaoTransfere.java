package br.com.zupacademy.transacao.kafka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.zupacademy.transacao.modelo.Cartao;
import br.com.zupacademy.transacao.modelo.Estabelecimento;
import br.com.zupacademy.transacao.modelo.Transacao;

public class TransacaoTransfere {
	
	private String id;
    private BigDecimal valor;
    private EstabelecimentoTransfere estabelecimento;
    private CartaoTransfere cartao;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime efetivadaEm;

    public TransacaoTransfere() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoTransfere getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoTransfere getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

	public Transacao converter() {
		Estabelecimento oEstab = new Estabelecimento(getEstabelecimento().getNome(), getEstabelecimento().getCidade(), getEstabelecimento().getEndereco());
		Cartao oCartao = new Cartao(getCartao().getId(), getCartao().getEmail());
		return new Transacao(id, valor, oEstab, oCartao, efetivadaEm);
	}
    
}

class CartaoTransfere {
    private String id;
    private String email;

    public CartaoTransfere() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}

class EstabelecimentoTransfere {
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoTransfere() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

}


