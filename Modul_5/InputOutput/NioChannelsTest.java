package Modul_5.InputOutput;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioChannelsTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/org/stepic/java/io/NioChannelsTest.java");

        try (ReadableByteChannel in = FileChannel.open(path);
             WritableByteChannel out = Channels.newChannel(System.out)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                out.write(buffer);
                buffer.compact();
            }
        }

//        try (InputStream in = Files.newInputStream(path);
//             OutputStream out = System.out) {
//            byte[] buffer = new byte [1024];
//            int bytesRead;
//            while ((bytesRead = in.read(buffer)) > 0) {
//                out.write(buffer, 0, bytesRead);
//            }
//        }
    }
}
