import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class getQuiz_A implements Quiz {
    private static final String[] QUIZZES = {
            """
2 Javaのプログラミングを実行するには、JVM(Java Virtual Machine)が必要である。

ア:正しい        イ:誤り
""",
            """
4 Javaアプレットとは、Webブラウザ上で実行されるJavaのプログラミングのことである。

ア:正しい        イ:誤り
""",
            """
5 Javaでは、プログラム内部で文字を表すのにUnicode標準を使用している。

ア:正しい        イ:誤り
"""
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
        hmap.put(2, """
                Javaプログラムを実行するには、JVM(Java Virtual Machine. Java仮想マシン)が必要である。
                Javaアプリケーションの場合は、Javaコマンドを実行することにより、JVMを起動している。
                """);
        hmap.put(4, """
                Webブラウザ上で実行されるJavaのプログラムはJavaアプレットと呼ばれ、
                通常のアプリケーションとは作成方法、実行方法が異なる。
                """);
        hmap.put(5, """
                Javaは、プログラム内部で文字を表すのにUnicode標準を採用している。外部との入出力にそれ以外の
                文字コードを使うこともでき変換を行うライブラリが用意されている。
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
