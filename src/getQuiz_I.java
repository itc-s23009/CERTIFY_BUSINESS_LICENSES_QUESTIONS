import java.util.Random;

class getQuiz_I implements Quiz {
    private static final String[] QUIZZES = {
            """
Javaはスクリプト言語なので、ソースファイルにコンパイルしなくても実行できる

ア:正しい        イ:誤り
""",
            """
Javaのソースファイルでは、命令文の区切りにカンマを使用する。

ア:正しい        イ:誤り
""",
            """
Javaでは、参照型の変数しか扱うことができない

ア:正しい        イ:誤り
"""
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("イ") || quiz.equals("ィ") || quiz.equals("い") || quiz.equals("i") || quiz.equals("I");
    }
}
