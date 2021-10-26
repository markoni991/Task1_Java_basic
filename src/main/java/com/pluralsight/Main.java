package com.pluralsight;

import org.apache.log4j.ConsoleAppender;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.*;
import java.util.logging.Logger;



public class Main {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void init(){
        FileHandler fh;
        try{
            fh = new FileHandler("C:/Users/milic/files/JAVA1_fundamentals.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Logger initialized!");

        }catch (Exception e){
            logger.log(Level.WARNING, "Exception: " , e);
        }

    }

    public static void BubbleSort(int niz[]){

        int i, j, temp;
        for  (i=niz.length-1; i>0; i--){
            for(j=0; j<i; j++){
                if(niz[j] > niz[j+1]){
                    temp = niz[j];
                    niz[j] = niz[j+1];
                    niz[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        init();

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite velicinu niza: ");
        int N = sc.nextInt();

        int niz[] = new int[N];

        System.out.println("-------------------------------------------------------");
        for(int i=0; i<N; i++){
            System.out.println("Element na poziciji " + i);
            niz[i] = sc.nextInt();
        }

        System.out.println("Niz izgleda ovako: ");
        System.out.println(Arrays.toString(niz));

        System.out.println("--------------------------------------------------------");
        System.out.println("Bubble sort: ");
        BubbleSort(niz);
        System.out.println("Nakon sortiranja: ");
        System.out.println(Arrays.toString(niz));

        logger.info("End of program...");

    }
}
