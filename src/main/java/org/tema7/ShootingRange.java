package org.tema7;

import java.util.ArrayList;
import java.util.List;

public class ShootingRange {

    private List<ShotsResult> shots;

    public ShootingRange(String data) {
        this.shots = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            ShotsResult result = ShotsResult.fromChar(c);
            shots.add(result);
        }
    }

    public int countMisses() {
        int missCount = 0;
        for (ShotsResult result : shots) {
            if (result == ShotsResult.MISS) {
                missCount++;
            }
        }
        return missCount;
    }

}
