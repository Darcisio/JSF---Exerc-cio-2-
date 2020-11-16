package br.com.faculdadedelta.modelo;

public class DescricaoRichard {
	private long id;
	private String desc;
	private String especificacao;
	private String dep;
	private int valor;
	private int data;
	public DescricaoRichard() {
		super();
	}
	public DescricaoRichard(long id, String desc, String especificacao, String dep, int valor,
			int data) {
		super();
		this.id = id;
		this.desc = desc;
		this.especificacao = especificacao;
		this.dep = dep;
		this.valor = valor;
		this.data = data;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DescricaoRichard other = (DescricaoRichard) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
