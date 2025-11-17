package com.project.controller;

import com.project.service.Reservable;
import com.project.service.ReservableImpl;

public class ReservationController {

    public void reserve(int clientId,int eventId,int categoryId, int quantity) throws Exception {
        Reservable reservable=new ReservableImpl();
        reservable.reserver(clientId,eventId,categoryId,quantity);
    }
}
