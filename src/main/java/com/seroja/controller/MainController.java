package com.seroja.controller;

import com.seroja.crud.Reader;
import com.seroja.service.Service;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainController {
    Reader reader = new Reader();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Manufacturer getManufacturerFromInput() throws IOException, ClassNotFoundException {
        ArrayList<Manufacturer> mfList = reader.ReadManufacturerFromFile();
        System.out.println("Choose Manufacturer index");
        Service.printManufacturerListWithIndex(mfList);
        int mfIndex = Integer.parseInt(bufferedReader.readLine());
        return mfList.get(mfIndex);
    }

    public String getSouvenirFromInput() throws IOException, ClassNotFoundException {
        ArrayList<Souvenir> svList = reader.ReadSouvenirFromFile();
        System.out.println("Enter souvenirs name");
        svList.forEach(System.out::println);
        return bufferedReader.readLine();
    }

    public LocalDate getDateFromInput() throws IOException {
        System.out.println("Enter date");
        String date = bufferedReader.readLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dateFormat);
    }

    public int getIntFromInput(String x) throws IOException {
        System.out.println(x);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public String getStringFromInput(String x) throws IOException {
        System.out.println(x);
        return bufferedReader.readLine();
    }

    public int getMfIndex(ArrayList<Manufacturer> mfList) throws IOException {
        System.out.println("Choose Manufacturer index");
        Service.printManufacturerListWithIndex(mfList);
        return Integer.parseInt(bufferedReader.readLine());
    }

}
