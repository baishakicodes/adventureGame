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
        int ranGreet = (int)(Math.random());
        System.out.println(getGreeting(ranGreet));
        Scanner in = new Scanner(System.in);

        while(!(statement.equals("Bye"))){
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }
    }

    public String getGreeting(){
        return "Hello, I'm the Cook. How may I help you? If you decide to stop talking anytime at least type the word Bye.";
    }

    //overloaded method
    public String getGreeting(int greetingNum){
        if(greetingNum<=50) {
            return "Hello, I'm the Cook. How may I help you? If you decide to stop talking anytime at least type the word Bye.";
        }
        else{
            return "Hey there. I'm the cook. What would you like to eat? If you decide to leave type the word bye!";
        }
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
        else if(findKeyword(statement, "who" )>=0){
            response = "I don't know who killed her.";
        }
        else if(findKeyword(statement, "see" )>=0){
            response = "I don't remember when I last saw her...";
        }
        else if(findKeyword(statement, "murder")>=0){
            response = "I definitely did not murder her!";
        }
        else if(findKeyword(statement, "Who killed")>=0){
            response = transformWhoKilledStatement(statement);
        }
        else if(findKeyword(statement, "murdered")>=0){
            response = "I definitely did not murder her!";
        }
        else if(findKeyword(statement, "kill")>=0){
            response = "I definitely did not kill her!";
        }
        else if(findKeyword(statement, "Bye")>=0){
            response = "Bye. Nice talking to you. You'll be transported to very first room you started in.";
        }
        else if(findKeyword(statement, "Librarian")>=0){
            response = "That old woman. I don't know why she's still here even though Wendy's gone. She and Wendy are both"+"\n"+
            " the same. Both are insufferable! Shh, don't tell anyone but I think the librarian might have murdered Wendy!";
        }
        else if(findKeyword(statement, "Did you")>=0){
            response =  transformdidYouStatement(statement);
        }
        else{
            int rand = (int)(Math.random());
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
    private String transformWhoKilledStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Who killed", 0);
        String restOfStatement = statement.substring(psn + 10).trim();
        return "I did not kill " + restOfStatement + "!";
    }
    private String transformdidYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Did you", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "I most certainly did not " + restOfStatement + "!";
    }

}
