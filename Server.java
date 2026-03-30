import java.util.ArrayList;

public class Server {

    // -------- RESOURCE LIST --------
    static ArrayList<String[]> resourceList = new ArrayList<>();

    // -------- QUIZ DATA --------
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String[]> options = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    // -------- ADD RESOURCE --------
    public static void addResource(String title, String subject) {
        String data[] = {title, subject};
        resourceList.add(data);
    }

    // -------- GET RESOURCES --------
    public static ArrayList<String[]> getResources() {
        return resourceList;
    }

    // -------- LOAD QUIZ --------
    public static void loadQuiz() {

        // Question 1
        questions.add("What is Java?");
        options.add(new String[]{"Language", "Database", "OS", "Browser"});
        answers.add(0); // correct = index 0

        // Question 2
        questions.add("Which is used for database?");
        options.add(new String[]{"HTML", "MySQL", "CSS", "JavaScript"});
        answers.add(1);
    }

    // -------- GET QUESTION --------
    public static String getQuestion(int i) {
        return questions.get(i);
    }

    // -------- GET OPTIONS --------
    public static String[] getOptions(int i) {
        return options.get(i);
    }

    // -------- CHECK ANSWER --------
    public static boolean checkAnswer(int qIndex, int userAns) {
        return answers.get(qIndex) == userAns;
    }

}
