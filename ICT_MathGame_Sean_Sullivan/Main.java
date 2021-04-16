/*
    This class is the main class that handles the running of the game
    @author Sean Sullivan
*/


public class Main {

    private static HighScores _highScores;

    public static void main(String[] args)
    {
        //Create our highscores object
        _highScores = new HighScores(System.out);

        //Create our test object
        GenerateQuestion ourFirstGenerateQuestion = new GenerateQuestion(9);

        //Create a loop to perform a #number of tests
        for(int i = 0; i < 3; i++)
        {
            //Perform test
            var result = ourFirstGenerateQuestion.process();

            //Update high scores with score
            _highScores.UpdateHighScore(result);

            //Print highest score
            _highScores.printHighScore();
        }
    }
}
