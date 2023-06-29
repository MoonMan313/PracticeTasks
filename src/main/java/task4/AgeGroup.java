package task4;

public enum AgeGroup {
    GROUP1(0, 17),
    GROUP2(18, 25),
    GROUP3(26, 39),
    GROUP4(40, 59),
    GROUP5(60, 100);

    AgeGroup(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    private final int lowerLimit;
    private final int upperLimit;

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }


    @Override
    public String toString() {
        return (name() + " возраст от " + lowerLimit +
                " до " + upperLimit + " лет");
    }
}
