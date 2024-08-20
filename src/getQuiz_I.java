import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_I implements Quiz {
    private static final String[] QUIZZES = {
            """
1 Javaでは、コンパイル時においてのみエラーチェックが行われる。
                       解答群
           　ア 正しい           イ 誤り
""",
            """
2 Javaのソースファイルの拡張子は[.class]である。
                       解答群
           　ア 正しい           イ 誤り
""",
            """
6 Javaのプログラムでは、C言語と同様にポインタ型の変数を使用することができる。
                       解答群
           　ア 正しい           イ 誤り
""",
            """
20 次のプログラム中の[ b ]に当てはまるものとして、正しいものはどれか。
class Q20 {
    public static void main(String[] args) {
        [ b ] = new int[10];
        System.out.println(arr.length);
    }
}

解答群
　ア int arr
　イ int[] arr
　ウ int[10] arr
　エ int[][] arr
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

    @Override
    public String Explanation(int quizNumber) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(1, """
                不正解
                正解は イ
                
                解説
                Javaは、コンパイル時と実行時の両方で厳しいエラーチェック(型のチェックやメモリの不正利用など)が実施されるため、
                安定性に優れたぷろぐらむを作成することができる。
                """);
        hmap.put(2, """
                不正解
                正解は イ
                
                解説
                Javaのソースファイルは拡張子が[.java]である。拡張子が[.class]のファイルは
                ソースファイルをコンパイルして出力されたバイトコードのファイルである。
                """);
        hmap.put(6, """
                不正解
                正解は イ
                
                解説
                Javaは、C言語のようなポインタ型を採用していない。これは、メモリを直接アクセスできないようにすることで
                メモリ管理に関わるトラブル(バッファ・オーバランによるデータ領域破壊など)を防止し、安全性を高めるためである。
                """);
        hmap.put(20, """
                不正解
                正解は イ
                
                解説
                ３行目の[new int[10]]では int型の一次元配列を生成しており、=の左辺では int型の１次元配列の宣言が必要となる。
                したがって、選択肢[イ]の[int[] arr]が正答である。選択肢[ア]は配列が
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
