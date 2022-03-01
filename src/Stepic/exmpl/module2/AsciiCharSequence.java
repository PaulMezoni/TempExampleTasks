package Stepic.exmpl.module2;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] data;

    public AsciiCharSequence(byte[] data) {
        this.data = data;
    }

    @Override
    public int length() {
        return data.length;
    }

    @Override
    public char charAt(int index) {
        return (char) data[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(data, start, end));
    }

    @Override
    public String toString() {
        return new String(data);
    }
}
