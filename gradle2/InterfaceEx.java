package com.tuyano.gradle2;

import javax.management.openmbean.SimpleType;

interface PhoneInterface {
    final int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    default void printLogo() {
        System.out.println("** Phone **");
    }
}

interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS();
    void receiveSMS();
}
interface MP3Interface {
    public void play();
    public void stop();
}

class PDA {
    public int calculate(int x, int y) {
        return x+y;
    }
}

class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {
    @Override
    public void sendCall() {
        System.out.println("Dririring");
    }
    @Override
    public void receiveCall() {
        System.out.println("I got a call");
    }
    @Override
    public void sendSMS() {
        System.out.println("The Text goes");
    }
    @Override
    public void receiveSMS() {
        System.out.println("The Text comes");
    }

    @Override
    public void play() {
        System.out.println("The music plays");
    }
    @Override
    public void stop() {
        System.out.println("The music terminates");
    }

    public void schedule() {
        System.out.println("The Schedule is managed");
    }

};

//class SamsungPhone implements PhoneInterface {
//    @Override
//    public void sendCall() {
//        System.out.println("Diririring");
//    }
//    @Override
//    public void receiveCall() {
//        System.out.println("I got a call");
//    }
//
//    public void flash() {
//        System.out.println("The phone is lit");
//    }
//
//}

public class InterfaceEx {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();
        phone.printLogo();
        phone.sendCall();
        phone.play();
        System.out.println("3 plus 5 is "+phone.calculate(3,5));
        phone.schedule();
    }

}
