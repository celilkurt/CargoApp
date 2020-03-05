

package cargoapp;

import java.util.ArrayList;




public class City {
    
    private String name;
    private ArrayList<City> neighborList;
    private ArrayList<Integer> distanceList;
    private int plateNumber;
    
    public City(String name, int plateNumber){
        
        this.name = name;
        this.plateNumber = plateNumber;
        neighborList = new ArrayList<>(); 
        distanceList = new ArrayList<>();
        
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
        return plateNumber + " " + name;
    }
    
    
    
    
    
}
