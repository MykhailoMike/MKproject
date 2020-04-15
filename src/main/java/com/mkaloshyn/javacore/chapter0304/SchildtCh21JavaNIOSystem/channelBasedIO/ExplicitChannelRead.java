package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.channelBasedIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        /*Path filepath = null;
        filepath = Paths.get("test.txt");*/

        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))) {
            ByteBuffer mbuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mbuf);
                if (count != -1) {
                    mbuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mbuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
