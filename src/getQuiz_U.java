import java.util.Random;

class getQuiz_U implements Quiz {
    private static final String[] QUIZZES = {
            """
次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。

class Q18 {
    public static void main(String[] args) {
        double baseValue = 3.5;
        int units = 3;
        
        double width = baseValue * units;
        System.out.println(width);
    }
}

解答群

"""
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("ウ") || quiz.equals("ゥ") || quiz.equals("う") || quiz.equals("u") || quiz.equals("U");
    }
}
