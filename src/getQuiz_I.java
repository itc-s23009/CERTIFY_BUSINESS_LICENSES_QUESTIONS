import java.util.Random;

class getQuiz_I implements Quiz {
    private static final String[] QUIZZES = {
            """
(1)Javaはスクリプト言語なので、ソースファイルにコンパイルしなくても実行できる

ア:正しい        イ:誤り
""",
            """
(3)Javaのソースファイルでは、命令文の区切りにカンマを使用する。

ア:正しい        イ:誤り
""",
            """
(6)Javaでは、参照型の変数しか扱うことができない

ア:正しい        イ:誤り
""",
            """
(21)次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。

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
(22)次のプログラムをコンパイル及び実行した結果として、ただしものはどれか。

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
(24)次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。

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
(26)次のプログラムをコンパイル及び実効した結果として、正しいものはどれか。
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
""",
            """
(
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
}
