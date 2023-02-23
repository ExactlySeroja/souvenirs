package com.seroja.factrory;

import com.seroja.souvenirs.Manufacturer;

public class ManufacturerFactory {

    public Manufacturer createManufacturer(String name, String country) {
        return new Manufacturer(name, country);
    }

}
