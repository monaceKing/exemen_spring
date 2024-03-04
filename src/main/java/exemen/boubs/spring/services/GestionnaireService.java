package exemen.boubs.spring.services;

import java.util.List;

import exemen.boubs.spring.bto.ClientDTO;
import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.Gestionnaire;

public interface GestionnaireService {
	public Gestionnaire createGestionnaire(Gestionnaire gestionnaire);
	public List<ClientDTO> getAllClients();//Ok
	public Client updateClient(Client client);//Ok
	public Client bloquerClient(Client client);//Ok
	public void deleteClient(Long id);//Ok
	//public Client rechargeCompteClient(Client client);//Ok
	public Client findByPhoneNumber(String telephone);
	public Client rechargeCompteClient(String numeroTelephone, double montant);
}
