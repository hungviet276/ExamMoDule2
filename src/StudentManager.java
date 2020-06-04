import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    Scanner sc = new Scanner(System.in);

    public void displayList(ArrayList<Student> arrayList) throws IOException {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("--------------------------------------");
            System.out.println("Full name: " + arrayList.get(i).getFullName());
            System.out.println("Phone number: " + arrayList.get(i).getPhoneNumber());
            System.out.println("Gender: " + arrayList.get(i).getGender());
            System.out.println("Group: " + arrayList.get(i).getGroup());
            System.out.println("Address: " + arrayList.get(i).getAddress());
            System.out.println("--------------------------------------");
            String line = sc.nextLine();
        }
        DisplayMenu.displayMenu();
    }

    public void addStudent(ArrayList<Student> arrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Full name: ");
        String fullName = sc.nextLine();
        System.out.println("Phone Number: ");
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Group: ");
        String group = sc.nextLine();
        System.out.println("Gender: ");
        String gender = sc.nextLine();
        System.out.println("Address: ");
        String address = sc.nextLine();
        System.out.println("mail: ");
        String mail = sc.nextLine();
        System.out.println("Year Of Birth: ");
        int yearOfBirth = sc.nextInt();
        System.out.println("--------------------------------------");
        String result = this.checkInformation(fullName, phoneNumber, group, gender, address, mail, yearOfBirth);
        if (result.equals("Luu thanh cong")) {
            System.out.println(result);
            Student student = new Student(fullName, phoneNumber, group, gender, address, mail, yearOfBirth);
            arrayList.add(student);
        } else {
            System.out.println(result);
            this.addStudent(arrayList);
        }
        DisplayMenu.displayMenu();

    }

    public String checkInformation(String fullName, int phoneNumber, String group, String gender, String address, String mail, int yearOfBirth) {
        String result = "";
        if (fullName.equals("") || group.equals("") || gender.equals("") || address.equals("") || yearOfBirth == 0) {
            result = "Khong bo trong thong tin";
        } else if (!CheckInfor.checkPhone(String.valueOf(phoneNumber))) {
            result = "Nhap sai dinh dang dien thoai";
        } else if (!CheckInfor.checkMail(mail)) {
            result = "Nhap sai dinh dang mail";
        } else {
            result = "Luu thanh cong";
        }
        return result;

    }

    public void editStudent(int phone, ArrayList<Student> arrayList) {
        if (this.checkPhone(phone, arrayList) != -1) {
            System.out.println("Tim thay so dien thoai, moi ban nhap thong tin");
            int index = this.checkPhone(phone, arrayList);
            System.out.println("Full name: ");
            String fullName = sc.nextLine();
            System.out.println("Phone Number: ");
            int phoneNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Group: ");
            String group = sc.nextLine();
            System.out.println("Gender: ");
            String gender = sc.nextLine();
            System.out.println("Address: ");
            String address = sc.nextLine();
            System.out.println("mail: ");
            String mail = sc.nextLine();
            System.out.println("Year Of Birth: ");
            int yearOfBirth = sc.nextInt();

            String result = this.checkInformation(fullName, phoneNumber, group, gender, address, mail, yearOfBirth);
            if (result.equals("Luu thanh cong")) {
                System.out.println("Cap nhat thanh cong");
                Student student = new Student(fullName, phoneNumber, group, gender, address, mail, yearOfBirth);
                arrayList.set(index, student);
            } else {
                System.out.println(result);
            }
            DisplayMenu.displayMenu();


        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            System.out.println("Ban nhap lai so dien thoai");
            int reCheckPhone = sc.nextInt();
            if (reCheckPhone != 0) {
                this.editStudent(reCheckPhone, arrayList);
            } else {
                DisplayMenu.displayMenu();
            }

        }
    }

    public void delete(int phone, ArrayList<Student> arrayList) {
        if (checkPhone(phone, arrayList) != -1) {
            System.out.println("Ban xac nhan muon xoa");
            String accept = sc.nextLine();
            if (accept.equals("Y")) {
                int index = checkPhone(phone, arrayList);
                System.out.println("Xoa thanh cong");
                arrayList.remove(index);
            } else DisplayMenu.displayMenu();

        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            System.out.println("Moi ban nhap lai so dien thoai");
            int rePhone = sc.nextInt();
            if (rePhone != 0) {
                delete(rePhone, arrayList);
            } else DisplayMenu.displayMenu();

        }

    }

    public int checkName(String name, ArrayList<Student> arrayList) {
        int indexName = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getFullName().equals(name)) {
                indexName = i;
                break;
            }
        }
        return indexName;
    }

    public void search(ArrayList<Student> arrayList) {
        System.out.println("Moi ban nhap chuc nang tim kiem: ");
        System.out.println("1.Tim theo so dien thoai ");
        System.out.println("2.Tim theo ten ");
        int chose = sc.nextInt();
        if (chose == 1) {
            System.out.println("Moi ban nhap vao so dien thoai");
            int phoneSearch = sc.nextInt();
            if (checkPhone(phoneSearch, arrayList) != -1) {
                int indexPhone = checkPhone(phoneSearch, arrayList);
                displayStudent(indexPhone, arrayList);
            } else System.out.println("Khong tim thay");
        } else if (chose == 2) {
            System.out.println("Moi ban nhap vao so dien thoai");
            String nameSearch = sc.nextLine();
            if (checkName(nameSearch, arrayList) != -1) {
                int indexName = checkName(nameSearch, arrayList);
                displayStudent(indexName, arrayList);
            } else System.out.println("Khong tim thay");
        }
    }

    public int checkPhone(int phoneNumber, ArrayList<Student> arrayList) {
        int indexPhone = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPhoneNumber() == phoneNumber) {
                indexPhone = i;
                break;
            }
        }
        return indexPhone;
    }

    public void displayStudent(int index, ArrayList<Student> arrayList) {

        System.out.println("--------------------------------------");
        System.out.println("Full name: " + arrayList.get(index).getFullName());
        System.out.println("Phone number: " + arrayList.get(index).getPhoneNumber());
        System.out.println("Gender: " + arrayList.get(index).getGender());
        System.out.println("Group: " + arrayList.get(index).getGroup());
        System.out.println("Address: " + arrayList.get(index).getAddress());
        System.out.println("--------------------------------------");
        String line = sc.nextLine();

        DisplayMenu.displayMenu();
    }

}
