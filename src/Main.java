import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    public static void main(String[] args) {
        // 第４８街Javaプログラムング能力検定試験３級
        Scanner scanner = new Scanner(System.in);
        System.out.println("第４８回Javaプログラミング能力認定試験 ３級");
        System.out.println("問題は３７問ランダムに出題されます。選択肢で答えて下さい。 \nEnterを押してスタートです。");
        String s = scanner.nextLine();
        Quiz[] quizzes = {new getQuiz_A(), new getQuiz_I(), new getQuiz_U(), new getQuiz_E()};
        Random rand = new Random();

        int count = 0;
        int answer = 0;
        while (count < 37) {
            Quiz getQuiz = quizzes[rand.nextInt(quizzes.length)];
            String question = getQuiz.getRandomQuiz();
            System.out.println();
            System.out.println(question);
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                boolean correct = getQuiz.answer(input);
                if (correct) {
                    System.out.println("正解");
                    answer++;
                } else {
                    System.out.println(getQuiz.Explanation(getQuiz.extractLeadingNumber(question)));
                    String enter = scanner.nextLine();
                }
                count++;
            }
        }
        System.out.println("正解数は" + count + "問中" + answer + "問です。");
    }
}



