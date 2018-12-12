package Rooms;

import Rooms.plainRoom;
import Game.Runner;
import People.player;
import People.Librarian;
import java.util.Scanner;

public class Library extends plainRoom {

    Librarian librarian = new Librarian("Librarian");
    public Library(int x, int y){
        super(x,y);
    }

    public void enterRoom(player x){
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner libr = new Scanner(System.in);
        System.out.println("This is the library. The library is humongous with thousands upon thousands of books."+"\n"+"You could" +
                " spend months here and still not finish a fraction of the books."+"\n"+"You walk around the library for a while when you suddenly" +
                " spot the librarian looking at the cover of a book."+"\n"+"The librarian seems to be a petite woman in her 60s."+" Would you like to talk to her?"
        +"\n"+"Type 1 for yes or 2 for no.");
        String talk = libr.nextLine();
        if(talk.equals("1")){
            librarian.chatLoop(talk);
        }
        if(talk.equals("2")){
            System.out.println("You should really talk to the Librarian."+"\n"+
                    "You might learn something new! For now you'll be transported to the very first room you started with."+"\n"+"You can always find the kitchen in the same location as last time.");
        }
    }
    public void leaveRoom(player x){
        occupant =  null;
    }
    public String location(){
        return "Library";
    }
}
