package Rooms;

import People.player;
import com.sun.media.jfxmedia.events.PlayerEvent;

public class plainRoom {
    player occupant;
    int xLoc, yLoc;

    public plainRoom(int x, int y){
        xLoc = x;
        yLoc = y;
    }

    public void enterRoom(player x){

        System.out.println("You're in Linkenshire Estate. The very estate that your friend, Wendy, used to live in."+"\n"+"But alas she is now dead. Rumor " +
                "has it that she has been murdered!"+"\n"+"Your mission is to find her murderer. Explore the various rooms in the Estate to find clues."+"\n"+
                "Good Luck!");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
    public void leaveRoom(player x){
        occupant = null;
    }
}
