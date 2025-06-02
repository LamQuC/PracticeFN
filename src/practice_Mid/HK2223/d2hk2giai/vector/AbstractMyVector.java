package practice_Mid.HK2223.d2hk2giai.vector;

import java.util.Arrays;

public abstract class AbstractMyVector implements MyVector {

    public AbstractMyVector() {
    }

    @Override
    public boolean equals(MyVector v) {
        if (v == null || this.size() != v.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (this.coordinate(i) != v.coordinate(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.coordinates());
    }
}

