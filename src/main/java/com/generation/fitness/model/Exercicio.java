package com.generation.fitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

	@Entity
	@Table(name = "tb_exercicios") 
	
	public class Exercicio {

		@Id //PK (id)
		@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
		private Long id;
		
		@Column(length = 20) 
		@NotBlank(message = "O atributo nome é obrigatório!") // NOT NULL
		@Size(min = 5, max = 20, message = "O atributo nome deve conter no mínimo 05 e no máximo 20 caracteres")
		private String nome;
		
		@Column(nullable = false) 
		@NotNull(message = "O atributo tempo é obrigatório!") // NOT NULL
		private Integer tempo;
		
		@Column(length = 20) 
		@NotBlank(message = "O atributo nível é obrigatório!") // NOT NULL
		@Size(min = 5, max = 20, message = "O atributo nível deve conter no mínimo 05 e no máximo 20 caracteres")
		private String nivel;
				
		@Column
		@NotBlank(message = "O atributo descricao é obrigatório!") // NOT NULL
		private String descricao;	 
	   
	    @Column
	    @NotBlank(message = "O atributo linkAcesso é obrigatório!") // NOT NULL
	    private String linkAcesso;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getTempo() {
			return tempo;
		}

		public void setTempo(Integer tempo) {
			this.tempo = tempo;
		}

		public String getNivel() {
			return nivel;
		}

		public void setNivel(String nivel) {
			this.nivel = nivel;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getLinkAcesso() {
			return linkAcesso;
		}

		public void setLinkAcesso(String linkAcesso) {
			this.linkAcesso = linkAcesso;
		} 
			
}
