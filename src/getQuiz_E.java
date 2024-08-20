import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_E implements Quiz {
    private static final String[] QUIZZES = {
            """
17 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
class Q17 {
    public static void main(String[] args) {
        int n = 1;
        
        System.out.println(++n + " " + n--);
    }
}

解答群
　ア [1 1]と表示される。
　イ [1 2]と表示される。
　ウ [2 1]と表示される。
　エ [2 2]と表示される。
""",
            """
18 次のプログラムをコンパイル及び実効し、[5.0]と出力されるようにしたい。
プログラム中の[ a ]に当てはまるものとして、正しいものはどれか。
class Q18 {
    public static void main(String[] args) {
        int total = 75;
        int capacity = 30;
        int cargo = 2;
        
        System.out.println([ a ]);
    }
}
実行結果[ 5.0 ]

解答群
　ア total / capacity * (double)cargo;
　イ total / capacity * cargo
　ウ (double)(total / capacity * cargo)
　エ (double)total / capacity * cargo
""",
            """

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
                インクリメント及びデクリメント演算子の前置と後置の違いを問う問題である。
                [++n]は位置加算されてから出力される。一方[n--]は出力されてから１減産される。
                """);
        hmap.put(18, """
                不正解
                正解は エ
                
                解説
                int型同士の演算結果はint型となるため、計算式 total / capacity の演算結果は切り捨てが行われ、
                ２となってしまう。変数 total又は変数 capacityのどちらかを double型にキャストすれば、double型と
                int型の演算となり、計算がすべて double型と int型の演算となり、計算が全て double型で行われ、
                演算結果は、5.0となる。したがって選択肢[エ]の [(double)total / capacity * cargo]が正答である。
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

