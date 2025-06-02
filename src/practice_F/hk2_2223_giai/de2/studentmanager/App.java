package practice_F.hk2_2223_giai.de2.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student newStudent = new Student.
                        StudentBuilder(dataList.get(0)).
                        withLastname(dataList.get(1)).
                        withFirstname(dataList.get(2)).
                        withYearOfBirth(Integer.parseInt(dataList.get(3))).
                        withMathsGrade(Double.parseDouble(dataList.get(4))).
                        withPhysicsGrade(Double.parseDouble(dataList.get(5))).
                        withChemistryGrade(Double.parseDouble(dataList.get(6))).
                        build();
                StudentManager.getInstance().append(newStudent);
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
        testOriginalData();
        System.out.println();
        testSortYearOfBirthIncreasing();
        System.out.println();
        testSortYearOfBirthDecreasing();
        System.out.println();
        testSortChemistryGradeIncreasing();
        System.out.println();
        testSortChemistryGradeDecreasing();
        System.out.println();
        testSortPhysicsGradeIncreasing();
        System.out.println();
        testSortPhysicsGradeDecreasing();
        System.out.println();
        testSortMathsGradeIncreasing();
        System.out.println();
        testSortMathsGradeDecreasing();
        System.out.println();
        testFilterStudentsLowestMathsGrade();
        System.out.println();
        testFilterStudentsHighestMathsGrade();
        System.out.println();
        testFilterStudentsLowestPhysicsGrade();
        System.out.println();
        testFilterStudentsHighestPhysicsGrade();
        System.out.println();
        testFilterStudentsLowestChemistryGrade();
        System.out.println();
        testFilterStudentsHighestChemistryGrade();
        System.out.println();
        testFilterStudentsLowestAverageGrade();
        System.out.println();
        testFilterStudentsHighestAverageGrade();
    }

    public static void init() {
        String filePath = "E:\\Code\\JAVAWORK\\OOP\\ThiCuoiKy\\src\\hk2_2223_giai\\de2\\studentmanager\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        String codeString = StudentManager.getInstance().idOfStudentsToString(nLowestMathsGradeStudents);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestPhysicsGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestPhysicsGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestChemistryGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestChemistryGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestAverageGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestAverageGrade(5);
        String codeString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(codeString);
    }
}
