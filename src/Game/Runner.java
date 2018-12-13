package Game;

import Board.Estate;
import People.Person;
import People.player;
import Rooms.WendysRoom;
import Rooms.plainRoom;
import Rooms.Kitchen;
import People.Cook;
import Rooms.startingRoom;

import java.util.Scanner;


public class Runner {

    public static boolean gameOn = true;
    public static void main(String[] args) {
	// write your code here
        //plainRoom[][] building = new plainRoom[5][5];
        Estate estate = new Estate(5);
        estate.fillEstate();
        estate.getEstate()[0][0]=new startingRoom(0,0);
        estate.edit(estate.getEstate());
        player player1 = new player("FirstName", 0, 0);
        estate.getEstate()[0][0].enterRoom(player1);

        //fill the building with normal rooms
        //for (int x = 0; x<building.length; x++)
        //{
            //for (int y = 0; y < mansion[x].length; y++)
            //{
                //building[x][y] = new plainRoom(x,y);
           // }
        //}


        //Create a random winning room.
       // int x = (int)(Math.random()*estate.getEstate().length);
        ///int y = (int)(Math.random()*estate.length);
        //building[x][y] = new Kitchen(x, y);
        //int a = (int)(Math.random()*building.length-1);
        //int b = (int)(Math.random()*building.length-1);
        //building[x][y] = new WendysRoom(x, y);
       // building[0][0] = new startingRoom(0, 0);
        //building [x][y] = new WinningRoom(x, y);


        //Setup player 1 and the input scanner
        //building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {

            System.out.println("Where would you like to move? (Choose N, S, E, W). Or you could type in the name of the murderer now.");
            String move = in.nextLine();
            if(move.toLowerCase().equals("librarian")){
                System.out.println("Hmmm... you think so? But she's really nice! Continue the game and see if you can find some clues to help you.");
            }
            if(move.toLowerCase().equals("gardener")){
                System.out.println("I don't know about that. He doesn't seem the type to kill people. Continue the game to find clues.");
            }
            if(move.toLowerCase().equals("cook")){
                System.out.println("Great, you found the murderer! Good job. She'll be put to jail immediately."+"\n"+
                        "You are a true hero. You friend Wendy would have been proud!");
                gameOn = false;
                break;
            }
            if(validMove(move, player1, estate.getEstate()))
            {

                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Map:"+"\n"+"\n"+estate.printEstate(estate.getEstate(), player1));
                System.out.println("---------------------------------------------------------------------------------");


            }
            else {

                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, player p, plainRoom[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }

}
