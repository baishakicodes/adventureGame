package Rooms;
import People.Cook;
import People.player;

import java.util.Scanner;

public class Kitchen extends plainRoom {
    Cook cook = new Cook("cook");
    int xLoc, yLoc;
    public Kitchen(int x, int y){
        super(x, y);
    }



    @Override
    public void enterRoom(player x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner in = new Scanner(System.in);
        System.out.println("You've entered the kitchen. You see the cook"+"\n"+
                "cooking something. It looks like meat. Do you want to talk to her?"+"\n"+
                "Type 1 for yes or 2 for no");
        String ans = in.nextLine();
        if(ans.equals("1")){
            cook.chatLoop(ans);
        }
        if(ans.equals("2")){
            System.out.println("You should really talk to the cook."+"\n"+
                    "You might learn something new! For now you'll be transported to the very first room you started with."+"\n"+"You can always find the kitchen in the same location as last time.");
        }
    }
}
