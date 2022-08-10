/* https://betacode.net/13525/java-outputstreamwriter
* заменил кодировку на US_ASCII */
//
package Modul_1_3.CharacterStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriter_UTF16_Ex_1 {
    private static final String filePath = "/Volumes/Data/test/utf16-file-out.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(" --- Write UTF-16 File --- ");
        write_UTF16_Character_Stream();

        System.out.println(" --- Read File as Binary Stream --- ");
        readAs_Binary_Stream();
    }

    private static void write_UTF16_Character_Stream() throws IOException   {
        File outFile = new File(filePath);
        outFile.getParentFile().mkdirs(); // Create parent folder.

        // Create OutputStream to write a file.
        OutputStream os = new FileOutputStream(outFile);

        // Create a OutputStreamWriter
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.US_ASCII);

        String s = "Ы";
        osw.write(s);
        osw.close();
    }

    private static void readAs_Binary_Stream() throws IOException {
        InputStream is = new FileInputStream(filePath);

        int byteValue;
        while ((byteValue = is.read()) != -1) { // Read byte by byte.
            System.out.println((char) byteValue + "  " + byteValue);
        }
        is.close();
    }
}
