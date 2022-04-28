import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
    @Test
    void testReadFile2() throws IOException {
        String fileName = "C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\spider\\label_cloud.txt";

        // 读取文件内容到Stream流中，按行读取
        Stream<String> lines = Files.lines(Paths.get(fileName));

        // 随机行顺序进行数据处理
        lines.forEach(ele -> {
            System.out.println("==>"+ele);
        });
    }


    @Test
    void testReadFile6() throws IOException {
        String fileName = "C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\spider\\label_cloud.txt";
        // 带缓冲的流读取，默认缓冲区8k
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        System.out.println("----------------------------------");

        //java 8中这样写也可以
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

    }


}
