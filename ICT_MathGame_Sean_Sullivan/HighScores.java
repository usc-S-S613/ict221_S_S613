/*
    This class creates and holds a highScore variable
    Returns the highScore to the main class
    Checks whether the current score is higher
    than the current Highscore and if it is
    the score becomes the new high score
    @author Sean Sullivan
*/

import java.io.PrintStream;

public class HighScores
{
    private int _highScore;
    protected PrintStream _printStream;

    // Creates the highScore variable
    public HighScores(PrintStream printStream)
    {
        _highScore = 0;
        _printStream = printStream;
    }

    // Updates high score if the result is greater than the current high score
    public void UpdateHighScore(int newHighScore)
    {
        if(newHighScore > _highScore)
        {
            _highScore = newHighScore;
        }
    }
    // Prints the high score to the console
    public void printHighScore()
    {
        _printStream.println("The high score is " + _highScore);
    }
}
