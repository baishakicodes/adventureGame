package Board;

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
    public void printEstate(){
        for(plainRoom[] i : Estate){
            for(plainRoom j : i){
                System.out.println(j);
            }
            System.out.println();
        }
    }
}
