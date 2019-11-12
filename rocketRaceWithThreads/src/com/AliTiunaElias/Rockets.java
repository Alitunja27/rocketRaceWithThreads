package com.AliTiunaElias;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Rockets {
    protected String name;
    protected Integer numberOfPropulsors;

    public Rockets (String name, Integer numberOfPropulsors ){
        this.name = name;
        this.numberOfPropulsors = numberOfPropulsors;
    }

    public static List<Integer> speedUp(List<Integer> actualPower, List<Propulsors> propulsorRangePower){
        for (int i=0;i<actualPower.size();i++) {
            if (actualPower.get(i) <= (propulsorRangePower.get(i).maximum - 10)) {
                actualPower.set(i, (actualPower.get(i) + 10));
            }
        } return actualPower;
    }
    public static List<Integer> speedDown(List<Integer> actualPower, List<Propulsors> propulsorRangePower){
        for (int i=0;i<actualPower.size();i++) {
            if (actualPower.get(i) >= (propulsorRangePower.get(i).minimum + 10)) {
                actualPower.set(i, (actualPower.get(i) - 10));
            }
        } return actualPower;
    }
    public static String toString (List<Integer> list){
        String formattedTOString = list.toString()
                .replace("[","")
                .replace("]","")
                .replace(" ","");
        return formattedTOString;
    }
    public static float speed (List<Integer> actualPower,List<Propulsors> propulsorsRangePower, float actualSpeed){
        Integer propulsorPower = 0;
        for (int i=0;i<propulsorsRangePower.size();i++){
            propulsorPower = propulsorPower + actualPower.get(i);
        }
        float speed = (float) (actualSpeed + (100*(Math.sqrt(propulsorPower))));
        return speed;
    }
    public static void powerNeeds (List<Integer> maximum, float speed, float actualSpeed){
        float propulsorPower = (float) Math.pow(((speed-actualSpeed) / 100),2) ;
        Integer propulsorMaxPower = 0;
        for (int i=0;i<maximum.size();i++){
            propulsorMaxPower = propulsorMaxPower + maximum.get(i);
        }
        if (propulsorMaxPower<propulsorPower){
            System.out.println("The rocket does not have the required power to accelerate to: " + speed);
        }else if (propulsorMaxPower>propulsorPower){
            float propulsorExtraPower = propulsorMaxPower - propulsorPower;
            List<Float> powerRequired = new ArrayList<Float>();
            for (int i=0;i<maximum.size();i++) {
                if (maximum.get(i) - propulsorExtraPower < 0) {
                    propulsorExtraPower = propulsorExtraPower - maximum.get(i);
                    powerRequired.add((float) 0);
                } else if (maximum.get(i) - propulsorExtraPower > 0) {
                    powerRequired.add(maximum.get(i) - propulsorExtraPower);
                    propulsorExtraPower=0;
                } else if (propulsorExtraPower == 0){
                    powerRequired.add((float) maximum.get(i));
                }
            }
            System.out.println("The propulsor power to reach " + speed + " is " + powerRequired);
        }
    }

}
