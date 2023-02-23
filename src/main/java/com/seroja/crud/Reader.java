package com.seroja.crud;

import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Reader {

    public ArrayList<Souvenir> ReadSouvenirFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Souvenirs.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Souvenir> svList = (ArrayList<Souvenir>) ois.readObject();
        ois.close();
        return svList;
    }

    public ArrayList<Manufacturer> ReadManufacturerFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Manufacturers.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Manufacturer> mfList = (ArrayList<Manufacturer>) ois.readObject();
        ois.close();
        return mfList;
    }
}
