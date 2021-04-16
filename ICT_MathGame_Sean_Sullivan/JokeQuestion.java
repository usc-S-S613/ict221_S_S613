/*
    This class is a child class of the Question Parent class.
    This class generates our Joke Question and checks whether
    the response to the joke question is correct or incorrect
    @author Sean Sullivan
 */

import java.io.PrintStream;

public class JokeQuestion extends Question {

    private String _punchline;
    // Forms the joke question
    public JokeQuestion(int answer, String questionText, PrintStream printStream, String punchline) {
        super(answer, questionText, printStream);

        _punchline = punchline;
    }

    protected void internalShowQuestion()
    {
        if(_question != null)
        {
            _printStream.printf(_question + "\n");
        }
    }
    // Checks whether the response to the joke question is correct or not
    protected boolean internalCheckAnswer(int response)
    {
        if(response == _answer)
        {
            _printStream.println("That is right, " + _punchline + "\n");
            return true;
        }
        else
        {
            _printStream.println("No!" + "\n");
            _printStream.println(_answer + ", " +_punchline + "\n");
            return false;
        }
    }
}