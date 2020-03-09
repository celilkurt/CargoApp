
package cargoapp;

import java.util.ArrayList;
import java.util.Scanner;


public class CargoApp {

    
    
    public static void main(String[] args) {
        
            GraphService.createCityList("city.txt");
            GraphService.createGraph("city.txt");
            GraphService.findShortestPaths(CityService.findCity(GraphService.getCityList(), "Kocaeli"),0,new ArrayList<City>());
            GraphService.printGraph();
            GraphService.printShortestPath();
            
            
            /*Scanner sc = new Scanner(System.in);
            System.out.print("Şehir isimlerini giriniz: ");
            String str = sc.nextLine();
            
            String[] cities = str.split(" ");
            ArrayList<City> targetCities = new ArrayList<>();
            for(String cityName: cities){
                
                City targetCity = CityService.findCity(GraphService.getCityList(), cityName);
                if(targetCity != null)
                    targetCities.add(targetCity);
                else
                    System.out.println(cityName + " adında bir şehir bulunamadı!");
                
            }*/
            
            /*if(!targetCities.isEmpty()){
                
                ArrayList<City> shortestPath = new ArrayList<>();
                int cost = 0;
                
                for(City city: targetCities)
                    cost += city.getCost();
                
            }*/
            
    }
    
    
    
    
    
    
    
    
    
}
