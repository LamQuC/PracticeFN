package practice_F.hk2_2223_giai.de2.studentManager2;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        studentList = new LinkedList<>();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        this.studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        this.studentList.add(index, student);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        this.studentList.remove(student);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return this.studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * @return
     */
    public List<Student> sortMathsGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (left.getMathsGrade() > right.getMathsGrade()) {
                return 1;
            } else if (left.getMathsGrade() < right.getMathsGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public List<Student> sortMathsGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (right.getMathsGrade() > left.getMathsGrade()) {
                return 1;
            } else if (right.getMathsGrade() < left.getMathsGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public List<Student> sortAverageGradeIncreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (left.getAverageGrade() > right.getAverageGrade()) {
                return 1;
            } else if (left.getAverageGrade() < right.getAverageGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public List<Student> sortAverageGradeDecreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (right.getAverageGrade() > left.getAverageGrade()) {
                return 1;
            } else if (right.getAverageGrade() < left.getAverageGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortMathsGradeDecreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortMathsGradeIncreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    public List<Student> filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortAverageGradeDecreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    public List<Student> filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortAverageGradeIncreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    public static String idOfStudentsToString(List<Student> countryList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student country : countryList) {
            idOfStudents.append(country.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
