package br.com.zupacademy.transacao.modelo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Estabelecimento {
	
	@Id
	private String id = UUID.randomUUID().toString();
	@NotBlank
    private String nome;
	@NotBlank
    private String cidade;
	@NotBlank
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    	
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

}
