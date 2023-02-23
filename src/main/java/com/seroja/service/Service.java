package com.seroja.service;

import com.seroja.souvenirs.Manufacturer;
import com.seroja.souvenirs.Souvenir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {

    public static void printManufacturerListWithIndex(ArrayList<Manufacturer> mfList) {
        HashMap<Integer, Manufacturer> collect = mfList
                .stream()
                .collect(HashMap::new, (map, streamValue) -> map.put(map.size(), streamValue), (map, map2) -> {});
        collect.forEach((k, v) -> System.out.println(k + ":" + v + " "));
    }

    public static void printSouvenirListWithIndex(ArrayList<Souvenir> svList) {
        HashMap<Integer, Souvenir> collect = svList
                .stream()
                .collect(HashMap::new, (map, streamValue) -> map.put(map.size(), streamValue), (map, map2) -> {});
        collect.forEach((k, v) -> System.out.println(k + ":" + v + " "));
    }

    public void printAllManufacturerSouvenirs(ArrayList<Souvenir> svList, Manufacturer filterManufacturer) {
        svList
                .stream()
                .filter(c -> c.getManufacturer().equals(filterManufacturer))
                .forEach(System.out::println);
    }

    public void printAllSouvenirsFromCountry(ArrayList<Souvenir> svList, String country) {
        svList
                .stream()
                .filter(c -> c.getManufacturer().getCountry().equals(country)).forEach(System.out::println);
    }

    public void printManufacturersWithLowerPrice(int price, ArrayList<Souvenir> svList) {
        List<Souvenir> tempList = svList.stream().filter(c -> c.getPrice() < price).toList();
        for (Souvenir souvenir : tempList) {
            System.out.println(souvenir.getManufacturer());
        }
    }

    public void printManufacturesAndTheirSouvenirs(ArrayList<Souvenir> svList) {
        HashMap<Manufacturer, Souvenir> tempMap = new HashMap<>();
        for (Souvenir souvenir : svList) {
            tempMap.put(souvenir.getManufacturer(), souvenir);
        }
        tempMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void printManufacturerSouvenirsInfo(ArrayList<Souvenir> svList, String svName, LocalDate date) {
        for (Souvenir souvenir : svList) {
            if (souvenir.getDateOfIssue().equals(date) || souvenir.getName().equals(svName)) {
                System.out.println(souvenir.getManufacturer());
            }
        }
    }

    public void printSouvenirsThatProducedInThisYear(ArrayList<Souvenir> svList, LocalDate date) {
        svList.stream().filter(c -> c.getDateOfIssue().equals(date)).forEach(System.out::println);
    }

}
