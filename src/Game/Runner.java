package Game;

import Board.Estate;
import People.Person;
import People.player;
import Rooms.plainRoom;
import Rooms.Kitchen;
import People.Cook;

import java.util.Scanner;


public class Runner {

    public static boolean gameOn = true;
    public static void main(String[] args) {
	// write your code here
        plainRoom[][] building = new plainRoom[5][5];


        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new plainRoom(x,y);
            }
        }


        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new Kitchen(x, y);
        //building[x][y] = new WinningRoom(x, y);


        //Setup player 1 and the input scanner
        player player1 = new player("FirstName", 0, 0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {

            System.out.println("Where would you like to move? (Choose N, S, E, W). Or you could type in the name of the murderer now.");
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {

                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

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
                else
                {
                    return false;
                }
            case "cook":
                System.out.println("You've found the murderer! She'll be put to jail!");
                gameOn = false;
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
