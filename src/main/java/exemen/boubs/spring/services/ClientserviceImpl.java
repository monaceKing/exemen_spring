package exemen.boubs.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exemen.boubs.spring.entities2.Client;
import exemen.boubs.spring.entities2.TransfertArgent;
import exemen.boubs.spring.repositories.ClientRepository;

@Service
public class ClientserviceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;


	@Override
	public Client findClientById(Long id) {
		Optional<Client> optional = clientRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client transfertArgent(TransfertArgent transfertArgent) {
        Client emetteur = clientRepository.findByTelephone(transfertArgent.getNumeroTelephoneEmetteur());
        
        Client receveur = clientRepository.findByTelephone(transfertArgent.getNumeroTelephoneReceveur());

        if (emetteur == null || receveur == null) {
            return null;
        }

        if (emetteur.getSolde() >= transfertArgent.getMontant()) {
            emetteur.setSolde(emetteur.getSolde() - transfertArgent.getMontant());

            receveur.setSolde(receveur.getSolde() + transfertArgent.getMontant());

            clientRepository.save(emetteur);
            clientRepository.save(receveur);

            return emetteur;
        } else {
            
            return null;
        }
    }

	@Override
	public Double consulterSoldeClient(String numeroTelephone) {
		 Client client = clientRepository.findByTelephone(numeroTelephone);
		    if (client != null) {
		        return client.getSolde();
		    } else {
		        return null;
		    }
	}
	

}

