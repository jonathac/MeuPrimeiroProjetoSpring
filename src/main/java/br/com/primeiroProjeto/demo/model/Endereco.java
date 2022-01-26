package br.com.primeiroProjeto.demo.model;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(allocationSize = 1, name = "endereco", sequenceName = "sq_endereco")
@ManagedBean
public class Endereco {

	@Id
	@GeneratedValue(generator = "endereco", strategy = GenerationType.IDENTITY)
	@Column(name = "cd_id")
	private long id;

	@Column(name = "nm_rua")
	private String rua;

	@Column(name = "nm_bairro")
	private String bairro;

	@Column(name = "nm_cidade")
	private String cidade;

	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco() {
	}

	public Endereco(String rua, String bairro, String cidade) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
