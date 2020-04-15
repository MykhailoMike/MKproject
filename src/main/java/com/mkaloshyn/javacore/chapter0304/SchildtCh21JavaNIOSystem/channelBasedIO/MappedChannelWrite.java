package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.channelBasedIO;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test4.txt"), StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            MappedByteBuffer mbuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++) {
                mbuf.put((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
