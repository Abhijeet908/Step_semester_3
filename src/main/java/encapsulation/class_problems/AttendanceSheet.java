package encapsulation.class_problems;

/**
 * Practice Problem 5: The Attendance Sheet.
 * Student names remain private; only count and yes/no lookup are exposed.
 */
public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        if (maxClassSize < 0) {
            throw new IllegalArgumentException("Class size cannot be negative");
        }
        presentStudents = new String[maxClassSize];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name) || presentCount == presentStudents.length) {
            return;
        }
        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
