package Modul_1_3;

import java.io.File;
import java.io.IOException;

public class CanonicalPath {
    public static void main(String[] args) throws IOException {
        File a1 = new File("a\\.\\b\\..\\c\\.\\file.txt");
        System.out.println(a1.getCanonicalPath());
    }
}
