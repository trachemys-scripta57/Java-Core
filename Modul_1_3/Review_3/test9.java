package Modul_1_3.Review_3;

import java.io.IOException;

public class test9 {
    public static void main(String[] args) {
        try (SomeResource r = new SomeResource()) {
            throw new RuntimeException("RuntimeException");
        } catch (IOException e) {
            System.out.println("In the catch block");
        }
    }
}

class SomeResource implements java.io.Closeable {
    public void close() throws IOException {
        System.out.print("Closing resource ");
        throw new IOException("Close Exception");
    }
}
