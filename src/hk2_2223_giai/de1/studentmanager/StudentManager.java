package hk2_2223_giai.de1.studentmanager;

import java.util.Collections;
import java.util.Comparator;
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
     * Sắp xếp danh sách sinh viên theo thứ tự năm sinh tăng dần.
     * @return
     */
    public List<Student> sortYearOfBirthIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort(Comparator.comparingInt(Student::getYearOfBirth));
        return newList;
    }

    /**
     * Sắp xếp sinh viên theo thứ tự năm sinh giảm dần.
     * @return
     */
    public List<Student> sortYearOfBirthDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> right.getYearOfBirth() - left.getYearOfBirth());
        return newList;
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
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý tăng dần.
     * @return
     */
    public List<Student> sortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (left.getPhysicsGrade() > right.getPhysicsGrade()) {
                return 1;
            } else if (left.getPhysicsGrade() < right.getPhysicsGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý giảm dần.
     * @return
     */
    public List<Student> sortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (right.getPhysicsGrade() > left.getPhysicsGrade()) {
                return 1;
            } else if (right.getPhysicsGrade() < left.getPhysicsGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa tăng dần.
     * @return
     */
    public List<Student> sortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (left.getChemistryGrade() > right.getChemistryGrade()) {
                return 1;
            } else if (left.getChemistryGrade() < right.getChemistryGrade()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa giảm dần.
     * @return
     */
    public List<Student> sortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> newList = new LinkedList<>(this.studentList);
        newList.sort((left, right) -> {
            if (right.getChemistryGrade() > left.getChemistryGrade()) {
                return 1;
            } else if (right.getChemistryGrade() < left.getChemistryGrade()) {
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
     * Lọc ra howMany sinh viên có điểm lý cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestPhysicsGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortPhysicsGradeDecreasing();
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
     * Lọc ra howMany sinh viên có điểm lý thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestPhysicsGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortPhysicsGradeIncreasing();
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

    /**
     * Lọc ra howMany sinh viên có điểm hóa cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestChemistryGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortChemistryGradeDecreasing();
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
     * Lọc ra howMany sinh viên có điểm hóa thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestChemistryGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortChemistryGradeIncreasing();
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
