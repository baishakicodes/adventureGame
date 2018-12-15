package People;

import java.util.Scanner;

public class Gardener implements Person {
    private String firstname;
    public Gardener(String firstname){
        this.firstname = firstname;
    }

    public String getFirstName(){
        return firstname;
    }

    //list of phrases that would show if the user typed anything that I didn't specificaly look for
    private String[] randomPhrases = {"Ahhh, the aroma of these flowers are so satisfying.","Do you like plants?","I love flowers and plants.",
            "I wish Wendy was here to see these flowers bloom. She loved the garden so much.","What's your favorite flower?"};

    // This entire code was taken from the chatloop lab. It was needed so that the player was able to
    //to talk to the people and get clues.
    public void chatLoop(String statement){
        System.out.println(getGreeting());
        Scanner in = new Scanner(System.in);

        while(!(statement.toLowerCase().equals("bye"))){
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }
    }

    public String getGreeting(){
        return "Hello, I'm the Gardener. How can I help you? If you decide to stop talking anytime type the word Bye.";
    }

    public String getResponse(String statement){
        String response = "";
        if(statement.length()==0){
            response = "You've said nothing to me.";
        }
        else if(findKeyword(statement, "who" )>=0){
            response = "I think the cook might have killed her";
        }
        else if(findKeyword(statement, "Who killed")>=0){
            response = transformWhoKilledStatement(statement);
        }
        else if(findKeyword(statement, "Wendy")>=0){
            response = "I miss Wendy. Without her here the gardens have lost their color. *sigh*";
        }
        else if(findKeyword(statement, "seen" )>=0){
            response = "The last time I saw Wendy she was very sick. I had asked her to come to the gardens but she couldn't."+"\n"+"So I" +
                    " bought her some flowers and placed them next to her bed.";
        }
        else if(findKeyword(statement, "murder")>=0){
            response = "You don't think I murdered her do you?";
        }
        else if(findKeyword(statement, "murdered")>=0){
            response = "I would not murder the person that gave me my job.";
        }
        else if(findKeyword(statement, "killed")>=0){
            response = "I did not kill her!";
        }
        else if(findKeyword(statement, "Bye")>=0){
            response = "Bye. You can see the gardens anytime.";
        }
        else if(findKeyword(statement, "Did you")>=0){
            response =  transformdidYouStatement(statement);
        }
        else{
            int rand = (int)(Math.random()*4);
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
