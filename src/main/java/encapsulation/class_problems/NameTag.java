package encapsulation.class_problems;

/**
 * Practice Problem 3: The Nickname Tag.
 * Name parts are final, so the object is immutable after construction.
 */
public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Full name must contain first and last name");
        }

        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
