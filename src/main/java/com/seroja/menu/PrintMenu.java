package com.seroja.menu;

import com.seroja.controller.MainController;
import com.seroja.crud.Reader;
import com.seroja.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintMenu {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Service service = new Service();
    Reader reader = new Reader();
    MainController mainController = new MainController();

    public void startPrintMenu() {
        try {
            System.out.println("""
                Choose action:
                1 - Display information about the souvenirs of the specified manufacturer.
                2 - Display information about souvenirs produced in the given country.
                3 - Display information about manufacturers whose prices for souvenirs less than specified.
                4 - Display information for all manufacturers and, for each manufacturer, display information about all the souvenirs that it produces.
                5 - Display information about the manufacturers of the given souvenir produced in the given year.
                6 - For each year, display a list of souvenirs produced in given year.
                """);
            int actionNumber = Integer.parseInt(bufferedReader.readLine());
            switch (actionNumber) {
                case 1 -> service.printAllManufacturerSouvenirs(reader.ReadSouvenirFromFile(),
                        mainController.getManufacturerFromInput());
                case 2 -> service.printAllSouvenirsFromCountry(reader.ReadSouvenirFromFile(),
                        mainController.getStringFromInput("Enter filter country"));
                case 3 -> service.printManufacturersWithLowerPrice(mainController.getIntFromInput("Enter filter price"),
                        reader.ReadSouvenirFromFile());
                case 4 -> service.printManufacturesAndTheirSouvenirs(reader.ReadSouvenirFromFile());
                case 5 -> service.printManufacturerSouvenirsInfo(reader.ReadSouvenirFromFile(),
                        mainController.getSouvenirFromInput(), mainController.getDateFromInput());
                case 6 -> service.printSouvenirsThatProducedInThisYear(reader.ReadSouvenirFromFile(),
                        mainController.getDateFromInput());
                default -> System.out.println("Wrong actions");
            }
        } catch (IOException e){
            System.err.println("Unexpected input exception!");
        }
        catch (ClassNotFoundException e ){
            System.err.println("The class was not found in the given classpath!");
        } catch (NumberFormatException e){
            System.err.println("Wrong data type!");
        }
    }

}
