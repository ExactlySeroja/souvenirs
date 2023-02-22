package com.seroja.crud;

import com.seroja.service.Service;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SouvenirListUpdate {
    Service service = new Service();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Creator svListCreation = new Creator();

    @SneakyThrows
    public ArrayList<Souvenir> updateSouvenirList(ArrayList<Souvenir> svList, ArrayList<Manufacturer> mfList) {
        service.printSouvenirListWithIndex(svList);
        System.out.println("Enter the index of the element to update ");
        int indexToUpdate = Integer.parseInt(reader.readLine());
        System.out.println("Enter new data");
        Souvenir updatedSouvenir = svListCreation.createSouvenir(mfList);
        svList.set(indexToUpdate, updatedSouvenir);
        return svList;
    }

}
