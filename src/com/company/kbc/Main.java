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

    private static int choice, lifeLine, correct;

    private static int double_dip = 0;
    private static int double_dip1 = 0;
    private static int phone_of_friend = 0;
    private static int expert_advice = 0;
    private static int audience_poll = 0;

    private static String key, option;


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
        System.out.print("\n Enter you choice: ");
        option = br.readLine();
        if (option.charAt(0) == 'A' || option.charAt(0) == 'a'){
            choice = 1;
        } else if (option.charAt(0) == 'B' || option.charAt(0) == 'b') {
            choice = 2;
        } else if (option.charAt(0) == 'C' || option.charAt(0) == 'c') {
            choice = 3;
        } else if (option.charAt(0) == 'D' || option.charAt(0) == 'd') {
            choice = 4;
        } else if (option.charAt(0) == 'L' || option.charAt(0) == 'l') {
            selectLifeLine();
            if (double_dip1 == 0){
                gamePlayService();
            }
            double_dip1=0;
        } else if (option.charAt(0) == 'Q' || option.charAt(0) == 'q') {
            quit();
        } else {
            System.out.print("\n Invalid Choice... \n Try Again...");
            gamePlayService();
        }
    }

    private static void selectLifeLine() throws IOException {
        int i;
        System.out.print("\n You have following lifeline: ");
        for (i=0;i<LIFE_LINE.length;i++){
            System.out.print("\n" + LIFE_LINE[i]);
        }
        System.out.print("Which one would you like to use: ");
        lifeLine = Integer.parseInt(br.readLine());
        switch (lifeLine) {
            // Audience Poll
            case 1:
                setAudience_poll();
                break;
            // Phone of Friends
            case 2:
                setPhone_of_friend();
                break;
            // Double Dip
            case 3:
                setDouble_dip();
                break;
            // Expert Advice
            case 4:
                setExpert_advice();
                break;
            default:
                System.out.print("\n Invalid Choice");
        }
    }

    private static void setAudience_poll() {
        audience_poll++;
        int[] a = new int[3];
        int s=0, i, j, c;
        LIFE_LINE[0] = "";
        for (i=0;i<=2;i++){
            // Randomly select any three number;
            c=random.nextInt(15);
            a[i] = c;
        }

        // s is difference between 100 and sum of a array.
        s = 100 - (a[0]+a[1]+a[2]);
        System.out.print(" \n Waiting.... \n");

        if (correct == 1) {
            System.out.print("\n A. " + s + "%");
            System.out.print("\n B. " + a[0] + "%");
            System.out.print("\n C. " + a[1] + "%");
            System.out.print("\n D. " + a[2] + "%");
        }
        if(correct==2)
        {
            System.out.print("\n A. " + a[0] + " %");
            System.out.print("\n B. " + s + " %");
            System.out.print("\n C. " + a[1] + " %");
            System.out.print("\n D. " + a[2] + " %");
        }
        if(correct==3)
        {
            System.out.print("\n A. " + a[1] + " %");
            System.out.print("\n B. " + a[0] + " %");
            System.out.print("\n C. " + s + " %");
            System.out.print("\n D. " + a[2] + " %");
        }
        if(correct==4)
        {
            System.out.print("\n A. " + a[2] + " %");
            System.out.print("\n B. " + a[0] + " %");
            System.out.print("\n C. " + a[1] + " %");
            System.out.print("\n D. "+ s + " %");
        }
    }

    private static void setPhone_of_friend() {
        phone_of_friend++;

        int c = random.nextInt(5);
        System.out.print("\n");
        LIFE_LINE[1] = "";
        if (c==1 || c==2 || c==5 || c==4) {
            if (correct == 1) {
                System.out.print("Friend says it is \'A\' ");
            }
            if (correct == 2) {
                System.out.print("Friend says it is \'B\' ");
            }
            if (correct == 3) {
                System.out.print("Friend says it is \'C\' ");
            }
            if (correct == 4) {
                System.out.print("Friend says it is \'D\' ");
            }
        } else {
            System.out.print("Friend says, \" I have no idea \"" );
        }
    }

    private static void setDouble_dip() throws IOException {
        double_dip1 = 1;
        LIFE_LINE[2] = "";
        double_dip++;
        System.out.print("\n First choice: ");
        gamePlayService();
        if (correct == choice) {
            System.out.print("\n Correct answer");
        } else {
            System.out.print("\n Wrong answer. \n \n Second choice: ");
            gamePlayService();
        }
    }

    private static void setExpert_advice() throws IOException{
        expert_advice++;
        int c = random.nextInt(5);
        System.out.print("\n");
        LIFE_LINE[3] = "";
        if (c==1 || c==2 || c==5 || c==4) {
            if (correct == 1) {
                System.out.print("Expert think it is \'A\' ");
            }
            if (correct == 2) {
                System.out.print("Expert think it is \'B\' ");
            }
            if (correct == 3) {
                System.out.print("Expert think it is \'C\' ");
            }
            if (correct == 4) {
                System.out.print("Expert think it is \'D\' ");
            }
        } else {
            System.out.print("Expert has no idea" );
        }
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
