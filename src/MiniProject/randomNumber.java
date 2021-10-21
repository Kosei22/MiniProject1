package MiniProject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class randomNumber {
    public static void main(String[] args) {

        File file = new File("src/cities.txt");

        try(Scanner sc = new Scanner(file)){
            String[] cities = new String[100];
            int n = 0;
            while(sc.hasNextLine()){
                String city = sc.nextLine();
                cities[n] = city;
                n ++;
            }
            int num =  (int) (Math.random() * (cities.length));
            String cityName = cities[num];
            System.out.print(cityName);
            int charNum = cities[num].length();
            System.out.println(charNum);

            for(int i = 0; i < charNum; i ++){
                System.out.print("_");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
