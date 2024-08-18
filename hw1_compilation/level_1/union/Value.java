public class Value {

    public static void main(String[] args) {
        Object o = new Object();

        byte b = Byte.MAX_VALUE;
        byte b1 = Byte.MIN_VALUE;
        short s = Short.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        long l = Long.MAX_VALUE;

        o.print(String.valueOf(b));
        o.print(String.valueOf(b1));
        o.print(String.valueOf(s));
        o.print(String.valueOf(i));
        o.print(String.valueOf(l));
    }
}
