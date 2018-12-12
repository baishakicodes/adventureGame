package Board;

import People.player;
import Rooms.*;

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
        estate[0][0]= new startingRoom(0,0);
        int x, y =0;
        for(int b=0;b<1; b++){
            x = (int) (Math.random() * estate.length);
            y = (int) (Math.random() * estate.length);
            estate[x][y]=new Kitchen(x, y);
        }
        for(int b=0;b<1; b++){
            x = (int) (Math.random() * estate.length);
            y = (int) (Math.random() * estate.length);
            if(estate[x][y]==null) {
                estate[x][y] = new WendysRoom(x, y);
            }
            else{
                x = (int) (Math.random() * estate.length);
                y = (int) (Math.random() * estate.length);
                estate[x][y] = new WendysRoom(x, y);
            }
        }
        for(int b=0;b<1; b++){
            x = (int) (Math.random() * estate.length);
            y = (int) (Math.random() * estate.length);
            if(estate[x][y]==null) {
                estate[x][y] = new Garden(x, y);
            }
            else{
                x = (int) (Math.random() * estate.length);
                y = (int) (Math.random() * estate.length);
                estate[x][y] = new Garden(x, y);
            }
        }
        for(int b=0;b<1; b++){
            x = (int) (Math.random() * estate.length);
            y = (int) (Math.random() * estate.length);
            if(estate[x][y]==null) {
                estate[x][y] = new Library(x, y);
            }
            else{
                x = (int) (Math.random() * estate.length);
                y = (int) (Math.random() * estate.length);
                estate[x][y] = new Library(x, y);
            }
        }
    }

    public plainRoom[][] getEstate() {
        return Estate;
    }

    public String printEstate(plainRoom[][] estate, player player1){
        String str ="";
        for(int row=0; row<estate.length;row++){
            for(int col=0; col<estate[row].length;col++) {
                if ((row == player1.getxLoc()) && (col == player1.getyLoc())) {
                    str = "x";
                } else {
                    str = str + estate[row][col].location();
                }
            }
        }
    }
    public void addRoom(plainRoom room,  int row, int col){
        Estate[row][col]= room;
    }
}
