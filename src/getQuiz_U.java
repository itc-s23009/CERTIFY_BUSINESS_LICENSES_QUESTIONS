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
""",
            """
(20)次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。ここで、\nプログラム中の文字コード[0x30]は文字の[0]を示す。
class Q20 {
    public static void main(String[] args) {
        char c = 0x30;
        c += 9;
        System.out.println(c);
    }
}

解答群
　ア ３行目でコンパイルエラーが起こる。
　イ ４行目でコンパイルエラーが起こる。
　ウ コンパイル及び実効され、[9]が表示される。
　エ コンパイル及び実効され、[39]が表示される。
""",
            """
(25)次のプログラム中の、[ a ] に当てはまるものとして、正しいものはどれか。
class Q25 {
    String code;
    public static void main(String[] args) {
        Q25 obj = new Q25();
        obj.[ a ];
    }
    void setCode(String s) {
        code = s;
    }
}

解答群
　ア setCode
　イ setCode()
　ウ setCode("FB1257")
　エ setCode('FB1257')
"""
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        if(quiz.equals("ウ") || quiz.equals("ゥ") || quiz.equals("う") || quiz.equals("u") || quiz.equals("U")){
            return true;
        }else {
            System.out.println("不正解\n 正解は ウ");
            return false;
        }
    }


}
