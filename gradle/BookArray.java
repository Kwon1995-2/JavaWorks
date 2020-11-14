package com.tuyano.gradle;
import java.util.Scanner;
class Book {
    String title, author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookArray {
    public static void main(String[] args) {
        Book[] book = new Book[2]; //Total length : 2

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<book.length;i++) {
            System.out.print("title>>");
            String title = scanner.nextLine();
            System.out.print("author>>");
            String author = scanner.nextLine();
            book[i] = new Book(title, author);
        }

        for(int i=0;i<book.length;i++)
            System.out.print("("+book[i].title+", "+book[i].author+")");

        scanner.close();
    }
}
