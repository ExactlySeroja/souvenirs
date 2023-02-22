package com.seroja.persistance;

import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {

    public void WriteSouvenirToFile(Souvenir souvenir) {
        try (FileOutputStream fos = new FileOutputStream("Souvenirs.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(souvenir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void WriteManufacturerToFile(Manufacturer manufacturer) {
        try (FileOutputStream fos = new FileOutputStream("Manufacturer.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(manufacturer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearFile() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("Broadcast.txt"));
        writer.write("");
        writer.flush();
    }

}
