package com.transfile.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfile.model.Client;
import com.transfile.repository.IClientRepository;

@Service
@Transactional
// Gestion des erreurs + logique métier (nettoyage de données)
public class ClientService {
    
    @Autowired
    private IClientRepository ClientRepository;
    
    public List<Client> findAll() {
        return ClientRepository.findAll();
    }
}
