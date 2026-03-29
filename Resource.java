class Resource {
    String title, subject, semester, fileName;

    Resource(String t, String s, String sem, String f) {
        title = t;
        subject = s;
        semester = sem;
        fileName = f;
    }

    public String toString() {
        return "Title: " + title + " | Subject: " + subject + " | Sem: " + semester + " | File: " + fileName;
    }
}
