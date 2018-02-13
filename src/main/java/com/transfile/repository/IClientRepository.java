package com.transfile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.transfile.model.Client;

// Classe pour communiquer avec la BDD + Gestion des transactions
public interface IClientRepository extends CrudRepository<Client, Long> {
    
    @Override
    public List<Client> findAll();
}
