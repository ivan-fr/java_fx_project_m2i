package com.project.service;

import com.project.dao.CategoryPlaceDAO;
import com.project.dao.ReservationDAO;
import com.project.entity.Reservation;

import com.project.exception.PlacesInsuffisantesException;

import java.time.LocalDateTime;

public class ReservableImpl implements Reservable {

    private final CategoryPlaceDAO categoryDao;
    private final ReservationDAO reservationDao;

    public ReservableImpl() {
        categoryDao = new CategoryPlaceDAO();
        reservationDao = new ReservationDAO();
    }

    @Override
    public void reserver(int userId, int  eventId,int categoryId, int quantite)
            throws PlacesInsuffisantesException {


        int placesDisponibles = categoryDao.getPlacesDisponibles(categoryId);
        if (placesDisponibles < quantite) {
            System.out.println("Erreur : Plus de places disponibles pour cette catégorie");
            throw new PlacesInsuffisantesException("Pas assez de places !");
        }
        for(int i=0;i<quantite;i++) {
            Reservation reservation = new Reservation(userId, eventId, categoryId, LocalDateTime.now());
            reservationDao.ajouterReservation(reservation);
        }



    }
}