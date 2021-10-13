/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Efrey Guerrero Angarita
 */
@Service
public class ClientService{
        @Autowired
        private ClientRepository repositoryC;

        //Crud - Create - post
        public Client saveClient(Client client){
            return repositoryC.save(client);
        }

        //cRud - Read - get
        public List<Client> getClientAll() {
            return repositoryC.findAll();
        }

        //crUd - Update - put
        public Client updateClient(Client client) {
            Client existClient=repositoryC.findById(client.getIdClient()).orElse(null);
            existClient.setEmail(client.getEmail());
            existClient.setPassword(client.getPassword());
            existClient.setName(client.getName());
            existClient.setAge(client.getAge());
            return repositoryC.save(existClient);
        }

        //cruD - Delete - delete
        public String deleteClient(Client client){
            repositoryC.deleteById(client.getIdClient());
            return "Registro de ID: "+client.getIdClient()+" ha sido eliminado";
        }
}
