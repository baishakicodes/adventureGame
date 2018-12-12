package Rooms;

import People.player;
import Game.Runner;

import java.util.Scanner;

public class WendysRoom extends plainRoom {

    public WendysRoom(int x, int y){
        super(x,y);
    }

    @Override
    public void enterRoom(player x){
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner note = new Scanner(System.in);
        System.out.println("This used to be Wendy's room. It is a very beautiful room with flower wallpapers."+"\n"+"There's a large bed at the center" +
                "of the room. There are a bunch of bookshelves around the room."+"\n"+"The room overall looks to be neat except for the few bloodstains on the floor."+
                "\n"+"Looking around the room one more time you see there is a small table with a vase of flowers next to the bed."+"\n"+"You can see that there is a note on top of it. Would you like to read it?"+"\n"+
                "Type 1 for yes or 2 for no.");
        String readNote= note.nextLine();
        if(readNote.equals("1")){
            System.out.println("The note seems to be written by Wendy herself. Here is what it says:"+"\n"+"\t"+"I don't feel safe in this house anymore."+"\n\t"+
                    "I feel like everyone in this house is trying to hurt me."+"\n\t"+"I especially don't feel safe around the cook. She looks at me with hatred in her eyes."+"\n\t"+
                    "Although I do not know what I did to make her feel that way."+"\n\t"+"These days her food tastes bland. I'm worried if she'll poison me..."+"\n\t"+"I hope the librarian doesn't" +
                    " feel that way about me. She's one of the few friends I have left."+"\n\t"+"This amount of stress is doing me no good. I have to start packing soon.");
        }
        if(readNote.equals("2")){
            System.out.println("You should really read the note."+"\n"+
                    "You might learn something new! But you can always come back to this room and find the note.");
        }

    }
    public void leaveRoom(player x){
        occupant =  null;
    }
    public String location(){
        return " Wendy's Room";
    }
}
