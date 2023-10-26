public class Student {
    private String first_name = "";
    private String middle_name = "";
    private String last_name = "";
    private String suffix = "";

    // Getters
    public String getFirstName() {
        return first_name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getSuffix() {
        return suffix;
    }

    // Setters
    public void setFirstName(String fName) {
        first_name = fName;
    }

    public void setMiddleName(String mName) {
        middle_name = mName;
    }

    public void setLastName(String lName) {
        last_name = lName;
    }

    public void setSuffix(String suff) {
        suffix = suff;
    }

    // Custom Methods/Computed Properties
    public String getFullName() {
        return first_name + " " + middle_name + " " + last_name + " " + suffix;
    }
}
