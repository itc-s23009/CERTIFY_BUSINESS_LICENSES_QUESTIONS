import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_A implements Quiz {
    private static final String[] QUIZZES = {
            """
3 Javaのガーベジコレクションとは、参照されなくなって不要になったオブジェクトが利用していた
メモリ領域を自動的に開放し、新しいオブジェクトのための領域を確保する機能である。
                       解答群
           　ア 正しい           イ 誤り
""",
            """
4 Javaのプログラムは、コンパイラによってバイトコードに変換される。
                       解答群
           　ア 正しい           イ 誤り
""",
            """
5 Javaでは開発されたプログラムを再コンパイルしないので
別のプラットフォーム上で実行することができる。
                       解答群
           　ア 正しい           イ 誤り
""",
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("ア") || quiz.equals("ァ") || quiz.equals("あ") || quiz.equals("a") || quiz.equals("A");
    }

    @Override
    public String Explanation(int quizNumber) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(3, """
                不正解
                正解は ア
                
                解説
                ガーベジコレクション(garbage collection)とは、プログラムを動的に確保したオブジェクトの
                メモリ領域のうち、不要になったメモリ領域を開放する機能である。
                """);
        hmap.put(4, """
                不正解
                正解は ア
                
                解説
                Javaのプログラムは、コンパイラによってバイドコードに変換される。このバイトコードは、
                マシンやOSに依存しない中間言語である。
                """);
        hmap.put(5, """
                不正解
                正解は ア
                
                解説
                Javaの特徴の一つに、プラットフォームに依存しないことが挙げられる。Javaのプログラムは、
                様々プラットフォーム上で同様の動きをする。
                """);
        return hmap.get(quizNumber);
    }

    @Override
    public int extractLeadingNumber(String Quiz) {
        Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher = pattern.matcher(Quiz);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else
            return -1;
    }
}
