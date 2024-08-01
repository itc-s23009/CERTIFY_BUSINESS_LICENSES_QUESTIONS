import java.util.Random;

class getQuiz_A implements Quiz {
    private static final String[] QUIZZES = {
            """
(2)Javaのプログラミングを実行するには、JVM(Java Virtual Machine)が必要である。

ア:正しい        イ:誤り
""",
            """
(4)Javaアプレットとは、Webブラウザ上で実行されるJavaのプログラミングのことである。

ア:正しい        イ:誤り
""",
            """
(5)Javaでは、プログラム内部で文字を表すのにUnicode標準を使用している。

ア:正しい        イ:誤り
"""
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("ア") || quiz.equals("ァ") || quiz.equals("あ") || quiz.equals("a") || quiz.equals("A");
    }
}
