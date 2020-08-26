import java.io.*;

public class Option1 {
    public static void main(String[] args) {

        String fileName = "text.txt";
        String tmp;
        String i = "";
        try {
            if (!new File(fileName).exists()) {
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName));
                outputStream.writeBytes("Initial info\n");
                outputStream.writeBytes("Info 1\n");
                System.out.println("File created.");
                printFile(fileName);
            } else {
                System.out.println("File exists.");

                DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName));
                while ((tmp = inputStream.readLine()) != null) {
                    i = tmp.split(" ")[1];
                }

                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName, true));
                outputStream.writeBytes("Info " + (Integer.parseInt(i) + 1) + "\n");

                printFile(fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(String fileName) throws IOException {
        String tmp;
        DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName));
        while ((tmp = inputStream.readLine()) != null) {
            System.out.println(tmp);
        }
    }
}
