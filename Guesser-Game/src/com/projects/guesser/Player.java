package com.projects .guesser;
import java.util.Scanner;

class Player{
    Scanner sc=new Scanner(System.in);
    int player1, player2,  player3;
    public int player1() {
        System.out.print("Player1 guess the number :: ");
        player1=sc.nextInt();
        return player1;
    }
    public int player2() {
        System.out.print("Player2 guess the number :: ");
        player2=sc.nextInt();
        return player2;
    }
    public int player3() {
        System.out.print("Player3 guess the number :: ");
        player3=sc.nextInt();
        return player3;
    }
}