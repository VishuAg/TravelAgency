package com.travel;

import java.util.ArrayList;

import com.travel.TravelPackage.TravelPackage;
import com.travel.Utils.PrintHelper;
import com.travel.Utils.UploadHelper;

public class TravelAgency {
    private ArrayList<TravelPackage> travelPackages;
    public TravelAgency(){
        populatePackages();
    }
    private void populatePackages(){
        travelPackages = UploadHelper.getPackages();
    }
    public ArrayList<TravelPackage> getTravelPackages() {
        return travelPackages;
    }
    public void viewPackages(){
        PrintHelper.printPackages(travelPackages);
        return;
    }
}
