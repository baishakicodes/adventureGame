package People;

import java.util.Scanner;
import Rooms.Library;

public class Librarian implements Person {
    private String firstname;
    public Librarian(String firstname){
        this.firstname = firstname;
    }

    public String getFirstName(){
        return firstname;
    }

    private String[] randomPhrases = {"I love reading books so much!!","What's your favorite book?","I love this estate and this library!",
            "You know, Wendy is a big book nerd too. She is so much like me!"};

    public void chatLoop(String statement){
        System.out.println(getGreeting());
        Scanner in = new Scanner(System.in);

        while(!(statement.toLowerCase().equals("bye"))){
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }
    }

    public String getGreeting(){
        return "Hello, I'm the Librarian. How can I help you dear? If you decide to stop talking anytime at least type the word Bye.";
    }

    public String getResponse(String statement){
        String response = "";
        if(statement.length()==0){
            response = "You've said nothing to me.";
        }
        else if(findKeyword(statement, "Wendy")>=0){
            response = "I miss Wendy. Without her here the house is lonely. Reading without her here doesn't feel the same. *sigh*";
        }
        else if(findKeyword(statement, "seen" )>=0){
            response = "The last time I saw Wendy was when she was going to her room after dinner."+"\n"+"She was telling me she was feeling" +
                    " light headed.";
        }
        else if(findKeyword(statement, "who" )>=0){
            response = "I think the cook might have killed her";
        }
        else if(findKeyword(statement, "murder")>=0){
            response = "Oh dear, Why would I murder Wendy?!";
        }
        else if(findKeyword(statement, "murdered")>=0){
            response = "I did not murder her!";
        }
        else if(findKeyword(statement, "kill")>=0){
            response = "I did not kill her!";
        }
        else if(findKeyword(statement, "cook")>=0){
            response = "I've always had bad feelings about the cook."+"\n"+"Wendy gave" +
                    " her a job out of pity because the cook was desperate to earn some money."+"\n"+"I return, I'd say, the cook backstabbed her!";
        }
        else if(findKeyword(statement, "killed")>=0){
            response = "I did not kill her!";
        }
        else if(findKeyword(statement, "Gardener")>=0){
            response = "He's a nice lad. He does a good job keeping the gardens tidy and beautiful. He wouldn't hur a fly.";
        }
        else if(findKeyword(statement, "Bye")>=0){
            response = "Bye. It was really nice talking to you dearie. Come by once in a while!";
        }
        else if(findKeyword(statement, "Did you")>=0){
            response =  transformdidYouStatement(statement);
        }
        else if(findKeyword(statement, "Who killed")>=0){
            response = transformWhoKilledStatement(statement);
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
