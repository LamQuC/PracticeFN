package practice_Mid.HK2223.d2hk2giai.myiterator;

public class Student implements Comparable<Student>{
    private String name;
    private String lastname;
    private double average;

    public Student(String name, String lastname, double average) {
        this.name = name;
        this.lastname = lastname;
        this.average = average;
    }

    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public double getAverage() { return average; }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setAverage(double average) { this.average = average; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return name.equals(s.name)
                && lastname.equals(s.lastname)
                && Double.compare(average, s.average) == 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode()*31 + lastname.hashCode();
    }

    @Override
    public String toString() {
        return lastname + " " + name + " (" + average + ")";
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.average, o.average);
    }
}