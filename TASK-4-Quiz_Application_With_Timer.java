import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class Main {
    private List<QuizQuestion> questions;
    private int totalQuestions;
    private int score;

    public Main(List<QuizQuestion> questions) {
        this.questions = questions;
        this.totalQuestions = questions.size();
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");

        for (int i = 0; i < totalQuestions; i++) {
            QuizQuestion currentQuestion = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char) ('A' + j) + ") " + options.get(j));
            }

            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            if (userAnswer == (char) ('A' + currentQuestion.getCorrectOption())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! Correct answer: " + (char) ('A' + currentQuestion.getCorrectOption()));
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your Score: " + score + "/" + totalQuestions);

        scanner.close();
    }

    public static void main(String[] args) {
        // Create quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?",
                Arrays.asList("A. London", "B. Paris", "C. Rome", "D. Berlin"), 1));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("A. Jupiter", "B. Venus", "C. Mars", "D. Saturn"), 2));
        questions.add(new QuizQuestion("Who wrote 'To Kill a Mockingbird'?",
                Arrays.asList("A. Harper Lee", "B. J.K. Rowling", "C. Stephen King", "D. Charles Dickens"), 0));

        // Create a quiz object
        Main quiz = new Main(questions);

        // Start the quiz
        quiz.startQuiz();
    }
}
