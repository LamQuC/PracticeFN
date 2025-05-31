package hk1_2324_giai.fraction;

public class FractionTestDrive {
    public static void main(String[] args) {
//        /*
//        TODO:
//        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
//        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
//           Lưu các phân số vào trong một tập dữ liệu DataSet, được gọi là dataSet.
//        */
        int numbers = (int) (Math.random() * 21 + 30);
        Fraction[] fractions = new Fraction[numbers];
        for (int i = 0; i < numbers; i++) {
            int numerator = (int) (Math.random() * 100 + 1);
            int denominator = (int) (Math.random() * 100 + 1);
            fractions[i] = new Fraction(numerator, denominator);
        }

        DataSet dataSet = new DataSet(fractions);
//        /*
//        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
//             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
//               có giá trị tăng dần của mẫu số.
//             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
//               có giá trị giảm dần của mẫu số.
//        */
        Fraction[] increasingFractions = dataSet.sortIncreasing();
        System.out.println("Fractions in increasing order:");
        DataSet.printFractions(increasingFractions);
        Fraction[] decreasingFractions = dataSet.sortDecreasing();
        System.out.println("Fractions in decreasing order:");
        DataSet.printFractions(decreasingFractions);
//        /*
//         4. In ra các dữ liệu sau:
//             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
//             - In ra các phân số tối giản theo thứ tự tăng dần.
//             - In ra các phân số tối giản theo thứ tự giảm dần.
//        */
        System.out.println("Simplified fractions:");
        System.out.println(dataSet.toSimplify());

        System.out.println("Simplified fractions in increasing order:");
        System.out.println(new DataSet(dataSet.sortIncreasing()).toSimplify());

        System.out.println("Simplified fractions in decreasing order:");
        System.out.println(new DataSet(dataSet.sortDecreasing()).toSimplify());
//        /*
//         5. - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
//              là <TenSinhVien_MaSinhVien_Fraction>.txt (Ví dụ, NguyenVanA_123456_Fraction.txt).
//            - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
//              <TenSinhVien_MaSinhVien_Fraction>.zip (Ví dụ, NguyenVanA_123456_Fraction.zip),
//              nộp lên classroom.
//         */
//
   }
}
