package com.example.myapplication.ui;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    int iteration = 0;

    public CardItem createCard(String type, int emission) {
        iteration++;
        String title = "Trip #" + iteration;
        String description = "You prevented " + emission + " kt of carbon emissions by " + type + "!";
        return new CardItem(title,description, R.mipmap.ic_launcher);
    }

    public List<CardItem> createCardList(List<Trip> trips) {
        List<CardItem> cards = new ArrayList<>();
        for (Trip trip : trips) {
            cards.add(createCard(trip.getType(), trip.getEmission()));
        }
        return cards;
    }
}
