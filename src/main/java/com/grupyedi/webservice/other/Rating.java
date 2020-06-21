package com.grupyedi.webservice.other;

/**
 * Keeping movie ratings with 6 values. (5 star rating system.)
 */
public enum Rating {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE;
    public int getVal(){
        switch(this){
            case ZERO:
                return 0;
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            default:
                throw new AssertionError("Unknown rating value " + this);
        }
    }
}
