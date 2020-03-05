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

    static ArrayList<City> cityList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        
        try {
            
            File file = new File("city.txt");
            Scanner sc = new Scanner(file);
            
            createCityList(sc);
            
            sc = new Scanner(file);
            createGraph(sc);
            
            GraphService.findShortestPaths(CityService.findCity(cityList, "Kocaeli"),0,new ArrayList<City>());
            //GraphService.printGraph(cityList);
            CityService.printShortestPath(cityList);
            
            
            /*sc = new Scanner(System.in);
            System.out.print("Hangi şehre gitmek istersiniz: ");
            String cityName = sc.nextLine();
            
            City targetCity = CityService.findCity(cityList, cityName);
            if(targetCity != null){
                
                
                
            }else{
                System.out.println("Bu isimde bir şehir bulunamadı.");
            }*/
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void createCityList(Scanner sc){
        //Her bir şehir için obje oluşturup cityList'e atar.
        
        while(sc.hasNext()){
            
            String[] words = sc.nextLine().split(",");
            cityList.add(new City(words[1],Integer.valueOf(words[0])));
            
        }
        
    }
    
    public static void createGraph(Scanner sc){
        
        while(sc.hasNext()){
            
            String[] words = sc.nextLine().split(",");
            City tempRoot = CityService.findCity(cityList, words[1]);
            
            for(int i = 2; i < words.length; i++){
                City newNeighbor = CityService.findCity(cityList, words[i]);
                
                if(newNeighbor == null){
                    System.out.println(words[i] + " node'u bulunamadı.");
                }else{
                    tempRoot.getNeighborList().add(newNeighbor);
                    tempRoot.getDistanceList().add(Math.abs(tempRoot.getPlateNumber()-newNeighbor.getPlateNumber()));
                }
            }
        }
    }
    
    
    
    
    
}
