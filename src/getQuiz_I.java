import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_I implements Quiz {
    private static final String[] QUIZZES = {
            """
1 Javaはスクリプト言語なので、ソースファイルにコンパイルしなくても実行できる

ア:正しい        イ:誤り
""",
            """
3 Javaのソースファイルでは、命令文の区切りにカンマを使用する。

ア:正しい        イ:誤り
""",
            """
6 Javaでは、参照型の変数しか扱うことができない

ア:正しい        イ:誤り
""",
            """
21 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
class Q21 {
    public static void main(String[] args) {
        int x, y = 25;
        
        x = y /= 4 + 3;
        System.out.println(x + " " + y);
    }
}

解答群
　ア ５行目でコンパイルエラーが起こる
　イ コンパイル及び実効され、[3 3] が表示される
　ウ コンパイル及び実効され、[9 6] が表示される
　エ コンパイル及び実効され、[9 25] が表示される
""",
            """
22 次のプログラムをコンパイル及び実行した結果として、ただしものはどれか。
enum Connection {OFFLINE, ONLINE}
class Q22 {
    public static void main(String[] args) {
    Connection s = OFFLINE;
        if (s == Connection.ONLINE) {
        s = Connection.OFFLINE;
        }
        System.out.println(s);
    }
}

解答群
　ア 3行目でコンパイルエラーが起こる。
　イ ５行目でコンパイルエラーが起こる。
　ウ コンパイル及び実行され、[OFFLINE] が表示される。
　エ コンパイル及び実効され、[ONLINE] が表示される。
""",
            """
23 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
class Q23 {
    public static void main(String[] args) {
        int i = 1;
        for (;;) {
            i = i + 3;
            if (i < 10 ) {
                continue;
            }else {
              break;
            }
            System.out.println(i);
        }
    }
}

解答群
　ア ４行目でコンパイエラーが起こる。
　イ １１行目でコンパイルエラーが起こる。
　ウ １２行目でコンパイルエラーが起こる。
　エ コンパイル及び実効され、[4] [7] が表示される。
""",
            """
24 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
class Q24 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            if ( i % 3 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}

解答群
　ア コンパイル及び実効され、何も表示されない。
　イ コンパイル及び実効され、[036] が表示される。
　ウ コンパイル及び実効され、[12345678] が表示される。
　エ コンパイル及び実効され、[012345678] が表示される。
""",
            """
26 次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
class Q26 {
   public static void main(String[] args) {
      int i = 0, sum = 0;
      while (++i < 8) {
         sum += i;
      }
      System.out.println(sum);
   }
}

解答群
　ア コンパイル及び実効され、[27] が表示される。
　イ コンパイル及び実効され、[28] が表示される。
　ウ コンパイル及び実効され、[36] が表示される。
　エ コンパイル及び実効され、[45] が表示される。
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
                スクリプト言語はソースファイルをそのまま解釈して実行できる言語であるが、Javaはプログラムの実効にソースファイルの
                コンパイルが必要なプログラム言語なので、スクリプト言語ではない。
                """);
        hmap.put(3, """
                Javaのソースファイルは、命令文の区切りとしてセミコロン[;]を用いる。
                """);
        hmap.put(6, """
                Javaは基本データ型(プリミティブ型)と参照型(オブジェクト型)の変数を扱える。
                """);
        hmap.put(21, """
                演算子の優先順位に関する問題である。[+]演算子は[/=]や[=]などの代入演算子より優先順位が高い。
                また、代入演算子は右から左へと処理が行われる。更にい、代入そのものも式であり、代入した値が
                式の値となる。以上を踏まえて式を読み解くと、まず[4 + 3]が実行され結果は７となり、次に、
                次に[y /= 7]が実行されるので、変数ｙの値は[3]となり、この式自体の値も[3]となる。最後に
                [x = 3]が実効されるため、変数ｘの値も[3]となる。
                """);
        hmap.put(22, """
                列挙型についての出題である。ここでは、５行目でConnection型の変数ｓに[OFFLINE]を設定しているように見えるが、
                列挙定数は６行目のように[Connection.OFFLINE]と列挙型名とともに指定する必要があるため、
                ５行目でコンパイルエラーとなる。
                """);
        hmap.put(23, """
                ７行目の continue文でforループの残りをスキップし、９行目のbreak文でforループから抜けるため、
                １１行目に制御が映ることがない。到達不能なコードがある場合、コンパイルエラーとなるため、１１行目
                でコンパイルエラーとなる。
                """);
        hmap.put(24, """
                ３行目のfor文により、iは0から8まで変化しながらループが実行される。算術演算子の％は余剰を求める
                演算子である。変数iの値が[3]の倍数でないときには、continue文によって７行目がスキップされ、iの
                値が出力されない。したがって、[036]が出力される。
                """);
        hmap.put(26, """
                while文についての出題である。繰り返し条件の変数 iの値が変化しないため、４行目のwhile文は無限ループ
                となり、[0]を出力し続ける。
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
