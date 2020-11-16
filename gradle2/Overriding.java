package com.tuyano.gradle2;

class Weapon {
    protected int fire() {
        return 1;
    }
}

class Cannon extends Weapon {
    @Override
    protected int fire() {
        //super.fire();
        return super.fire();//10;
    }
}

public class Overriding {
    public static void main(String[] args) {
        Weapon weapon;
        weapon = new Weapon();
        System.out.println("The killing ability of basic weapon is "+weapon.fire());

        weapon = new Cannon();
        System.out.println("The cannon's killing power is "+weapon.fire());
    }
}
