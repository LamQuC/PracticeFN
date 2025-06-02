package practice_Mid.HK2122giai.number;

public class Number {
    private long serialVersioUID;
    public Number(){}
    public byte byValue(){
        return (byte) serialVersioUID;
    }
    public double doubleValue(){
        return (long)serialVersioUID;
    }
    public float floatValue(){
        return (float)serialVersioUID;
    }
    public int intValue(){
        return (int)serialVersioUID;
    }
    public long longValue(){
        return serialVersioUID;
    }
    public short shortValue(){
        return (short) serialVersioUID;
    }
}
