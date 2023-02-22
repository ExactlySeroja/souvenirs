package com.seroja.crud;

import com.seroja.persistance.FileWrite;
import com.seroja.service.Service;
import com.seroja.souvenirs.Souvenir;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SouvenirListDelete {
    Service service = new Service();
    FileWrite fileWriter = new FileWrite();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ArrayList<Souvenir> clearSouvenirList(ArrayList<Souvenir> svList) {
        svList.clear();
        return svList;
    }

    @SneakyThrows
    public void removeElementFromManufacturerList(ArrayList<Souvenir> svList) {
        service.printSouvenirListWithIndex(svList);
        System.out.println("Enter the index of the element to delete");
        int indexToDelete = Integer.parseInt(reader.readLine());
        svList.remove(indexToDelete);
        fileWriter.WriteSouvenirToFile(svList);
    }

}
