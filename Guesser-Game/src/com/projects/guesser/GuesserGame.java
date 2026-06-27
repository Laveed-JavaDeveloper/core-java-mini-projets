package com.projects.guesser;
import java.util.*;

public class GuesserGame {
    public static void main(String[] args) {
        Umpire u=new Umpire();
        u.collectGuessNum();
        u.collectPlayerNum();
        u.compare();
    }
}
