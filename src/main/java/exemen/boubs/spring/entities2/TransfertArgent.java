package exemen.boubs.spring.entities2;

public class TransfertArgent {
	
	private String numeroTelephoneEmetteur;
    private String numeroTelephoneReceveur;
    private double montant;
    
	public TransfertArgent(String numeroTelephoneEmetteur, String numeroTelephoneReceveur, double montant) {
		super();
		this.numeroTelephoneEmetteur = numeroTelephoneEmetteur;
		this.numeroTelephoneReceveur = numeroTelephoneReceveur;
		this.montant = montant;
	}
	public String getNumeroTelephoneEmetteur() {
		return numeroTelephoneEmetteur;
	}
	public void setNumeroTelephoneEmetteur(String numeroTelephoneEmetteur) {
		this.numeroTelephoneEmetteur = numeroTelephoneEmetteur;
	}
	public String getNumeroTelephoneReceveur() {
		return numeroTelephoneReceveur;
	}
	public void setNumeroTelephoneReceveur(String numeroTelephoneReceveur) {
		this.numeroTelephoneReceveur = numeroTelephoneReceveur;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
    
    
    
}
