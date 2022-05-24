
public class Pessoa {
	private String nome;
	private String fone;
	private String Cidade;
	private String Pais;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
public void imprime() {
	System.out.println("Nome: " + this.nome + " Fone:" + this.fone);
}
}
