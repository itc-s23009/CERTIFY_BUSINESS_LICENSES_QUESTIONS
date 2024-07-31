import java.util.Random;

class getQuiz_U implements Quiz {
    private static final String[] QUIZZES = {
            """
(18)次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。

class Q18 {
    public static void main(String[] args) {
        double baseValue = 3.5;
        int units = 3;
        
        double width = baseValue * units;
        System.out.println(width);
    }
}

解答群
　ア ６行目でコンパイルエラーが起こる。
　イ コンパイル及び実行され、[9] が表示される。
　ウ コンパイル及び実効され、[10.5] が表示される。
　エ コンパイル及び実効され、[12.0] が表示される。
""",
            """
(19)コードとして、正しいものはどれか。

解答群
　ア int array1 = new int[5];
　イ int[] array2 = new int[5];
　ウ int[] array3 = new int[5];
　エ　 int[] array4 = new int[][5];
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
