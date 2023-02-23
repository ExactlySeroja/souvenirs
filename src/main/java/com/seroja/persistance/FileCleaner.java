package com.seroja.persistance;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCleaner {

    public void clearFileSouvenirs() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("Souvenirs.txt"));
        writer.write("");
        writer.flush();
    }

    public void clearFileManufacturers() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("Manufacturers.txt"));
        writer.write("");
        writer.flush();
    }

}
