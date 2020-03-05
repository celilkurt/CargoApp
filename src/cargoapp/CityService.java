
package cargoapp;

import java.util.ArrayList;

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
    
    
    
    
}
