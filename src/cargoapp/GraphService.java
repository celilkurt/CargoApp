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

public class GraphService {
    
    private static ArrayList<City> cityList = new ArrayList<>();
    
    public static void createGraph(String fileName){
        
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            
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
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya açılamadı.");
        }
    }

    public static void findShortestPaths(City tempRoot, int cost, ArrayList<City> travelPath) {

        ArrayList<City> tempTravel = (ArrayList<City>) travelPath.clone();

        

        if (cost < tempRoot.getCost() || tempRoot.getCost() == 0) {
            
            tempTravel.add(tempRoot);
            tempRoot.setCost(cost);
            tempRoot.setShortestPath(tempTravel);

        } else {
            return;
        }

        for (City tempCity : tempRoot.getNeighborList()) {

            if (!tempTravel.contains(tempCity)) {

                findShortestPaths(tempCity, cost + Math.abs(tempRoot.getPlateNumber() - tempCity.getPlateNumber()), tempTravel);

            }

        }

    }
    
    public static void printGraph(){
        
        for(City tempCity: cityList){
                System.out.println("--------------------------------------------");
                System.out.println(tempCity.toString() + "\n");
                CityService.printAllNeigbor(tempCity);
            }
        
    }
    
    
    public static void printShortestPath(){
        
        for(City city: cityList){
            
            System.out.println(city);
            for(City tempCity: city.getShortestPath())
                System.out.print(tempCity.getName() + " cost: " + tempCity.getCost() + " ");
            
            System.out.println("\n");
        }
        
    }

    public static ArrayList<City> getCityList() {
        return cityList;
    }
    
    public static void createCityList(String fileName){
        //Her bir şehir için obje oluşturup cityList'e atar.
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while(sc.hasNext()){

                String[] words = sc.nextLine().split(",");
                cityList.add(new City(words[1],Integer.valueOf(words[0])));

            }
            
        }catch(Exception ex){
            
        }
        
    }

}
