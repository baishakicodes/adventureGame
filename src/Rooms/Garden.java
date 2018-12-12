package Rooms;

import People.player;
import People.Gardener;

import java.util.Scanner;

public class Garden extends plainRoom {

    Gardener gardener = new Gardener("gardener");
    public Garden(int x, int y){
        super(x,y);
    }
    public void enterRoom(player x){
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner gard = new Scanner(System.in);
        System.out.println("This is the indoor garden that Wendy built inside the estate. The garden cosists of many different types of flowers."+"\n"+
                "Everywhere you look you see roses, marigolds, daisies and even some exotic flowers you don't recognize."+"\n"+"The smell of the flowers" +
                "create a pleasing aroma."+"\n"+"As you walk around the garden observing the many flowers you notice that someone is there with you."+"\n"+"It's" +
                "the gardener. Maybe talking to him will give you a clue." + "Type 1 to talk to him or type 2 if you don't want to.");
        String chatGard = gard.nextLine();
        if(chatGard.equals("1")){
            gardener.chatLoop(chatGard);
        }
        if(chatGard.equals("2")){
            System.out.println("You should really talk to the Gardener."+"\n"+
                    "You might learn something new!"+"You can always find the kitchen in the same location as last time.");
        }
    }
    public void leaveRoom(player x){
        occupant =  null;
    }
    public String location(){
        return "Garden";
    }
}
