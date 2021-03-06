package org.springframework.core.io;

import java.io.IOException;

/**
 * @author zxin
 */
public class ResourceTest {

    public static void main(String[] args) {
        try {
            FileSystemResource resource = new FileSystemResource("E:/data/applogs/cat/cat_20201222.log");
            System.out.println(resource.contentLength());
            UrlResource urlResource = new UrlResource("https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html");
            System.out.println(urlResource.contentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
