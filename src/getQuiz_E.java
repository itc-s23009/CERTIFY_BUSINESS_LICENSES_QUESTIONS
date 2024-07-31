import java.util.Random;

class getQuiz_E implements Quiz {
    private static final String[] QUIZZES = {
            """
(17)次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。

class Q17 {
    public static void main (String[] args) {
    int n = 35;
    System.out.println(n);
    }
}

解答郡
　ア [0] と表示される。
　イ [1] と表示される。
　ウ [true] と表示される。
　エ [false] と表示される。
"""
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("エ") || quiz.equals("ェ") || quiz.equals("え") || quiz.equals("e") || quiz.equals("E");
    }
}
