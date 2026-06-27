package com.projects.guesser;


class Umpire{
    int numFromGuesser, numFromPlayer1, numFromPlayer2, numFromPlayer3;
    public void collectGuessNum() {
        Guesser g=new Guesser();
        numFromGuesser=g.guessNum();
    }
    public void collectPlayerNum() {
        Player p1=new Player();
        numFromPlayer1=p1.player1();
        Player p2=new Player();
        numFromPlayer2=p2.player2();
        Player p3=new Player();
        numFromPlayer3=p3.player3();
    }
    public void compare() {
        if(numFromGuesser==numFromPlayer1) {
            if(numFromGuesser==numFromPlayer2&&numFromGuesser==numFromPlayer3) {
                System.out.println("Game tied between all players");
            }
            else if(numFromPlayer1==numFromPlayer2) {
                System.out.println("Player-1&2 won the game");
            }
            else if(numFromPlayer1==numFromPlayer3) {
                System.out.println("Player-1&3 won the game");
            }
            else {
                System.out.println("Player-1 won the game");
            }
        }
        else if(numFromGuesser==numFromPlayer2) {
            if(numFromPlayer2==numFromPlayer3) {
                System.out.println("Player-2&3 won the game");
            }else{
                System.out.println("Player-2 won the game");
            }
        }
        else if(numFromGuesser==numFromPlayer3) {
            System.out.println("Player-3 won the game");
        }
        else {
            System.out.println("Guesser won the game");
            System.out.println("Game over! Try again");
        }
    }
}