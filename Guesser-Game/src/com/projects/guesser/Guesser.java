package com.projects.guesser;

import java.util.Scanner;

class Guesser{
     Scanner scan=new Scanner(System.in);
     int guessNum;
     public int guessNum() {
         System.out.print("Guesser guess the number :: ");
         guessNum=scan.nextInt();
         return guessNum;
     }
 }