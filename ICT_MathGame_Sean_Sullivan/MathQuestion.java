/*
    This class is a child class of the parent Question class
    This class generates our Math Question and checks
    whether the response is correct or incorrect
    @author Sean Sullivan
 */

import java.io.PrintStream;

public class MathQuestion extends Question {
    // Generate our math question
    public MathQuestion(int answer, String questionText, PrintStream printStream) {
        super(answer, questionText,printStream);
    }

    protected void internalShowQuestion()
    {
        if(_question != null)
        {
            _printStream.printf("What is " + _question + "?\n");
        }
    }
    // Check whether students response is correct or not
    protected boolean internalCheckAnswer(int response)
    {
        if(response == _answer)
        {
            _printStream.println(response + " is correct!\n");
            return true;
        }
        else
        {
            _printStream.println(response + " is wrong. " + _question + " equals " + _answer + "\n");
            return false;
        }
    }
}