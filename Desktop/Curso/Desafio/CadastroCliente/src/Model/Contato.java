package Model;

public class Contato {
	
	private Long id;
	private String ddd;
	private String numero;
	private String email;



	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getDdd() {
		return ddd;
	}






	public void setDdd(String ddd) {
		this.ddd = ddd;
	}






	public String getNumero() {
		return numero;
	}






	public void setNumero(String numero) {
		this.numero = numero;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + ddd + ", numero=" + numero + ", email=" + email +"]";
	}
	
	
	
	
}
