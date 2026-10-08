package encapsulation.class_problems;

/**
 * Practice Problem 4: The Locker Code.
 * The combination is write-only from outside: it can be changed only
 * after the current code is verified, and there is no getter.
 */
public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}
