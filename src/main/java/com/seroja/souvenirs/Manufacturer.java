package com.seroja.souvenirs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer implements Serializable {

    private String name;
    private String country;

}
