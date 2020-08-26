import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Option2 {
    public static void main(String[] args) {
        List<String> list;
        String fileName = "text.txt";
        Path path = Paths.get(fileName);
        String content = "Info ";
        String i = "";
        Stream<String> stream;

        try {
            if (Files.exists(path)) {
                System.out.println("File exists.");

                stream = Files.lines(path);
                list = stream.collect(Collectors.toList());
                i = list.get(list.size() - 1).split(" ")[1];

                Files.write(path, (content + "" + (Integer.parseInt(i) + 1) + "\n").getBytes(), StandardOpenOption.APPEND);

                printFile(path);
            } else {
                System.out.println("File created.");
                Files.createFile(Path.of(fileName));
                Files.write(path, ("Initial Info\nInfo 1\n").getBytes());

                printFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(Path path) throws IOException {
        Stream<String> stream;
        stream = Files.lines(path);
        stream.forEach(System.out::println);
    }
}
