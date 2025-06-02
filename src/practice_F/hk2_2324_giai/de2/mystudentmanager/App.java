package practice_F.hk2_2324_giai.de2.mystudentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();
        System.out.println("=== Original Student Data ===");
        testOriginalData();

        System.out.println("\n=== Students with Average Grade > 15 ===");
        testFilterStudentsByAverageGrade();

        System.out.println("\n=== Students with Maths Grade > 5 ===");
        testFilterStudentsByMathGrade();
        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "E:\\Code\\JAVAWORK\\OOP\\ThiCuoiKy\\src\\hk2_2324_giai\\de2\\mystudentmanager\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        /* TODO */
        StudentManager manager = StudentManager.getInstance();
        MyIterator it = manager.getStudentList().iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            printStudent(s);
        }
    }

    public static void testFilterStudentsByAverageGrade() {
        /* TODO */
        StudentManager manager = StudentManager.getInstance();
        MyList filtered = manager.filterStudentsByAverageGrade();
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            printStudent(s);
        }
    }

    public static void testFilterStudentsByMathGrade() {
        /* TODO */
        StudentManager manager = StudentManager.getInstance();
        MyList filtered = manager.filterStudentsByMathGrade();
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            printStudent(s);
        }
    }
    public static void printStudent(Student s) {
        System.out.printf("ID: %s, Name: %s %s, YOB: %d, Maths: %.2f, Physics: %.2f, Chemistry: %.2f, Avg: %.2f%n",
                s.getId(),
                s.getLastname(),
                s.getFirstname(),
                s.getYearOfBirth(),
                s.getMathsGrade(),
                s.getPhysicsGrade(),
                s.getChemistryGrade(),
                s.getAverageGrade());
    }
}
