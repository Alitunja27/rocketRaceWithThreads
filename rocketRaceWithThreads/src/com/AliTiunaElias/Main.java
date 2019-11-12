package com.AliTiunaElias;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Integer i;

        //Fase 1
        System.out.println("Fase 1");
        Rockets rocket1 = new Rockets("32WESSDS", 3);
        Rockets rocket2 = new Rockets("LDSFJA32", 6);
        System.out.println("Rocket 1: " + rocket1.name + " and have " + rocket1.numberOfPropulsors + " propulsors.");
        System.out.println("Rocket 2: " + rocket2.name + " and have " + rocket2.numberOfPropulsors + " propulsors.");
        //end of Fase 1

        //Fase 2
        System.out.println("Fase 2");
        List<Integer> rocket1Propulsor = new ArrayList<Integer>();
        rocket1Propulsor.add(10);
        rocket1Propulsor.add(30);
        rocket1Propulsor.add(80);
        List<Integer> rocket2Propulsor = new ArrayList<Integer>();
        rocket2Propulsor.add(30);
        rocket2Propulsor.add(40);
        rocket2Propulsor.add(50);
        rocket2Propulsor.add(50);
        rocket2Propulsor.add(30);
        rocket2Propulsor.add(10);
        System.out.println(rocket1.name + ": " + Rockets.toString(rocket1Propulsor));
        System.out.println(rocket2.name + ": " + Rockets.toString(rocket2Propulsor));
        //End Fase 2

        //Fase 3

        List<Integer> targetedPowerR1 = new ArrayList<>();
        List<Integer> targetedPowerR2 = new ArrayList<>();

        System.out.println("Rocket 1 desire power: ");
        for (i = 0; i < rocket1Propulsor.size(); i++) {
            System.out.println("Please set the power to propulsor " + (i + 1) + ": ");
            Integer targetedPower = new Scanner(System.in).nextInt();
            targetedPowerR1.add(targetedPower);
        }
        System.out.println("Rocket 2 desire power: ");
        for (i = 0; i < rocket2Propulsor.size(); i++) {
            System.out.println("Please set the power to propulsor " + (i + 1) + ": ");
            Integer targetedPower = new Scanner(System.in).nextInt();
            targetedPowerR2.add(targetedPower);
        }

        SpeedUpDown rocketThreats1 = new SpeedUpDown(1);
        SpeedUpDown rocketThreats2 = new SpeedUpDown(2);

        rocketThreats1.listsValues(rocket1Propulsor, targetedPowerR1);
        rocketThreats2.listsValues(rocket2Propulsor, targetedPowerR2);

        rocketThreats1.start();
        rocketThreats2.start();



        //End fase 3

        //Fase 4

        /*System.out.println("Please input Inicial speed");
        float initialSpeed = new Scanner(System.in).nextFloat();
        System.out.println("Please input Wanted Speed");
        float wantedSpeed = new Scanner(System.in).nextFloat();
        //for rocket 1
        Rockets.powerNeeds(rocket1Propulsor,wantedSpeed,initialSpeed);
        Rockets.powerNeeds(rocket2Propulsor,wantedSpeed,initialSpeed);

        List<Propulsors> propulsorR1RangePower = Propulsors.propulsorsPower(rocket1Propulsor);
        List<Propulsors> propulsorR2RangePower = Propulsors.propulsorsPower(rocket2Propulsor);
        List<Integer> actualR1Power = new ArrayList<>();
        List<Integer> actualR2Power = new ArrayList<>();
        float r1ActualSpeed = 0;
        float r2ActualSpeed = 0;
        for (i = 0; i < propulsorR1RangePower.size(); i++) {
            actualR1Power.add(0);
        }
        for (i = 0; i < propulsorR2RangePower.size(); i++) {
            actualR2Power.add(0);
        }
        String continueOption = "Y";
        while (continueOption.equalsIgnoreCase("Y")) {
            System.out.println("Which rocket do you want to change the propulsor power 1 o 2?");
            String rocketOption = new Scanner(System.in).nextLine();
            System.out.println("Do you want to speed up (U) or speed down (D)?");
            String speedOption = new Scanner(System.in).nextLine();
            if (speedOption.equalsIgnoreCase("u")) {
                if (rocketOption.equals("1")) {
                    actualR1Power = Rockets.speedUp(actualR1Power, propulsorR1RangePower);
                    r1ActualSpeed = Rockets.speed(actualR1Power, propulsorR1RangePower, r1ActualSpeed); //fase 4
                    System.out.println("Rocket " + rocket1.name + " actual propulsors power " + Rockets.toString(actualR1Power) +
                            " with a speed of: " + r1ActualSpeed);
                    if (actualR1Power.equals(rocket1Propulsor)) {
                        System.out.println("The propulsors on this rocket are at maximum power");
                    }
                } else if (rocketOption.equals("2")) {
                    actualR2Power = Rockets.speedUp(actualR2Power, propulsorR2RangePower);
                    r2ActualSpeed = Rockets.speed(actualR2Power, propulsorR2RangePower, r2ActualSpeed);//fase 4
                    System.out.println("Rocket " + rocket2.name + " actual propulsors power " + Rockets.toString(actualR2Power) +
                            " with a speed of: " + r2ActualSpeed);
                    if (actualR2Power.equals(rocket2Propulsor)) {
                        System.out.println("The propulsors on this rocket are at maximum power");
                    }
                } else {
                    new Exception("Is not a valid option of rocket");
                }
            } else if (speedOption.equalsIgnoreCase("d")) {
                if (rocketOption.equals("1")) {
                    actualR1Power = Rockets.speedDown(actualR1Power, propulsorR1RangePower);
                    r1ActualSpeed = Rockets.speed(actualR1Power, propulsorR1RangePower, r1ActualSpeed);//fase 4
                    System.out.println("Rocket " + rocket1.name + " actual propulsors power " + Rockets.toString(actualR1Power) +
                            " with a speed of: " + r1ActualSpeed);
                } else if (rocketOption.equals("2")) {
                    actualR2Power = Rockets.speedDown(actualR2Power, propulsorR2RangePower);
                    r2ActualSpeed = Rockets.speed(actualR2Power, propulsorR2RangePower, r2ActualSpeed);//fase 4
                    System.out.println("Rocket " + rocket2.name + " actual propulsors power " + Rockets.toString(actualR2Power) +
                            " with a speed of: " + r2ActualSpeed);
                } else {
                    new Exception("Is not a valid option of rocket");
                }
            } else {
                new Exception("This is not a valid option of change of speed");
            }
            System.out.println("Do you want continue changing the propulsors power Y/N?");
            continueOption = new Scanner(System.in).nextLine();
        }

        //******************************************************************************************************************************
        //******************************************SPEED IN A SPECIFIC TIME************************************************************
        //******************************************************************************************************************************

        System.out.println(rocket1.name + ": " + " have " + rocket1.numberOfPropulsors + " propulsors, each one with maximum power of "
                + Rockets.toString(rocket1Propulsor));
        System.out.println(rocket2.name + ": " + " have " + rocket2.numberOfPropulsors + " propulsors, each one with maximum power of "
                + Rockets.toString(rocket2Propulsor));
        System.out.println(rocket1.name + ": actual speed is: " + r1ActualSpeed);
        System.out.println(rocket2.name + ": actual speed is: " + r2ActualSpeed);
        for (i = 0; i < 3; i++) {
            actualR1Power = Rockets.speedUp(actualR1Power, propulsorR1RangePower);
            r1ActualSpeed = Rockets.speed(actualR1Power, propulsorR1RangePower, r1ActualSpeed);
            actualR2Power = Rockets.speedUp(actualR2Power, propulsorR2RangePower);
            r2ActualSpeed = Rockets.speed(actualR2Power, propulsorR2RangePower, r2ActualSpeed);
        }
        System.out.println(rocket1.name + ": actual speed after speed up 3 times is: " + r1ActualSpeed);
        System.out.println(rocket2.name + ": actual speed after speed up 3 times is: " + r2ActualSpeed);
        for (i = 0; i < 5; i++) {
            actualR1Power = Rockets.speedDown(actualR1Power, propulsorR1RangePower);
            r1ActualSpeed = Rockets.speed(actualR1Power, propulsorR1RangePower, r1ActualSpeed);
        }
        for (i = 0; i < 7; i++) {
            actualR2Power = Rockets.speedUp(actualR2Power, propulsorR2RangePower);
            r2ActualSpeed = Rockets.speed(actualR2Power, propulsorR2RangePower, r2ActualSpeed);
        }
        System.out.println(rocket1.name + ": actual speed after speed down 5 times is: " + r1ActualSpeed);
        System.out.println(rocket2.name + ": actual speed after speed up 7 times is: " + r2ActualSpeed);
        for (i = 0; i < 15; i++) {
            actualR1Power = Rockets.speedUp(actualR1Power, propulsorR1RangePower);
            r1ActualSpeed = Rockets.speed(actualR1Power, propulsorR1RangePower, r1ActualSpeed);
            actualR2Power = Rockets.speedUp(actualR2Power, propulsorR2RangePower);
            r2ActualSpeed = Rockets.speed(actualR2Power, propulsorR2RangePower, r2ActualSpeed);
        }
        System.out.println(rocket1.name + ": actual speed after speed up 15 times is: " + r1ActualSpeed);
        System.out.println(rocket2.name + ": actual speed after speed up 15 times is: " + r2ActualSpeed);*/
    }
}
