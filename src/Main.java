import java.util.Random;
import java.util.Scanner;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    public static void main(String[] args) {
        System.out.println("第４８回Javaプログラミング能力認定試験 ３級");
        Scanner scanner = new Scanner(System.in);
        Quiz[] quizzes ={new getQuiz_1(), new getQuiz_2(), new getQuiz_3(), new getQuiz_4()};
        Random rand = new Random();

        int count = 0;
        int answer = 0;
        while (count < 5){
            Quiz getQuiz = quizzes[rand.nextInt(quizzes.length)];
            String question = getQuiz.getRandomQuiz();
            System.out.println(question);
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            } else {
                boolean correct = getQuiz.answer(input);
                if (correct) {
                    System.out.println("正解");
                    answer++;
                } else {
                    System.out.println("不正解");
                }
            }
            count++;
        }
        System.out.println("正解数は"+count+"問中"+answer+"問です。");

        // whileを使うかswitchを使うかはわからない

    }
}

interface Quiz {
    String getRandomQuiz();
    boolean answer(String input);
}

class getQuiz_1  implements Quiz {
    private static final String[] QUIZZES = {
            "What is the capital of France?",

    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("1");
    }
}

class getQuiz_2  implements Quiz {
    private static final String[] QUIZZES = {
            "What is 2 + 2?",
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("2");
    }
}
class getQuiz_3  implements Quiz {
    private static final String[] QUIZZES = {
            "What is the largest ocean on Earth?",
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("3");
    }
}

class getQuiz_4  implements Quiz {
    private static final String[] QUIZZES = {
            "What is the chemical symbol for water?"
    };

    private Random random = new Random();

    @Override
    public String getRandomQuiz() {
        return QUIZZES[random.nextInt(QUIZZES.length)];
    }

    public boolean answer(String quiz) {
        return quiz.equals("4");
    }
}
