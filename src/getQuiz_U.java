import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_U implements Quiz {
    private static final String[] QUIZZES = {
            """
19 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか？
class Q19 {
    public static void main (String[] args) {
        int value = 234;
        int reference = 200;
        System.out.println(value > reference);
    }
}

解答群
　ア ５行目でコンパイルエラーが起こる
　イ コンパイル及び実効され、[-1]が表示される
　ウ コンパイル及び実効され、[true]が表示される
　エ コンパイル及び実効され、[false]が表示される
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

    @Override
    public String Explanation(int quizNumber) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(19, """
                不正解
                正解は ウ
                
                解説
                数値の比較などの判定式の結果は boolean型となるので、value > referenceの結果は boolean型となる。
                ５行目の System.out.printlnは引数として booleanを受け取り、trueの場合は、文字列[true]を,
                そうでない場合は、文字列[false]を出力する。
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
