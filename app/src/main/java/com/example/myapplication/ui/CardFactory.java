package com.example.myapplication.ui;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    int iteration = 0;

    public CardItem createCard() {
        iteration++;
        String title = "Trip #" + iteration;
        String description = "You prevented xx.xx kt of carbon emissions by walking!";
        return new CardItem(title,description, R.drawable.ic_dashboard_black_24dp);
    }

    public List<CardItem> createCardList() {
        List<CardItem> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(createCard());
        }
        return list;
    }
}
