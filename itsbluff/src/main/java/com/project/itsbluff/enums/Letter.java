package com.project.itsbluff.enums;

public enum Letter {
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

    public static Letter getRandomLetter() {
        return values()[(int) (Math.random() * values().length)];
    }
}
