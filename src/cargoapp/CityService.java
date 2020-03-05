/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoapp;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class CityService {
    
    
    public static City findCity(ArrayList<City> cityList, String cityName){
        
        for(City city: cityList)
            if(city.getName().equals(cityName))
                return city;
        
        return null;
        
    }
    
    public static void printAllNeigbor(City city){
        
        ArrayList<City> neighborList = city.getNeighborList();
        ArrayList<Integer> distanceList = city.getDistanceList();
        
        for(int i = 0; i < neighborList.size(); i++){
            System.out.println(neighborList.get(i).toString() + " distance: " + distanceList.get(i));
        }
           
    }
    
    public static void printShortestPath(ArrayList<City> cityList){
        
        for(City city: cityList){
            
            System.out.println(city);
            for(City tempCity: city.getShortestPath())
                System.out.print(tempCity.getName() + " cost: " + tempCity.getCost() + " ");
            
            System.out.println("\n");
        }
            
        
        
        
    }
    
    
}
