package practice_Mid.HK2223.d2hk2giai.vector;

public interface MyVector {
    double coordinate(int i);        // lấy tọa độ tại vị trí i
    double[] coordinates();          // trả về toàn bộ tọa độ
    boolean equals(MyVector v);       // kiểm tra 2 vector bằng nhau
    double norm();                    // độ dài vector
    void set(double d, int i);         // gán giá trị d vào vị trí i
    int size();                       // kích thước vector
}