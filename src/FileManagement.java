import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {
    Scanner sc = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    File file;

    public FileManagement() {
//        Path filePath= Paths.get(System.getProperty("user.dir"),"files","users.xml");
        String filePath = "data/contacts.csv";
        file = new File(filePath);
    }

    public void writeFile(ArrayList<Student> arrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < arrayList.size(); i++) {
            fileWriter.append(arrayList.get(i).getFullName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(arrayList.get(i).getPhoneNumber()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(arrayList.get(i).getGroup());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(arrayList.get(i).getGender());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(arrayList.get(i).getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(arrayList.get(i).getMail());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(arrayList.get(i).getYearOfBirth()));
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Luu thanh cong");

    }

    public ArrayList<Student> readFile(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            students.remove(i);
        }
        try {

            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(COMMA_DELIMITER);
                String fullName = splitData[0];
                int phoneNumber = Integer.parseInt(splitData[1]);
                String group = splitData[2];
                String gender = splitData[3];
                String address = splitData[4];
                String mail = splitData[5];
                int yearOfBirth = Integer.parseInt(splitData[6]);
                students.add(new Student(fullName, phoneNumber, group, gender, address, mail, yearOfBirth));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

}

