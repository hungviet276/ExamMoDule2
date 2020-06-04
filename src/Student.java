public class Student {
    private String fullName;
    private int phoneNumber;
    private String group;
    private String gender;
    private String address;
    private String mail;
    private int yearOfBirth;

    public Student(String fullName, int phoneNumber, String group, String gender, String address, String mail, int yearOfBirth) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
        this.yearOfBirth = yearOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
