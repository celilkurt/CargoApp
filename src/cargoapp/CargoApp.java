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
            City root = null;
            
            File file = new File("city.txt");
            Scanner sc = new Scanner(file);
            
            cityList = createCityList(sc,cityList);
            
            sc = new Scanner(file);
            createGraph(sc , root);
            
            for(City tempCity: cityList){
                System.out.println("--------------------------------------------");
                System.out.println(tempCity.toString() + "\n");
                tempCity.printAllNeigbor();
            }
                
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<City> createCityList(Scanner sc, ArrayList<City> list){
        
        while(sc.hasNext()){
            
            String[] words = sc.nextLine().split(",");
            list.add(new City(words[1],Integer.valueOf(words[0])));
            
            
        }
        
        return list;
        
    }
    
    public static void createGraph(Scanner sc, City root){
        
        
        while(sc.hasNext()){
            
            String[] words = sc.nextLine().split(",");
            City tempRoot = City.findCity(cityList, words[1]);
            
            for(int i = 2; i < words.length; i++){
                City newNeighbor = City.findCity(cityList, words[i]);
                
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
