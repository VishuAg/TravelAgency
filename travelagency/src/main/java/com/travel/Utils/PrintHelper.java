package com.travel.Utils;

import java.util.ArrayList;

import com.travel.TravelPackage.TravelPackage;

public class PrintHelper {
    public static void printPackages(ArrayList<TravelPackage> tp ){
        for(int i=0;i<tp.size();i++){
            System.out.println(tp.get(i).getName());
        }
        return;
    }
}
