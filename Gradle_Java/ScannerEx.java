package JavaStudy.Gradle_Java;

import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        System.out.println("이름은 "+name+", ");

        String city = scanner.next();
        System.out.print("도시는 "+city+", ");

        int age = scanner.nextInt();
        System.out.print("나이는 "+age+"살, ");

        double weight = scanner.nextDouble();
        System.out.print("체중은 "+weight+"kg, ");

        boolean isSingle = scanner.nextBoolean();
        System.out.println("독신 여부는 "+isSingle+"입니다.");
        scanner.close();
    }
}
