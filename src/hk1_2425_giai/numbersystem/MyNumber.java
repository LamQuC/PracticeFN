package hk1_2425_giai.numbersystem;

import java.util.List;
import java.util.ArrayList;
public class MyNumber {
    private String numberPresentation;  // Biểu diễn số ban đầu
    private int radix;                  // Cơ số của số ban đầu
    private List<NumberConverter> converters;  // Danh sách các converter theo observer pattern

    public MyNumber(String originalNumber, int radix) {
        /* TODO */
        this.numberPresentation = originalNumber;
        this.radix = radix;
        this.converters = new ArrayList<>();
    }

    /*
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void addConverter(NumberConverter converter) {
        /* TODO */
        converters.add(converter);
    }

    /*
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void removeConverter(NumberConverter converter) {
        /* TODO */
        converters.remove(converter);
    }

    /*
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        /* TODO */
        for (NumberConverter converter : converters) {
            converter.update();
        }
    }

    public String getNumberPresentation() {
        /* TODO */
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        /* TODO */
        this.numberPresentation = numberPresentation;
        onStateChanged();
    }

    public int getRadix() {
        /* TODO */
        return radix;
    }

    public void setRadix(int radix) {
        /* TODO */
        this.radix = radix;
        onStateChanged();
    }

    public void setNumber(String numberPresentation, int radix) {
        /* TODO */
        this.numberPresentation = numberPresentation;
        this.radix = radix;
        onStateChanged();
    }

    /*
     * Hiện thị số ra terminal theo định dạng a1a2...an(radix)
     */
    public void display() {
        /* TODO */
        System.out.println("Original number: " + numberPresentation + "(" + radix + ")");
    }

    /*
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        /* TODO */
        notifyConverters();
    }
}