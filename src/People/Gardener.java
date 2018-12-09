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

    private String[] randomPhrases = {"Ahhh, the aroma of these flowers are so satisfying.","Do you like plants?","I love flowers and plants.",
            "I wish Wendy was here to see these flowers bloom. She loved the garden so much.","What's your favorite flower?"};

    public void chatLoop(String statement){
        System.out.println(getGreeting());
        Scanner in = new Scanner(System.in);

        while(!(statement.equals("Bye"))){
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }
    }

    public String getGreeting(){
        return "Hello, I'm the gardenre. How can I help you? If you decide to stop talking anytime type the word Bye.";
    }

    public String getResponse(String statement){
        String response = "";
        if(statement.length()==0){
            response = "You've said nothing to me.";
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
        else if(findKeyword(statement, "kill Wendy")>=0){
            response = "I would not kill Wendy! Because of her I could do what I love:gardening.";
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

}
