package org.example;

public class Turner {
    public static String src = null;

    public static boolean exist() {
        return src != null;
    }

    public static String reverse(String src) {
        char[] chars1 = src.toCharArray();
        char[] chars2 = new char[chars1.length];
        for (int i = 0; i < chars1.length; i++) {
            chars2[i] = chars1[chars1.length - 1 - i];
        }
        return new String(chars2);
    }

    public static String reverse(String src, String dest) {
        char[] chars1 = src.toCharArray();
        char[] chars2 = dest.toCharArray();
        for (int i = 0; i <= chars1.length - chars2.length; i++) {
            boolean match = true;
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i + j] != chars2[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.arraycopy(reverse(dest).toCharArray(), 0, chars1, i, chars2.length);
                return new String(chars1);
            }
        }
        return null;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        char[] chars1 = src.toCharArray();
        char[] chars2 = new char[lastIndex - firstIndex + 1];
        System.arraycopy(chars1, firstIndex, chars2, 0, chars2.length);
        System.arraycopy(reverse(new String(chars2)).toCharArray(), 0, chars1, firstIndex, chars2.length);
        return new String(chars1);
    }
}
