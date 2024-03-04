package exemen.boubs.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exemen.boubs.spring.bto.ClientDTO;
import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.Gestionnaire;
import exemen.boubs.spring.repositories.ClientRepository;
import exemen.boubs.spring.repositories.GestionnaireRepository;


@Service
public class GestionnaireServiceImpl implements GestionnaireService {
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private GestionnaireRepository gestionnaireRepository;

	@Override
	public List<ClientDTO> getAllClients() {

		 List<Client> clients = clientRepository.findAll();
	        
	        List<ClientDTO> clientsDTO = clients.stream()
	                .map(client -> {
	                    ClientDTO clientDTO = new ClientDTO();
	                    clientDTO.setId(client.getId());
	                    clientDTO.setNom(client.getNom());
	                    clientDTO.setPrenom(client.getPrenom());
	                    clientDTO.setEmail(client.getEmail());
	                    clientDTO.setTelephone(client.getTelephone());
	                    clientDTO.setSolde(client.getSolde());
	                    clientDTO.setActive(client.isActive());
	                    
	                    return clientDTO;
	                })
	                .collect(Collectors.toList());
	        return clientsDTO;
	}


		

	@Override
	public Client updateClient(Client client) {
		   
        Optional<Client> optionalClient = clientRepository.findById(client.getId());
        if (optionalClient.isPresent()) {
            
            Client clientFromDB = optionalClient.get();
            
            clientFromDB.setNom(client.getNom());
            clientFromDB.setPrenom(client.getPrenom());
            clientFromDB.setEmail(client.getEmail());
            clientFromDB.setTelephone(client.getTelephone());
            
            return clientRepository.save(clientFromDB);
        } else {
 
            return null;
        }
	}
	
	

    @Override
    public Client bloquerClient(Client client) {
        Optional<Client> optionalClient = clientRepository.findById(client.getId());
        if (optionalClient.isPresent()) {
            Client clientFromDB = optionalClient.get();
            // Inverser la valeur de la colonne "active"
            boolean activeStatus = clientFromDB.isActive();
            clientFromDB.setActive(!activeStatus);
            return clientRepository.save(clientFromDB);
        } else {
            return null;
        }
    }
    
    

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);	
	}
	
	

	 @Override
	 public Gestionnaire createGestionnaire(Gestionnaire gestionnaire) {
 
        if (gestionnaireRepository.existsByEmail(gestionnaire.getEmail())) {
            
            return null;
        } else {
            return gestionnaireRepository.save(gestionnaire);
        }
    }
	 
	 
	 

	@Override
	public Client findByPhoneNumber(String telephone) {
		return clientRepository.findByTelephone(telephone);
	}



	 @Override
	    public Client rechargeCompteClient(String numeroTelephone, double montant) {
	        Client client = clientRepository.findByTelephone(numeroTelephone);
	        
	        if (client == null) {
	            return null;
	        }
	        client.setSolde(client.getSolde() + montant);
	        clientRepository.save(client);
	        return client;
	    }



}
