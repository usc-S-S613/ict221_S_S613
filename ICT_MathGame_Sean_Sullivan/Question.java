/*
    This class is the parent class of the MathQuestion and
    JokeQuestion classes.
    The functions are inherited for use
    by the Math question and joke question classes
    @author Sean Sullivan
 */

import java.io.PrintStream;

public class Question {

    protected int _answer;
    protected String _question;
    protected PrintStream _printStream;
    // Holds the question, answer, and printstream for Junit tests
    public Question(int answer, String question, PrintStream printStream) {
        _answer = answer;
        _question = question;
        _printStream = printStream;
    }

    protected void internalShowQuestion()
    {
        if(_question != null)
        {
            _printStream.printf(_question + "\n");
        }
    }
    // Checks whether student response is correct or not
    protected boolean internalCheckAnswer(int response)
    {
        if(response == _answer)
        {
            _printStream.println(response + " is correct!");
            return true;
        }
        else
        {
            _printStream.println(response + " is wrong :(");
            return false;
        }
    }

    //Prints the question to the console
    public final void showQuestion()
    {
        internalShowQuestion();
    }

    //Checks whether the response is correct or not
    public final boolean checkAnswer(int response)
    {
        return internalCheckAnswer(response);
    }
}
