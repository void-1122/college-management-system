import java.util.ArrayList;

public class DataStore {

    static ArrayList<String[]> resources = new ArrayList<>();

    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String[]> options = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    static {
        // Load quiz
        questions.add("What is Java?");
        options.add(new String[]{"Language", "Database", "OS", "Browser"});
        answers.add(0);

        questions.add("Which is used for database?");
        options.add(new String[]{"HTML", "MySQL", "CSS", "JavaScript"});
        answers.add(1);

        // Dummy resources
        resources.add(new String[]{"Java Notes", "OOP"});
        resources.add(new String[]{"DBMS Notes", "Database"});
    }
}
