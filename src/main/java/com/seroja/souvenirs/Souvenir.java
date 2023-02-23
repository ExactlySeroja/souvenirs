package com.seroja.souvenirs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Souvenir implements Serializable {

    private String name;
    private Manufacturer manufacturer;
    private LocalDate dateOfIssue;
    private int price;


}
