package org.tema7;

public enum ShotsResult {
    HIT, MISS;

    public static ShotsResult fromChar(char c) {
        return c == 'x' ? HIT : MISS;
    }
}

