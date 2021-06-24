package br.com.zupacademy.transacao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class Transacao {

    private String id;
    private String valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public String getId() {
        return id;
    }

    public String getValor() {
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

class Cartao {
    private String id;
    private String email;

    public Cartao() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}

class Estabelecimento {
    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento() {
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
