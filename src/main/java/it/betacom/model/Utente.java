package it.betacom.model;

public class Utente {

	private String nome;
	private String cognome;
	private String sesso;
	private String luogoDiNascita;
	private String provincia;
	private String dataDiNascita;
	private String codiceFiscale;
	private String sitoProvenienza;
	private String password;

	public String getNome() {
		return nome;
	}

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, String sesso, String luogoDiNascita, String provincia,
			String dataDiNascita, String codiceFiscale, String sitoProvenienza, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.luogoDiNascita = luogoDiNascita;
		this.provincia = provincia;
		this.dataDiNascita = dataDiNascita;

		this.codiceFiscale = codiceFiscale;
		this.sitoProvenienza = sitoProvenienza;
		this.password = password;

	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getSitoProvenienza() {
		return sitoProvenienza;
	}

	public void setSitoProvenienza(String sitoProvenienza) {
		this.sitoProvenienza = sitoProvenienza;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", luogoDiNascita="
				+ luogoDiNascita + ", provincia=" + provincia + ", dataDiNascita=" + dataDiNascita + ", codiceFiscale="
				+ codiceFiscale + ", sitoProvenienza=" + sitoProvenienza + ", password=" + password + "]";
	}

}
