package com.seroja.crud;

import com.seroja.controller.MainController;
import com.seroja.factrory.ManufacturerFactory;
import com.seroja.factrory.SouvenirFactory;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Creator {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Souvenir> souvenirList = new ArrayList<>();
    ManufacturerFactory mfFactory = new ManufacturerFactory();
    ArrayList<Manufacturer> mfList = new ArrayList<>();
    SouvenirFactory souvenirFactory = new SouvenirFactory();
    MainController cnt = new MainController();

    public ArrayList<Souvenir> createSouvenirList(ArrayList<Manufacturer> mfList) throws IOException {
        System.out.println("Enter Souvenir's amount");
        int souvenirsAmount = Integer.parseInt(bufferedReader.readLine());
        while (souvenirsAmount != 0) {
            Souvenir souvenir = createSouvenir(mfList);
            souvenirList.add(souvenir);
            souvenirsAmount--;
        }
        return souvenirList;
    }

    public Souvenir createSouvenir(ArrayList<Manufacturer> mfList) throws IOException {
        return souvenirFactory.createSouvenir(cnt.getStringFromInput("Enter Souvenir name"), mfList.get(cnt.getMfIndex(mfList)),
                cnt.getDateFromInput(), cnt.getIntFromInput("Enter price"));
    }

    public ArrayList<Manufacturer> createManufacturerList() throws IOException {
        System.out.println("Enter number of Manufacturer's");
        int mfAmount = Integer.parseInt(bufferedReader.readLine());
        while (mfAmount != 0) {
            Manufacturer manufacturer = createManufacturer();
            mfList.add(manufacturer);
            mfAmount--;
        }
        return mfList;
    }

    public Manufacturer createManufacturer() throws IOException {
        return mfFactory.createManufacturer(cnt.getStringFromInput("Enter Manufacturer's name"),
                cnt.getStringFromInput("Enter Manufacturer's country"));
    }



}
