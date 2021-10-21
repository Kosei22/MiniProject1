package MiniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class inputChar {
    public static void main(String[] args) {
        //-----------------------------------------------------------------------------------------------------
//        file scan

        File file = new File("src/cities.txt");

        String cityName = "";
        int charNum = 0;
        int wrongNum = 0;
        String wrongNums = "";
        String guessNum = "";

        try (
                Scanner sc = new Scanner(file)) {
            String[] cities = new String[100];
            int n = 0;
            while (sc.hasNextLine()) {
                String city = sc.nextLine();
                cities[n] = city;
                n++;
            }

            int num = (int) (Math.random() * (cities.length));
            cityName += cities[num];

            charNum = cityName.length();


        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Here's the question.");

        for (int i = 0; i < charNum; i++) {
            guessNum += "_";
        }

        System.out.println(guessNum);

        StringBuilder newGuessNum = new StringBuilder(guessNum);

        int a = 0;
//---------------------------------------------------------------------------------------------------------------
//       loop until end && user input
        System.out.println(cityName);
        for (int n = 0; wrongNum < 10 ; n++) {

            Scanner inputChar = new Scanner(System.in);
            System.out.println("Guess a letter: ");
            String str = inputChar.next();
            char g = str.charAt(0);
            char guessChar = Character.toLowerCase(g);


            if(str.length() > 1){
                System.out.println("You must guess one character");
                continue;
            }
//---------------------------------------------------------------------------------------------------------------
//            check char

            String c = cityName.toLowerCase();

            for (int i = 0; i < charNum; i++) {
                if (c.charAt(i) == guessChar) {
                    newGuessNum.setCharAt(i, guessChar);
                    a++;
                }
            }
            if (a == 0) {
                wrongNums += guessChar + " ";
                wrongNum++;
            }
            System.out.println((newGuessNum));
            System.out.println("You have guessed (" + wrongNum + ") wrong letters :" + wrongNums);

            if(a != 0){
                for (int i = 0; i < charNum; i++) {
                    if (c.charAt(i) == guessChar) {
                        newGuessNum.setCharAt(i, guessChar);
                        a--;
                    }
                }

            }

            String guess = newGuessNum.toString();
            if(guess.equals(c)){
                System.out.println("You win!!");
                System.out.println("You have guessed " + cityName + " correctly");
                break;
            }

            if(wrongNum == 10){
                System.out.println("You lose!");
                System.out.println("The correct word was '" + cityName + "'");
                break;
            }



        }
    }
}