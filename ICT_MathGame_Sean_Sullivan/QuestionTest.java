/*
    This class tests all the components of the Math game with Junit tests
    It will test the Math question class,
    It will test the Joke question class,
    It will test the highscore class for adding a highscore,
    updating a highscore with a higherscore, and ensuring the highscore
    isnt updated with a value that is lower than the current highscore
    @author Sean Sullivan
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class QuestionTest {
    // Test for Math Question correct answer
    @Test
    public void MathQuestionCorrect()
    {
        var answerInput = 8;
        var questionInput = "4 + 4";

        var responseAnswer = 8;
        var expectedText = "What is 4 + 4?\n8 is correct!\n\r\n";

        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        // Check math question logic
        var mathQuestionAdd = new MathQuestion(answerInput, questionInput, testOutputStream);
        mathQuestionAdd.showQuestion();
        assertTrue(mathQuestionAdd.checkAnswer(responseAnswer));

        // Check math question console outputs
        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }
    // Test for math question incorrect answer
    @Test
    public void MathQuestionWrong()
    {
        var answerInput = 8;
        var questionInput = "4 + 4";

        var responseAnswer = 9;
        var expectedText = "What is 4 + 4?\n9 is wrong. 4 + 4 equals 8\n\r\n";

        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        // Check math question logic
        var mathQuestionAdd = new MathQuestion(answerInput, questionInput, testOutputStream);
        mathQuestionAdd.showQuestion();
        assertFalse(mathQuestionAdd.checkAnswer(responseAnswer));

        // Check math question console outputs
        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }
    // Test for Joke Question correct answer
    @Test
    public void JokeQuestionCorrect()
    {
        var answerInput = 3;
        var punchlineInput = "one to hold the joke and two to turn the question";
        var questionInput = "How many Junit tests does it take to test a joke question?";

        var responseAnswer = 3;
        var expectedText = "How many Junit tests does it take to test a joke question?\n" +
                "That is right, one to hold the joke and two to turn the question\n" +
                "\r\n";

        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        // Check joke question logic
        var mathQuestionAdd = new JokeQuestion(answerInput, questionInput, testOutputStream, punchlineInput);
        mathQuestionAdd.showQuestion();
        assertTrue(mathQuestionAdd.checkAnswer(responseAnswer));

        // Check joke question console outputs
        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }
    // Test for Joke Question wrong answer
    @Test
    public void JokeQuestionWrong()
    {
        var answerInput = 3;
        var punchlineInput = "one to hold the joke and two to turn the question";
        var questionInput = "How many Junit tests does it take to test a joke question?";

        var responseAnswer = 4;
        var expectedText = "How many Junit tests does it take to test a joke question?\n" +
                "No!\n" +
                "\r\n" +
                "3, one to hold the joke and two to turn the question\n" +
                "\r\n";

        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        // Check joke question logic
        var mathQuestionAdd = new JokeQuestion(answerInput, questionInput, testOutputStream, punchlineInput);
        mathQuestionAdd.showQuestion();
        assertFalse(mathQuestionAdd.checkAnswer(responseAnswer));

        // Check joke question console outputs
        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }

    // Test for Highscore update with higherscore
    @Test
    public void HighScoreIncreaseUpdate()
    {
        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        var expectedText = "The high score is 5\r\n" +
                "The high score is 6\r\n";

        // Testing HighScores class
        var highScoresTest = new HighScores(testOutputStream);
        highScoresTest.UpdateHighScore(5);
        highScoresTest.printHighScore();

        // Testing the Highscore class updates the highscore
        highScoresTest.UpdateHighScore(6);
        highScoresTest.printHighScore();

        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }

    // Test for high score no change when a lower score
    @Test
    public void HighScoreNoIncreaseUpdate()
    {
        var testOutputByteArray = new ByteArrayOutputStream();
        var testOutputStream = new PrintStream(testOutputByteArray );

        var expectedText = "The high score is 5\r\n" +
                "The high score is 5\r\n";

        // Testing HighScores class
        var highScoresTest = new HighScores(testOutputStream);
        highScoresTest.UpdateHighScore(5);
        highScoresTest.printHighScore();

        // Testing the Highscore class does not update the new lower score
        highScoresTest.UpdateHighScore(4);
        highScoresTest.printHighScore();

        var content = testOutputByteArray.toString();
        assertEquals(content,expectedText);
    }

}




