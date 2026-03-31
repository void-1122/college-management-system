btnQuiz.addActionListener(e -> {
    JFrame frame = new JFrame("Quiz");
    frame.setSize(400,300);
    frame.add(new QuizPanel());
    frame.setVisible(true);
});

btnResource.addActionListener(e -> {
    JFrame frame = new JFrame("Resources");
    frame.setSize(500,400);
    frame.add(new ResourcePanel());
    frame.setVisible(true);
});
