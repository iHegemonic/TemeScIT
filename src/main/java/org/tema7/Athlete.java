package org.tema7;

import java.time.Duration;
import java.util.List;

public class Athlete implements Comparable<Athlete> {
    private int number;
    private String name;
    private String countryCode;
    private Duration skiTime;
    private List<ShootingRange> shootingRanges;
    private Duration totalTime;

    public Athlete(int number, String name, String countryCode, Duration skiTime, List<ShootingRange> shootingRanges) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTime = skiTime;
        this.shootingRanges = shootingRanges;
        calculateTotalTime();
    }

    public int getNumber() {
        return number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    private void calculateTotalTime() {
        int totalMisses = 0;

        for (int i = 0; i < shootingRanges.size(); i++) {
            ShootingRange range = shootingRanges.get(i);
            totalMisses += range.countMisses();
        }

        int penaltySeconds = totalMisses * 10;
        this.totalTime = skiTime.plusSeconds(penaltySeconds);

    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public String getName() {
        return name;
    }

    public String formatResult() {
        long minutes = totalTime.toMinutes();
        long seconds = totalTime.toSecondsPart();
        long skiMinutes = skiTime.toMinutes();
        long skiSeconds = skiTime.toSecondsPart();
        int penalty = (int)(totalTime.getSeconds() - skiTime.getSeconds()); // Calculate penalty time

        return String.format("%s %02d:%02d (%02d:%02d + %d)",
                name,
                minutes,
                seconds,
                skiMinutes,
                skiSeconds,
                penalty);
    }

    @Override
    public String toString() {
        return formatResult();
    }

    @Override
    public int compareTo(Athlete other) {
        return this.totalTime.compareTo(other.totalTime);
    }
}
