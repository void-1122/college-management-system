import java.util.ArrayList;

public class DataStore {

    static ArrayList<String[]> resources = new ArrayList<>();

    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String[]> options = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    static {
        questions.add("What is Java?");
        options.add(new String[]{"Language", "Database", "OS", "Browser"});
        answers.add(0);

        resources.add(new String[]{"Java Notes", "OOP"});
        resources.add(new String[]{"DBMS Notes", "Database"});
    }
}
