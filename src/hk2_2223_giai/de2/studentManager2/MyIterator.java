package hk2_2223_giai.de2.studentManager2;
public interface MyIterator {
    /**
     * Kiểm tra xem danh sách có còn phần tử tiếp theo không.
     * @return true nếu còn, false nếu không còn.
     */
    boolean hasNext();

    /**
     * iterator dịch chuyển sang phần tử kế tiếp của dánh sách và trả ra phần tử hiện tại.
     * @return
     */
    Object next();

    /**
     * Xóa phần tử hiện tại của danh sách.
     */
    void remove();
}
