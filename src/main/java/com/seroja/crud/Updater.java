package com.seroja.crud;

import com.seroja.service.Service;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Updater {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Creator creator = new Creator();

    public ArrayList<Souvenir> updateSouvenirList(ArrayList<Souvenir> svList, ArrayList<Manufacturer> mfList) throws IOException {
        Service.printSouvenirListWithIndex(svList);
        System.out.println("Enter the index of the element to update ");
        int indexToUpdate = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter new data");
        Souvenir updatedSouvenir = creator.createSouvenir(mfList);
        svList.set(indexToUpdate, updatedSouvenir);

        return svList;
    }

    public ArrayList<Manufacturer> updateManufacturerList(ArrayList<Manufacturer> mfList) throws IOException {
        Service.printManufacturerListWithIndex(mfList);
        System.out.println("Enter the index of the element to update");
        int indexToUpdate = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter new data");
        Manufacturer updatedManufacturer = creator.createManufacturer();
        mfList.set(indexToUpdate, updatedManufacturer);
        return mfList;
    }

    public ArrayList<Souvenir> addNewElementToSouvenirs(ArrayList<Souvenir> svList, ArrayList<Manufacturer> mfList) throws IOException{
        System.out.println("Enter Souvenir's amount");
        int souvenirsAmount = Integer.parseInt(bufferedReader.readLine());
        while (souvenirsAmount != 0) {
            Souvenir souvenir = creator.createSouvenir(mfList);
            svList.add(souvenir);
            souvenirsAmount--;
        }
        return svList;
    }
    public ArrayList<Manufacturer> addNewElementToManufacturers(ArrayList<Manufacturer> mfList) throws IOException{
        System.out.println("Enter Manufacturer's amount");
        int mfAmount = Integer.parseInt(bufferedReader.readLine());
        while (mfAmount != 0) {
            Manufacturer manufacturer = creator.createManufacturer();
            mfList.add(manufacturer);
            mfAmount--;
        }
        return mfList;
    }

}
