/**
 *  Project Name: Kaun Banega Crorepati
 *  Author: Ahtesham
 *  Version: 1.0
 */
package com.company.kbc;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    // This is Object for InputStreamReader and BufferedReader.
    private static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    // This is Object for Random.
    private static Random random = new Random();

    // Amount storing in Array.
    private static final int PRICE[] = {5000,10000,20000,
                40000,80000,160000,320000,640000,1250000,2500000,
                5000000, 10000000,50000000,70000000};

    // Life Line names
    private static final String[] LIFE_LINE = {
        "1. Audience Poll", "2. Phone of friends",
        "3. Double Dip",  "4. Expert Advice"
    };

    private static int stage, final_amount, playing_amount;

    private static String key;


    public static void main(String[] args) throws IOException {
	// write your code here
        show();
    }

    /**
     * This method show all game in @main() method.
     *
     * @throws IOException This is for Handling Exception
     *                  during Input the data
     */
    private static void show()throws IOException {
        int i,j;
        System.out.print(" \t \t Welcome to Kaun Banega Crorepati");
        System.out.print("\n You\'ll have to answer 14 question to win 7 Crore ruppees \n");
        // It will show all amount to select your stage to play.
        for(i=1; i<=PRICE.length; i++){
            System.out.print("\n"+i+" \t Rs. "+PRICE[i-1]);
        }
        stageSelection();
        System.out.print("You'll have 4 lifelines to help you \n");
        System.out.print(LIFE_LINE[0]+" - Will help you to take audience's opinion\n");
        System.out.print(LIFE_LINE[1]+" - Will enable you to call your friend for the answer\n");
        System.out.print(LIFE_LINE[2]+" - Ask the experts for their advice\n");
        System.out.print(LIFE_LINE[3]+" - Will allow you to give two answers for the same question\n");
        System.out.print("\n Warning : If you use double dip, you'll not be able to quit the game or use another lifeline");
    }

    private static void stageSelection() throws IOException {
        String s;
        System.out.print("\n Please select a stage (Enter the amount) : ");
        stage = Integer.parseInt(br.readLine());
        if (stage>=1 && stage<=14) {
            System.out.print("\n You have selected: " + stage+ "\t --> Rs. "+ PRICE[stage-1]);
            System.out.print("\n\n Are you sure (Yes/N0): ");
            s = br.readLine();
            if (!(s.charAt(0) == 'Y' || s.charAt(0) == 'y')){
                stageSelection();
            }
        } else {
            System.out.print("\n Invalid Input.... \n Please try again....");
            stageSelection();
        }
    }

    private static void controlKey() throws IOException {
        System.out.print("\n Enter choices(answer) like \'A\', \'B\', \'C\', \'D\'");
        System.out.print("\n Enter \'L\' for choose a life line.");
        System.out.print("\n Enter any key to clear screen and play game.");
        key = br.readLine();
    }

    private static void gamePlayService() throws IOException {

    }

    private static void quit(){
        final_amount = playing_amount;
        finish();
    }

    private static void finish() {
        System.out.print("\n You have won " + final_amount +
                " Ruppees.");
        System.out.print("\n Thank you for participating in" +
                " Kaun Banega Crorepati.");
        System.out.print("\n Wish you to all the best \n Take care ");
        System.out.print("\n Hope you enjoy the game. ");
        System.exit(0);
    }

}
