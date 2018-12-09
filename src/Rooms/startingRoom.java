package Rooms;

import Game.Runner;
import People.player;
public class startingRoom extends plainRoom {

    public startingRoom(int x, int y){
        super(x,y);
    }

    @Override
    public void enterRoom(player x){
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You're in Linkenshire Estate. The very estate that your friend, Wendy, used to live in."+"\n"+"But alas she is now dead. Rumor " +
                "has it that she has been murdered!"+"\n"+"Your mission is to find her murderer. Explore the various rooms in the Estate to find clues."+"\n"+
                "Good Luck!");
    }
}
