package org.example.forture;

import java.util.Map;

public enum FortureTeller {
    INSTANCE;

    private String[] cards;

    FortureTeller() {
        cards = new String[4];
        cards[0] = "대길";
        cards[1] = "소길";
        cards[2] = "소흉";
        cards[3] = "대흉";
    }

    public String getOne() {
        int idx = (int)(Math.random() * cards.length);//0,1,2,3
        return cards[idx];
    }

}
