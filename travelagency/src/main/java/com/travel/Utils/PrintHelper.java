package com.travel.Utils;

import java.util.HashMap;
import java.util.Map;

import com.travel.TravelPackage.TravelPackage;

public class PrintHelper {
    public static void printPackages(HashMap<Integer, TravelPackage> tp ){
        for(Map.Entry<Integer, TravelPackage> m: tp.entrySet()){
            System.out.println(m.getValue().getName());
        }
        return;
    }
    public static void designPage(){
        System.out.println("Press");
        System.out.println("1 to View Packages");
        System.out.println("2 to Book Package");
    }
}
