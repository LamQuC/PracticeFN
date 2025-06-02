package practice_Mid.HK2425giai.de1hk1giai.datastructure;


public class App {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_DataStructure>.txt (Ví dụ, NguyenVanA_123456_DataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_DataStructure>.zip (Ví dụ, NguyenVanA_123456_DataStructure.zip),
          nộp lên classroom.
        */

    }

    public static void testStack() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        int n = 15 + (int) (Math.random() * (15 + 1));
        MyStack myStack = new MyStack();
        for (int i = 0; i < n; i++) {
            myStack.push((int) (Math.random() * (100 + 1)));
        }
        System.out.println(myStack.toString());
        for (int i = 0; i < n; i++) {
            myStack.pop();
            System.out.println(myStack);
        }
    }

    public static void testQueue() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ra n số nguyên ngẫu nhiên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */
        int n = 20 + (int) (Math.random() * 11);
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < n; i++) {
            myQueue.add((int) (Math.random() * (100 + 1)));
        }
        System.out.println(myQueue.toString());
        for (int i = 0; i < n - 1; i++) {
            myQueue.remove();
            System.out.println(myQueue);
        }
    }
}
