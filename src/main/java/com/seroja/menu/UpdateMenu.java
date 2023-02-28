package com.seroja.menu;

import com.seroja.crud.Reader;
import com.seroja.crud.Updater;
import com.seroja.persistance.FileWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateMenu {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    FileWrite fileWriter = new FileWrite();
    Updater updater = new Updater();
    Reader reader = new Reader();
    public void startUpdateMenu(){
        try {
            System.out.println("""
                    Choose action:
                    1 - Add new Manufacturer to list
                    2 - Add new Souvenir to list
                    3 - Update Manufacturers list
                    4 - Update Souvenirs list
                    """);
            int actionNumber = Integer.parseInt(bufferedReader.readLine());
            switch (actionNumber){
                case 1 -> fileWriter.WriteManufacturerToFile(updater.addNewElementToManufacturers(reader.ReadManufacturerFromFile()));
                case 2 -> fileWriter.WriteSouvenirToFile(updater.addNewElementToSouvenirs(reader.ReadSouvenirFromFile(),
                        reader.ReadManufacturerFromFile()));
                case 3 ->
                        fileWriter.WriteManufacturerToFile(updater.updateManufacturerList(reader.ReadManufacturerFromFile()));
                case 4 -> fileWriter.WriteSouvenirToFile(updater.updateSouvenirList(reader.ReadSouvenirFromFile(),
                        reader.ReadManufacturerFromFile()));
            }
        } catch (IOException e){
            System.err.println("Unexpected input exception!");
        } catch (ClassNotFoundException e) {
            System.err.println("The class was not found in the given classpath!");
        }

    }
}
