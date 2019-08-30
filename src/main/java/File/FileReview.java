package File;

import java.io.*;

public class FileReview {
    public static void main(String[] args) throws IOException {
        TXTWriter();
        TxtReader();
    }

    public static void TXTWriter() throws IOException {
        File file = new File("D://Hello.txt");
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("123\n");
        bufferedWriter.write("test");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void TxtReader() throws IOException {
        File file = new File("D://Hello.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line = bufferedReader.readLine();
        stringBuffer.append(line);
        while (line!=null) {
            line=bufferedReader.readLine();
            if (line != null) {
                stringBuffer.append(line);
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
