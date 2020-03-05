/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class CargoApp {

    
    
    public static void main(String[] args) {
        
            GraphService.createCityList("city.txt");
            GraphService.createGraph("city.txt");
            GraphService.findShortestPaths(CityService.findCity(GraphService.getCityList(), "Kocaeli"),0,new ArrayList<City>());
            GraphService.printGraph();
            GraphService.printShortestPath();
            
            
            /*sc = new Scanner(System.in);
            System.out.print("Hangi şehre gitmek istersiniz: ");
            String cityName = sc.nextLine();
            
            City targetCity = CityService.findCity(cityList, cityName);
            if(targetCity != null){
                
                
                
            }else{
                System.out.println("Bu isimde bir şehir bulunamadı.");
            }*/
            
    }
    
    
    
    
    
    
    
    
    
}
