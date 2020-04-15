package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.channelBasedIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test3.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {
            ByteBuffer buf = ByteBuffer.allocate(26);
           // for (int h = 0; h < 3; h++) {
                for (int i = 0; i < 26; i++) {
                    buf.put((byte) ('A' + i));
                }
                buf.rewind();
                fChan.write(buf);
               // buf.rewind();
           // }
        }catch (
                InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
            System.exit(1);
        }
    }
}
