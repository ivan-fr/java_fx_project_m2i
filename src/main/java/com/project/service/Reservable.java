package com.project.service;

import com.project.exception.PlacesInsuffisantesException;

public interface Reservable {

    void reserver(int userId, int  eventId,int categoryId, int quantite) throws PlacesInsuffisantesException;
}