package com.example.simpleaddressbook;

import java.util.ArrayList;

public class TempTester {
    public static void main(String[] args) {
        getStateProvinces();
    }

    public static void getCountries() {
        ArrayList<Country> countries = DBUtility.getCountries();
        System.out.println(countries);
    }

    public static void getStateProvinces() {
        ArrayList<StateProvince> stateProvinces = DBUtility.getStateProvinces();
        System.out.println(stateProvinces);
    }
}
