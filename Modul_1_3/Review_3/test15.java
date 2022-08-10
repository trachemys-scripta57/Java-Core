package Modul_1_3.Review_3;

import java.io.IOException;

public class test15 {
    public static void main(String[] args) {
        try (SomeResource1 r = new SomeResource1()) {
            throw new RuntimeException("RuntimeException");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class SomeResource1 implements java.io.Closeable {
    public void close() throws IOException {
        throw new IOException("Close Exception");
    }
}
