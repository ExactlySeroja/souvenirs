package com.seroja.menu;

import com.seroja.crud.Creator;
import com.seroja.crud.Deleter;
import com.seroja.crud.Reader;
import com.seroja.crud.Updater;
import com.seroja.persistance.FileCleaner;
import com.seroja.persistance.FileWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Creator creator = new Creator();
    Reader reader = new Reader();
    Updater updater = new Updater();
    Deleter deleter = new Deleter();
    FileWrite fileWriter = new FileWrite();
    FileCleaner fileCleaner = new FileCleaner();
    PrintMenu printMenu = new PrintMenu();

    public void startMenu() {
        try {
            System.out.println("""
                    Choose action:
                    1 - Create new Manufacturer list
                    2 - Create new Souvenir
                    3 - Update Manufacturer
                    4 - Update Souvenir
                    5 - Delete Manufacturer
                    6 - Delete Souvenir
                    7 - Open print menu
                    ----------------------
                    8 - Clear files
                    """);
            int actionNumber = Integer.parseInt(bufferedReader.readLine());
            switch (actionNumber) {
                case 1 -> fileWriter.WriteManufacturerToFile(creator.createManufacturerList());
                case 2 -> fileWriter.WriteSouvenirToFile(creator.createSouvenirList(reader.ReadManufacturerFromFile()));
                case 3 ->
                        fileWriter.WriteManufacturerToFile(updater.updateManufacturerList(reader.ReadManufacturerFromFile()));
                case 4 -> fileWriter.WriteSouvenirToFile(updater.updateSouvenirList(reader.ReadSouvenirFromFile(),
                        reader.ReadManufacturerFromFile()));
                case 5 -> deleter.removeElementFromManufacturersList(reader.ReadManufacturerFromFile());
                case 6 -> deleter.removeElementFromSouvenirsList(reader.ReadSouvenirFromFile());
                case 7 -> printMenu.startPrintMenu();
                case 8 -> {
                    fileCleaner.clearFileSouvenirs();
                    fileCleaner.clearFileManufacturers();
                }
                default -> System.out.println("Wrong action!");
            }
        } catch (IOException e) {
            System.out.println("Unexpected input exception!");
        } catch (ClassNotFoundException e) {
            System.out.println("The class was not found in the given classpath!");
        } catch (NumberFormatException e){
            System.out.println("Wrong data type!");
        }
    }

}
