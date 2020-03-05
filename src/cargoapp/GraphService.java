/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoapp;

import java.util.ArrayList;

public class GraphService {

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
    
    public static void printGraph(ArrayList<City> cityList){
        
        for(City tempCity: cityList){
                System.out.println("--------------------------------------------");
                System.out.println(tempCity.toString() + "\n");
                CityService.printAllNeigbor(tempCity);
            }
        
    }

}
