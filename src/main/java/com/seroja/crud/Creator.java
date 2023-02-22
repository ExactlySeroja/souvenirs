package com.seroja.crud;

import com.seroja.factrory.SouvenirFactory;
import com.seroja.service.Service;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SouvenirListCreation {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Souvenir> souvenirList = new ArrayList<>();
    Service service = new Service();
    SouvenirFactory souvenirFactory = new SouvenirFactory();

    public ArrayList<Souvenir> createSouvenirList(ArrayList<Manufacturer> mfList) throws IOException {
        System.out.println("Enter Souvenir's amount");
        int souvenirsAmount = Integer.parseInt(reader.readLine());
        while (souvenirsAmount != 0) {
            Souvenir souvenir = createSouvenir(mfList);
            souvenirList.add(souvenir);
            souvenirsAmount--;
        }
        return souvenirList;
    }

    public Souvenir createSouvenir(ArrayList<Manufacturer> mfList) throws IOException {
        System.out.println("Enter Souvenir name");
        String souvenirName = reader.readLine();
        System.out.println("Choose Manufacturer index");
        mfList.forEach(System.out::println);
        service.printManufacturerListWithIndex(mfList);
        int mfIndex = Integer.parseInt(reader.readLine());
        System.out.println("Enter Souvenir date of issue");
        String date = reader.readLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfIssue = LocalDate.parse(date, dateFormat);
        System.out.println("Enter price");
        int price = Integer.parseInt(reader.readLine());
        Souvenir souvenir = souvenirFactory.createSouvenir(souvenirName, mfList.get(mfIndex), dateOfIssue, price);
        return souvenir;
    }


}
