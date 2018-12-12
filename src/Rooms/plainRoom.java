package Rooms;

import People.player;

public class plainRoom {
    player occupant;
    int xLoc, yLoc;

    public plainRoom(int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    public void enterRoom(player x){

        System.out.println("You're in a plain old room in the estate. There's nothing interesting to see here.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
    public void leaveRoom(player x){
        occupant = null;
    }

    public  int getxLoc() {
        return this.xLoc;
    }
    public int getyLoc(){
        return this.yLoc;
    }

    public String location(){
        return "[ Plain Room ]";
    }
}
