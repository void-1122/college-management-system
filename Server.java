import java.util.ArrayList;

public class 
    static ArrayList<String[]> resourceList = new ArrayList<>();

    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String[]> options = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void addResource(String title, String subject) {
        String data[] = {title, subject};
        resourceList.add(data);
    }

    public static ArrayList<String[]> getResources() {
        return resourceList;
    }

    public static void loadQuiz() {

        questions.add("What is Java?");
        options.add(new String[]{"Language", "Database", "OS", "Browser"});
        answers.add(0); 

        
        questions.add("Which is used for database?");
        options.add(new String[]{"HTML", "MySQL", "CSS", "JavaScript"});
        answers.add(1);
    }

    public static String getQuestion(int i) {
        return questions.get(i);
    }

    public static String[] getOptions(int i) {
        return options.get(i);
    }
    public static boolean checkAnswer(int qIndex, int userAns) {
        return answers.get(qIndex) == userAns;
    }

}
