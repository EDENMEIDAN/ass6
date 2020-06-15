package settings;

/**
 * gameSettings.Counter is a class that is used for counting things.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */
public class Counter {
    private int value;

    /**
     * construct a counter from an initial value.
     *
     * @param initialValue the given initial value.
     */
    public Counter(int initialValue) {
        this.value = initialValue;
    }

    /**
     * construct a counter -- default.
     */
    public Counter() {
        this.value = 0;
    }

    /**
     * this method adds number to current count.
     *
     * @param number the given number.
     */
    public void increase(int number) {
        this.value += number;
    }

    /**
     * this method subtract number from current count.
     *
     * @param number the given number.
     */
    void decrease(int number) {
        this.value -= number;
    }

    /**
     * this method returns the current value of the counter.
     *
     * @return the current value of the counter.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * this method re-sets the counter value.
     *
     * @param ourValue is the current counter value.
     */
    public void setValue(int ourValue) {
        this.value = ourValue;
    }
}