// This program implements an Online Quiz System in Java that allows administrators to add questions, users to take quizzes,and everyone 
// to view results. It uses object-oriented principles to manage questions, track user scores, and provide an interactive interface
// The system is structured into three main classes: Question, Quiz, and the main class QuizApplication.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Question        // Represents a quiz question with multiple-choice options.
{
    String questionText;
    String[] options;
    int correctOption;            //An integer indicating the correct option (1-based index).

    public Question(String questionText, String[] options, int correctOption) 
    {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public String toString() 
    {
        StringBuilder display = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.length; i++) 
        {
            display.append((i + 1)).append(". ").append(options[i]).append("\n");   // options are 1 based indexing
        }
        return display.toString();
    }
}

class Quiz      // Handles the core quiz functionality, including adding questions, conducting quizzes, and viewing results.
{
    ArrayList<Question> questions = new ArrayList<>();           // A list of Question objects representing the quiz questions. 
    HashMap<String, Integer> userScores = new HashMap<>();       // A map that associates user names with their scores.

    // Prompts the admin to enter the question text.Asks for the number of options and reads each option.
    // Specifies the correct option by its number.Adds the question to the questions list.

    public void addQuestion() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the question: ");
        String questionText = scanner.nextLine();
        System.out.print("Enter the number of options: ");
        int numOptions = scanner.nextInt();
        scanner.nextLine(); 

        String[] options = new String[numOptions];
        for (int i = 0; i < numOptions; i++) 
        {
            System.out.print("Enter option " + (i + 1) + ": ");
            options[i] = scanner.nextLine();
        }

        System.out.print("Enter the correct option number: ");
        int correctOption = scanner.nextInt();
        scanner.nextLine(); 
        Question question = new Question(questionText, options, correctOption);
        questions.add(question);
        System.out.println("Question added successfully.");
    }

    // Checks if there are questions available. If not, displays an appropriate message.Displays each question using its toString() method.
    // Collects the user's answer and checks if it matches the correct option.Tracks the score and stores it in the userScores map for the user.

    public void takeQuiz(String userName) 
    {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        if (questions.isEmpty()) 
        {
            System.out.println("No questions available in the quiz.");
            return;
        }

        System.out.println("Starting quiz for " + userName + "...\n");

        for (Question question : questions) 
        {
            System.out.println(question);
            System.out.print("Enter your answer (1-" + question.options.length + "): ");
            int answer = scanner.nextInt();

            if (answer == question.correctOption) 
            {
                System.out.println("Correct!\n");
                score++;
            } 
            else 
            {
                System.out.println("Wrong! Correct answer: Option " + question.correctOption + "\n");
            }
        }

        userScores.put(userName, score);
        System.out.println(userName + ", your quiz is complete! Your score: " + score + "/" + questions.size());
    }

    // Checks if there are any scores available. If not, shows a message.Iterates through the userScores map and displays each user's score.
    public void viewResults() 
    {
        if (userScores.isEmpty()) 
        {
            System.out.println("No results available.");
        } 
        else 
        {
            System.out.println("Quiz Results:");
            for (var entry : userScores.entrySet()) 
            {
                System.out.println("User: " + entry.getKey() + ", Score: " + entry.getValue());
            }
        }
    }
}

public class QuizApplication 
{
    public static void main(String[] args) 
    {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\nOnline Quiz System");
            System.out.println("1. Add Question");
            System.out.println("2. Take Quiz");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1 -> quiz.addQuestion();
                case 2 -> 
                {
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    quiz.takeQuiz(userName);
                }
                case 3 -> quiz.viewResults();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 4);
    }
}
