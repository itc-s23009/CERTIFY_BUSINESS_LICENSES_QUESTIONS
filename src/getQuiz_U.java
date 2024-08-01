import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_U implements Quiz {
    private static final String[] QUIZZES = {
            """
18 次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。
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
19 コードとして、正しいものはどれか。
解答群
　ア int array1 = new int[5];
　イ int[] array2 = new int[5];
　ウ int[] array3 = new int[5];
　エ　 int[] array4 = new int[][5];
""",
            """
20 次のプログラムをコンパイル及び実行した結果として、正しいものはどれか。ここで、\nプログラム中の文字コード[0x30]は文字の[0]を示す。
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
25 次のプログラム中の、[ a ] に当てはまるものとして、正しいものはどれか。
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
        return quiz.equals("ウ") || quiz.equals("ゥ") || quiz.equals("う") || quiz.equals("u") || quiz.equals("U");
    }

    @Override
    public String Explanation(int quizNumber) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(18, """
                不正解
                正解はウ
                
                解説
                変数 baseValueは double型で、変数 unitsは int型である。６行目の計算式 baseValue * unitsは、
                型の違う計算となるため、変数 unitsの値３がより大きい方の型である double型へ変換されて 3.0となり、
                3.5 * 3.0として計算され、結果の 10.5がwidthへ代入される。この式では、計算の途中で小数点以下の
                切り捨てや切り上げは行われない。したがって、選択肢 [ウ] が正当である。
                """);
        hmap.put(19, """
                不正解
                正解はウ
                
                解説
                int型の配列を宣言している。配列は、宣言時に次元数と同じ個数の[]が必要である。また、配列はオブジェクトなので
                newキーワードが必要である。選択肢[ア]は、変数名array1の前または後ろに[]が一つ必要であるが、それがない。
                選択肢 [イ]は、newキーワードがない。選択肢[エ]は、２次元配列の宣言時において、new int[][5]のように
                最初の要素数の省略はできない。したがって、選択肢[ウ]が正当である。
                """);
        hmap.put(20, """
                不正解
                正解はウ
                
                解説
                char型の変数ｃに文字コード 0x30が代入されている。これは、文字[0]に相当する。char型は文字を格納するデータ型であるが、
                実際には文字コードが格納されているため、数値演算を行うことができる。変数ｃの値に９を加算すると[0x30]となり、
                この文字コードに対応する文字[9]が出力される。
                """);
        hmap.put(25, """
                不正解
                正解はウ
                
                解説
                setCodeはクラスQ25のメソッドである。４行目でいんすたんすを生成し、objへ設定しており、５行目でsetCodeメソッドを呼び出す。
                ７行目の記述によりsetCodeメソッドは Stringを一つ引数として受け取る仕様となっているので、[ウ]が正答となる。[ア]は（「」）
                がないためメソッドの呼び出しである。[エ]は文字れてラルを囲む記号[`]で文字列リテラルが囲ってある。
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
