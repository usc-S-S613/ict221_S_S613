
import java.util.*;
/*
    This class generates our random questions,
    holds our count for number of correct answers,
    checks whether the students response is correct,
    generates our incorrect answered questions array,
    adds any wrong answered questions to the array,
    reasks the incorrect answered questions from the array
    once the loop of questions is finished, prints the result
    and displays the number of questions answered correctly
    @author Sean Sullivan
*/


public class GenerateQuestion
{
    //How many question do we want to ask
    int _numberOfQuestions;
    // Generate a number # of questions
    public GenerateQuestion(int numberOfQuestion)
    {
        _numberOfQuestions = numberOfQuestion;
    }

    public int process()
    {
        //Generate our random seed
        Random rand = new Random();

        //Counter to hold number of correct answers
        var correctCount = 0;

        //Instantiate our scanner
        Scanner in = new Scanner(System.in);

        //Instantiate our container to hold wrong answered questions
        List<Question> listOfQuestions = new ArrayList<>();
        List<Question> wrongQuestions = new ArrayList<>();

        //Generate our math questions
        for(int i = 0; i < _numberOfQuestions; i++) {

            //Create our Math question
            MathQuestion q = null;
            try {
                listOfQuestions.add(generateMathQuestion(rand));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Create our joke question
        listOfQuestions.add(new JokeQuestion(3, "How many Polacks does it take to change a light bulb?", System.out, "one to hold the light bulb and two to turn the ladder."));

        for(Question question : listOfQuestions)
        {
            //Display the question
            question.showQuestion();

            //Wait for response
            int response = in.nextInt();

            //Check answer and increment if correct
            if(question.checkAnswer(response))
            {
                correctCount++;
            } else {
                //When an answer is wrong it pushes the question into the wrongQuestions array
                wrongQuestions.add(question);
            }
        }

        printResults(correctCount);

        System.out.println("Please try to answer these following " + wrongQuestions.size() + " questions again.");

        //Repeat but this time for all wrong answered questions
        for (Question question : wrongQuestions)
        {
            question.showQuestion();

            //Wait for response
            int response = in.nextInt();
            // Check the answer
            question.checkAnswer(response);
        }

        return correctCount;
    }
    // Generates the string for the question
    String GenerateQuestionText(String operator, int value1, int value2, int value3)
    {
        if (operator == "+" || operator == "-" || operator == "*") {
            return String.format("%d " + operator + " %d", value1, value2);
        } else if (operator == "/") {
            return String.format("%d " + operator + " %d", value3, value2);
        }
        else {
            return null;
        }
    }

    //Checks whether the response is correct or not
    int GenerateAnswer(String operator, int value1, int value2, int value3) throws Exception {
        switch (operator)
        {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value3 / value2;
            default:
                throw new Exception("Unknown operator");
        }
    }

    //Generates our random math question
    private MathQuestion generateMathQuestion(Random seed) throws Exception {
        String convertOp = "";

        var x = seed.nextInt(12) + 1;
        var y = seed.nextInt(12) + 1;
        //Random variable of 1-4 to determine +, -, *, or /
        var z = seed.nextInt(4) + 1;

        //Assigns the operator that will be used for the question randomly
        if(z == 1) {
            convertOp = "+";
        } else if (z == 2) {
            convertOp = "-";
        } else if (z == 3) {
            convertOp = "*";
        } else if (z == 4) {
            convertOp = "/";
        }
        // val3 is used for the purposes of division questions to be appropriate
        var val3 = x * y;

        //Create our question variables
        var questionText = GenerateQuestionText(convertOp, x, y, val3);
        var answer = GenerateAnswer(convertOp, x, y, val3);

        //Create our question
        return new MathQuestion(answer, questionText, System.out);
    }

    private void printResults(int correctCount)
    {
        //Display final score with slightly different message if perfect score
        if(correctCount == _numberOfQuestions) {
            System.out.println("Well done on your PERFECT score of: " + correctCount + " out of " + _numberOfQuestions);
        }
        else
        {
            System.out.println("Well done on your score of: " + correctCount + " out of " + _numberOfQuestions);
        }
    }
}
