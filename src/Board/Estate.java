package Board;

import Rooms.Garden;
import Rooms.Kitchen;
import Rooms.WendysRoom;
import Rooms.plainRoom;

public class Estate {
    private plainRoom[][] Estate;
    public Estate(plainRoom[][] Estate){

        this.Estate = Estate;
    }
    public Estate(int width){

        Estate = new plainRoom[width][width];
    }
    //fills the estate with plain rooms
    public void fillEstate(){
        for(int x = 0; x<Estate.length; x++){
            for(int y=0; y<Estate[x].length; y++){
                Estate[x][y] = new plainRoom(x, y);
            }
        }
    }

    //editing board with new rooms
    public static void edit(plainRoom[][] estate){
        int x, y =0;
        int[][] randNums = new int[estate.length][estate.length];
        int index =0;
        for(int b =0; b<estate.length;b++){
            x=(int)(Math.random()*estate.length);
            y=(int)(Math.random()*estate.length);
            estate[x][y] = new Kitchen(x, y);

        }
    }

    public plainRoom[][] getEstate() {
        return Estate;
    }

    public void printEstate(){
        for(plainRoom[] i : Estate){
            for(plainRoom j : i){
                System.out.println(j);
            }
            System.out.println();
        }
    }
    public void addRoom(plainRoom room,  int row, int col){
        Estate[row][col]= room;
    }
}
