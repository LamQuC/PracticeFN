package practice_Mid.HK2324giai.de3hk2giai.giai.numbersystem;

public interface NumberConverter {
    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    void update();

    /**
     * Hiển thị số theo định dạng a1a2...an(radix).
     */
    void display();
}
