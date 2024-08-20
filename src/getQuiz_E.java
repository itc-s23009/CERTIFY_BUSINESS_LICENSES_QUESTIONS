import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_E implements Quiz {
    private static final String[] QUIZZES = {
            """
17 次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。
class Q17 {
    public static void main (String[] args) {
    int n = 35;
    System.out.println(n > 15 && n <= 30);
    }
}

解答郡
　ア [0] と表示される。
　イ [1] と表示される。
　ウ [true] と表示される。
　エ [false] と表示される。
""",
            """
27 次のプログラムをコンパイルした結果として、正しいものはどれか。
public class Q27 {
    public static void main (String[] args) {
       int i = 0;
       while ( i <= 6) {
          System.out.println(i);
       }
    }
}

解答群
　ア ５行目でコンパイルエラーが起こる。
　イ コンパイル及び実効され、[012345] が表示される。
　ウ コンパイル及び実効され、[0123456] が表示される。
　エ コンパイル及び実効され、[0] が繰り返し表示される。
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

    @Override
    public String Explanation(int quizNumber) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(17, """
               不正解
               正解は エ
               
               解説
               Javaでは真理値は boolean型の値で表され、真は true、偽は falseである。printlnメソッドの中の式は、
               ２つの比較演算式が&&演算子で結合された式であり、２つの比較演算が両方とも trueのときに結果が trueと
               なる。nは１５より大きいが、３０以下ではないので、２つの比較演算の結果は、trueとはならず、println
               メソッドの中の式の結果は falseとなる。したがって、[false]と表示される。
               """);
        hmap.put(27, """
                不正解
                正解は エ
                
                解説
                while文のについての出題である。繰り返し条件の変数 iの値が変化しないため、４行目のwhile文は無限ループとなり、
                [0]を出力し続ける。
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

