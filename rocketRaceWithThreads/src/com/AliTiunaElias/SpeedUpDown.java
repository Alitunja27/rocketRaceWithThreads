package com.AliTiunaElias;

import java.util.ArrayList;
import java.util.List;

public class SpeedUpDown extends Thread {

    List<Integer> propulsorMaxPower;
    List<Integer> targetedPower;

    public SpeedUpDown (Integer rocket){
        super (String.valueOf(rocket));

    }

    public void listsValues (List<Integer> propulsorMaxPower, List<Integer> targetedPower){
        this.propulsorMaxPower = propulsorMaxPower;
        this.targetedPower = targetedPower;
    }

    public static void sleepTime (){
        try{
            currentThread().sleep(1000);
        }catch(Exception e){
        }
    }

    public void powerUpDown(Integer targetedPower, Integer actualPower, Integer propulsorMaxPower, Integer j){

            if (targetedPower > actualPower && targetedPower >= propulsorMaxPower) {
                for (int i = 0; actualPower < propulsorMaxPower;i++) {
                    actualPower = actualPower + 1;
                    System.out.println("The propulsor " + j + " from rocket " + this.getName() + " power is " + actualPower);
                    sleepTime();
                }
            } else if(targetedPower > actualPower && targetedPower < propulsorMaxPower){
                for (int i = 0; actualPower < targetedPower;i++){
                    actualPower = actualPower + 1;
                    System.out.println("The propulsor " + j + " from rocket "+ this.getName() + " power is " + actualPower);
                    sleepTime();
                }
            } else if (targetedPower < actualPower && targetedPower > 0){
                for (int i = 0; actualPower < targetedPower;i++){
                    actualPower = actualPower - 1;
                    System.out.println("The propulsor " + j + " from rocket "+ this.getName() + " power is " + actualPower);
                    sleepTime();
                }
            } else if (targetedPower <= 0) {
                if (actualPower>0) {
                    for (int i = 0; actualPower == 0; i++) {
                        actualPower = actualPower - 1;
                        System.out.println("The propulsor " + j +  " from rocket "+ this.getName() + " power is " + actualPower);
                        sleepTime();
                    }
                }else{
                    actualPower = 0;
                    System.out.println("The propulsor " + j +  " from rocket "+ this.getName() + " power is " + actualPower);
                    sleepTime();
                }
            }
    }

    @Override
    public void run() {
        List<Integer> actualPower = new ArrayList<>();
        for (int i = 0; i<propulsorMaxPower.size();i++)
            actualPower.add(0);
        for (int j = 0; j<propulsorMaxPower.size(); j++){
            powerUpDown(targetedPower.get(j),actualPower.get(j),propulsorMaxPower.get(j),j);
        }
        currentThread().stop();
    }
}