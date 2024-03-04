package exemen.boubs.spring.entities2;

public class RechargeClient {

	 private String numeroTelephone;
	 private double montant;
	 
	 
	public RechargeClient(String numeroTelephone, double montant) {
		super();
		this.numeroTelephone = numeroTelephone;
		this.montant = montant;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	 
	 
}
