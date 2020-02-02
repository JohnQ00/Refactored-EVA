package tests;

public class Tests extends Lessons {
    private float testPoints[] = new float[5];
    private int testNumber;
    private int index;

    public float[] getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(float testPoints, int index) {
        this.testPoints[index] = testPoints;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }
}
