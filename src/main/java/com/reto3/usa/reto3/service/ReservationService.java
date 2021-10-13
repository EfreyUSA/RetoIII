/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Reservation;
import com.reto3.usa.reto3.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Efrey Guerrero Angarita
 */
@Service
public class ReservationService {
        
        
        
        @Autowired
        private ReservationRepository repositoryR;
    
        //Crud - Create - post
        public Reservation saveReservation(Reservation reservation){
                return repositoryR.save(reservation);
        }
    
        //cRud - Read - get
        public List<Reservation> getReservationAll() {
                return repositoryR.findAll();
        }
    
        //crUd - Update - put
        public Reservation updateReservation(Reservation reservation) {
                Reservation existReservation=repositoryR.findById(reservation.getIdReservation()).orElse(null);
                existReservation.setStartDate(reservation.getStartDate());
                existReservation.setDevolutionDate(reservation.getDevolutionDate());
                return repositoryR.save(existReservation);
        }

        //cruD - Delete - delete
        public String deleteReservation(Reservation reservation){
                repositoryR.deleteById(reservation.getIdReservation());
                return "Registro de ID: "+reservation.getIdReservation()+" ha sido eliminado";
        }

        
        
        
        
        
        
        
}
