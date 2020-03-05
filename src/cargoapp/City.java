

package cargoapp;

import java.util.ArrayList;




public class City {
    
    private String name;
    private ArrayList<City> neighborList;
    private ArrayList<Integer> distanceList;
    private int plateNumber;
    private int cost = 0;
    private ArrayList<City> shortestPath;
    
    public City(String name, int plateNumber){
        
        this.name = name;
        this.plateNumber = plateNumber;
        neighborList = new ArrayList<>(); 
        distanceList = new ArrayList<>();
        shortestPath = new ArrayList<>();
    }

    public ArrayList<City> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(ArrayList<City> shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getDistanceList() {
        return distanceList;
    }

    
    
    public ArrayList<City> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(ArrayList<City> neighborList) {
        this.neighborList = neighborList;
    }
    
    

    @Override
    public String toString() {
        return plateNumber + " " + name + " cost: " + cost;
    }
    
    
    
    
    
}
