

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Tao arrayList luu thong tin
        ArrayList<Student> listStudent = new ArrayList<>();
        FileManagement fileManagement = new FileManagement();

        DisplayMenu.displayMenu();

        StudentManager studentManager = new StudentManager();
        while (true) {
            System.out.println("Chon chuc nang: ");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    studentManager.displayList(listStudent);
                    break;
                case 2:
                    studentManager.addStudent(listStudent);
                    break;
                case 3:
                    System.out.println("Moi ban nhap so dien thoai: ");
                    int phone = sc.nextInt();
                    studentManager.editStudent(phone, listStudent);
                    break;
                case 4:
                    System.out.println("Moi ban nhap so dien thoai: ");
                    int phoneDelete = sc.nextInt();
                    studentManager.delete(phoneDelete, listStudent);
                    break;
                case 5:
                    studentManager.search(listStudent);
                    break;
                case 6:
                    fileManagement.writeFile(listStudent);
                    break;
                case 7:
                    fileManagement.readFile(listStudent);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }

    }
}
