package com.project.itsbluff.choice;

public enum LetterEnum {
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

    public static LetterEnum getRandomLetter() {
        return values()[(int) (Math.random() * values().length)];
    }
}
