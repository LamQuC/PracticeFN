package practice_F.hk2_2223_giai.de2.studentManager2;
public interface MyList extends MyIterable {
    /**
     * Lấy kích thước của list.
     * @return
     */
    int size();

    /**
     * Lấy phần tử ở vị trí index.
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * Thêm phần tử có dữ liệu payload váo cuối list.
     * @param payload
     */
    void append(Object payload);

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * @param payload
     * @param index
     */
    void insert(Object payload, int index);

    /**
     * Xóa phần tử ở vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Đặt lại dữ liệu payload cho phần tử list ở vị trí index.
     * @param payload
     * @param index
     */
    void set(Object payload, int index);
}
