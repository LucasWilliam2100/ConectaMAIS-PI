package com.GrupoConecta.ConectaMais.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	/* atributos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long postagemID; // id do postagem no nosso sistema

	@NotBlank
	@Max(100)
	private String titulo; // título da postagem

	@NotBlank
	@Max(500)
	@Column(name = "conteudo")
	private String conteudoPostagem; // conteúdo da postagem

	@NotBlank
	@Max(10)
	private String tema; // tema da postagem: {inscricao, evento, noticias}

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoPostagem = new java.sql.Date(System.currentTimeMillis()); // data de criação da postagem

	@Column(name = "data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacaoPostagem = new java.sql.Date(System.currentTimeMillis()); // data de atualizaçcão da postagem

	/* relação entre tabelas */
	@ManyToOne //declaração de relacionamento entre tabelas: postagem e instituição
	@JsonIgnoreProperties("postagemObj") //declaraçao de chave estrageira da tabela, ignorando coluna postagem em tabela instituição
	private Instituicao instituicaoObj; //indicação da insituição que fez a postagem

	@OneToMany(mappedBy = "postagemObj", cascade = CascadeType.ALL) //mapeamento por coluna postagem e efeito cascata em tabela comentário
	@JsonIgnoreProperties("postagemObj") //declaraçao de chave estrageira da tabela comentário, ignorando coluna postagem
	private List<Comentario> comentarioObj; //listagem dos comentários feitas na postagem

	/* método */
	public long getPostagemID() {
		return postagemID;
	}

	public void setPostagemID(long postagemID) {
		this.postagemID = postagemID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudoPostagem;
	}

	public void setConteudo(String conteudoPostagem) {
		this.conteudoPostagem = conteudoPostagem;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getDataCriacao() {
		return dataCriacaoPostagem;
	}

	public void setDataCriacao(Date dataCriacaoPostagem) {
		this.dataCriacaoPostagem = dataCriacaoPostagem;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacaoPostagem;
	}

	public void setDataAtualizacao(Date dataAtualizacaoPostagem) {
		this.dataAtualizacaoPostagem = dataAtualizacaoPostagem;
	}

	public Instituicao getInstituicaoObj() {
		return instituicaoObj;
	}

	public void setInstituicaoObj(Instituicao instituicaoObj) {
		this.instituicaoObj = instituicaoObj;
	}

	public List<Comentario> getComentarioObj() {
		return comentarioObj;
	}

	public void setComentarioObj(List<Comentario> comentarioObj) {
		this.comentarioObj = comentarioObj;
	}
}
