interface Quiz {
    String getRandomQuiz();

    boolean answer(String input);

    String Explanation(int quizNumber);

    int extractLeadingNumber(String Quiz);
}
