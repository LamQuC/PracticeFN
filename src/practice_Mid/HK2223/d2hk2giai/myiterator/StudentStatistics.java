package practice_Mid.HK2223.d2hk2giai.myiterator;

public class StudentStatistics {
    private MyList students;

    public StudentStatistics(MyList students) {
        this.students = students;
    }

    /** Trả về list mới đã sort theo điểm trung bình (tăng hoặc giảm) */
    public MyList sortByAverage(boolean ascending) {
        // Ví dụ: simple bubble-sort dùng get/insert của MyList
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                Student s1 = (Student) students.get(j);
                Student s2 = (Student) students.get(j + 1);
                if ((ascending && s1.getAverage() > s2.getAverage())
                        || (!ascending && s1.getAverage() < s2.getAverage())) {
                    // hoán đổi
                    Object tmp = students.get(j);
                    students.set(students.get(j + 1), j);
                    students.set(tmp, j + 1);
                }
            }
        }
        return students;
    }

    /** Trả về list mới đã sort fullName (lastname + name) */
    public MyList sortByFullname(boolean ascending) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                Student s1 = (Student) students.get(j);
                Student s2 = (Student) students.get(j + 1);
                int cmp = (s1.getLastname() + s1.getName())
                        .compareTo(s2.getLastname() + s2.getName());
                if ((ascending && cmp > 0) || (!ascending && cmp < 0)) {
                    Object tmp = students.get(j);
                    students.set(students.get(j + 1), j);
                    students.set(tmp, j + 1);
                }
            }
        }
        return students;
    }
}
