package JavaStudy.LuxuryJava.ch4;

public class Song {
    private String title; //class variables
    private String artist;
    private int year;
    private String country;

    public Song() { } //default 생성자
    //오버로딩 생성자
    public Song(String title, String artist, int year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    public void show() {
        System.out.print(year+" ");
        System.out.print(country+" ");
        System.out.print(artist+" ");
        System.out.println(title);
    }

    public static void main(String[] args) {
        Song myFavorite = new Song("Dancing Queen", "ABBA",1978,"USA");
        myFavorite.show();
    }
}
