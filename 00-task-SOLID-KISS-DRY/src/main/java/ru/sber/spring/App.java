package ru.sber.spring;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Доработать приложение для тестирования
 * - добавить объектную модель (реализовать создание бинов с помощью Java + Annotation-based конфигурации)
 * - применить принципы SOLID/DRY/KISS, где это уместно
 * - написать unit-тесты
 * - реализовать запуск приложения через "java -jar"
 * - Задать вопросы из CSV-файла пользователю, проверить корректность и вывести результат
 */

public class App {

    public static void main(String[] args) throws IOException {

        boolean header = true;

        Path absolutePath = FileSystems.getDefault().getPath("").toAbsolutePath();
        File file = new File(absolutePath + "\\src\\main\\resources\\file.csv");

        try
        {
            List<String> answerList = new ArrayList<>();
            Scanner sc = new Scanner(file);
            Scanner answer = new Scanner(System.in);
            while(sc.hasNext())
            {
                if (header) {
                    sc.nextLine();
                    header = false;
                    continue;
                }

                int correctAnswer = 0;

                String result[] = sc.nextLine().split(",");

                System.out.println(result[0]);
                System.out.println("1. " + result[1]);
                if (Boolean.parseBoolean(result[2])) {
                    correctAnswer = 1;
                }

                sc.hasNext();
                result = sc.nextLine().split(",");
                System.out.println("2. " + result[1]);
                if (Boolean.parseBoolean(result[2])) {
                    correctAnswer = 2;
                }

                sc.hasNext();
                result = sc.nextLine().split(",");
                System.out.println("3. " + result[1] + "\n");
                if (Boolean.parseBoolean(result[2])) {
                    correctAnswer = 3;
                }

                System.out.print("Your answer 1-3: ");
                Integer ans = answer.nextInt();
                if (ans == correctAnswer) {
                    answerList.add(ans + " - correct answer");
                } else {
                    answerList.add(ans + " - incorrect answer");
                }
            }

            answerList.stream()
                    .forEach(System.out::println);
        }
        catch(IOException e)
        {
            // work with the errors here
            System.out.println(e.fillInStackTrace());
        }
    }
}
