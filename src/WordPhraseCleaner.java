import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordPhraseCleaner {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\adminn\\Desktop\\test.txt";  // 替换为你的输入文件路径
        String outputFilePath = "C:\\Users\\adminn\\Desktop\\test_out.txt"; // 替换为你的输出文件路径

        // 规定要删除的词语
        Set<String> wordsToRemove = new HashSet<>(Arrays.asList("n.", "v.", "a.", "ad.",";",",","(",")","，","、","]","[","“","”"));

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                // 去除中文字符
                String cleanedLine = line.replaceAll("[\\u4e00-\\u9fa5]", "").trim();

                // 移除规定词语
                for (String word : wordsToRemove) {
                    cleanedLine = cleanedLine.replace(word, "").trim();
                }

                // 写入到输出文件
                if (!cleanedLine.isEmpty()) {
                    writer.write(cleanedLine + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}