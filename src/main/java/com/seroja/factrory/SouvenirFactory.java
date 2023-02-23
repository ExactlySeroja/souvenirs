package com.seroja.factrory;

import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.time.LocalDate;

public class SouvenirFactory {

    public Souvenir createSouvenir(String name, Manufacturer manufacturer, LocalDate dateOfIssue, int price) {
        return new Souvenir(name, manufacturer, dateOfIssue, price);
    }

}
