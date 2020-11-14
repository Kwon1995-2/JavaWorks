package JavaStudy.LuxuryJava.ch4;

public class TV {
    private String manufacturer;
    private int year;
    private int size;

    public TV(String manufacturer, int year, int size) { //생성자
        this.manufacturer = manufacturer;
        this.year = year;
        this.size = size;
    }

    public void show() { //클래스 메서드
        System.out.print(this.manufacturer+" ");
        System.out.print(this.year+" ");
        System.out.print(this.size);
    }

    public static void main(String[] args) {
        TV myTV = new TV("LG",2017,32);
        myTV.show();
    }
}
