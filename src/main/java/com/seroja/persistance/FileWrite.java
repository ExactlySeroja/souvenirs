package com.seroja.persistance;

import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileWrite {

    public void WriteSouvenirToFile(ArrayList<Souvenir> svList) {
        try {
            FileOutputStream writeData = new FileOutputStream("Souvenirs.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(svList);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteManufacturerToFile(ArrayList<Manufacturer> mfList) {
        try {
            FileOutputStream writeData = new FileOutputStream("Manufacturers.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(mfList);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
