package com.seroja.crud;

import com.seroja.persistance.FileWrite;
import com.seroja.service.Service;
import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Deleter {
    FileWrite fileWriter = new FileWrite();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void removeElementFromSouvenirsList(ArrayList<Souvenir> svList) throws IOException {
        Service.printSouvenirListWithIndex(svList);
        System.out.println("Enter the index of the element to delete");
        int indexToDelete = Integer.parseInt(bufferedReader.readLine());
        svList.remove(indexToDelete);
        fileWriter.WriteSouvenirToFile(svList);
    }

    public void removeElementFromManufacturersList(ArrayList<Manufacturer> mfList) throws IOException {
        Service.printManufacturerListWithIndex(mfList);
        System.out.println("Enter the index of the element to delete");
        int indexToDelete = Integer.parseInt(bufferedReader.readLine());
        mfList.remove(indexToDelete);
        fileWriter.WriteManufacturerToFile(mfList);
    }

}
