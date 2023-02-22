package com.seroja.crud;

import com.seroja.souvenirs.Souvenir;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SouvenirListRead {

    public ArrayList<Souvenir> ReadSouvenirFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Souvenirs.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Souvenir> svList = (ArrayList<Souvenir>) ois.readObject();
        ois.close();
        return svList;
    }

}
