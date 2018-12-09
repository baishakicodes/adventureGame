package People;

import Rooms.Kitchen;

import java.util.Scanner;

public class Cook implements Person {
    private String firstname;
    public Cook(String firstname){
        this.firstname = firstname;
    }

    public String getFirstName(){
        return firstname;
    }

    private String[] randomPhrases = {"I love cooking!","What's your favorite food?","I love macrons!",
    "This house feels so much lighter without Wendy. She was so mean!"};

    public void chatLoop(String statement){
        System.out.println(getGreeting());
        Scanner in = new Scanner(System.in);

        while(!(statement.equals("Bye"))){
            if(statement.equals("Bye")){
                break;
            }
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }
    }

    public String getGreeting(){
        return "Hello, how may I help you? If you decide to stop talking anytime at least type the word Bye.";
    }

    public String getResponse(String statement){
        String response = "";
        if(statement.length()==0){
            response = "You've said nothing to me.";
        }
        else if(findKeyword(statement, "Wendy")>=0){
            response = "Uggh. Wendy was so mean and bossy to me. She would never pay me"+"\n"+
            "and I always had to work overtime! But I did not murder her.";
        }
        else if(findKeyword(statement, "seen" )>=0){
            response = "I have not seen her";
        }
        else if(findKeyword(statement, "murder")>=0){
            response = "I definitely did not murder her!";
        }
        else if(findKeyword(statement, "kill Wendy")>=0){
            response = "I definitely did not kill her!";
        }
        else if(findKeyword(statement, "murdered")>=0){
            response = "I definitely did not murder her!";
        }
        else if(findKeyword(statement, "killed")>=0){
            response = "I definitely did not murder her!";
        }
        else if(findKeyword(statement, "Bye")>=0){
            response = "Bye. Nice talking to you.";
        }
        else{
            int rand = (int)(Math.random()*3);
            response = randomPhrases[rand];
        }
        return response;
    }

    private int findKeyword(String statement, String goal,
                            int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }
    private int findKeyword(String statement, String goal)
    {

        return findKeyword (statement, goal, 0);
    }

}
