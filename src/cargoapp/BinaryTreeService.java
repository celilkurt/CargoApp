
package cargoapp;

import java.util.ArrayList;



public class BinaryTreeService {
    
    private ArrayList<City> cityList;
    private Node root;
    
    public BinaryTreeService(ArrayList<City> cityList ) {
        this.cityList = (ArrayList<City>)cityList.clone();
        this.root = null;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    boolean key = true;
    public void createBinaryTree(){
     
        while(!cityList.isEmpty()){
            
            int i = (int)Math.random()%(cityList.size());
            if(key){
                root = insertNode(root,cityList.get(i));
                key = false;
            }else
                insertNode(root,cityList.get(i));
            cityList.remove(i);
        }
        
        printBinaryTree(root);
        
    }
    
    private Node insertNode(Node root, City city){
        
        if(root == null){
            root = new Node(city);
        }else if(root.getCity().getPlateNumber() > city.getPlateNumber()){
            insertNode(root.getLeft(),city);
        }else{
            insertNode(root.getRight(),city);
        }
        
        return root;
    }
    
    private void printBinaryTree(Node root){
        
        if(root.getRight() != null)
            printBinaryTree(root.getRight());
        
        System.out.println(root.getCity());
        
        if(root.getLeft() != null)
            printBinaryTree(root.getLeft());
        
    }
    
}

class Node{
    
    private City city;
    private Node left;
    private Node right;

    public Node(City city) {
        this.city = city;
        
    }

    public City getCity() {
        return city;
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
    
    
}
