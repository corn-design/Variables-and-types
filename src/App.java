import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
   public static void main(String[] args) {
        // 定义输入文件和输出文件的路径
        
        String inputFilePath = "D:\\作业\\introduction2025\\PROG-2-2025\\ex11\\Groceries.txt"; // 绝对路径
        String outputFilePath = "FormattedGroceries.txt";

        // 用于存储从文件中读取的每一行数据
        List<String> lines = new ArrayList<>();

        // 读取 Groceries.txt 文件
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // 格式化数据并写入 FormattedGroceries.txt 文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            // 写入表头
            writer.write("ID\tItem\tQuantity (KG)\tPrice (€)");
            writer.newLine();
            writer.write("***************************************************************");
            writer.newLine();

            double totalCost = 0.0;

            // 遍历每一行数据并格式化
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String item = parts[1].trim();
                    String quantity = parts[2].trim().replace("KG", ""); // 去掉 "KG"
                    double price = Double.parseDouble(parts[3].trim());

                    // 计算总价
                    totalCost += price;

                    // 格式化并写入文件
                    writer.write(String.format("| %-3s | %-10s | %-10s | %-6.2f |", id, item, quantity, price));
                    writer.newLine();
                }
            }

            // 写入总价
            writer.write("***************************************************************");
            writer.newLine();
            writer.write(String.format("The grocery shopping total is: €%.2f", totalCost));
            writer.newLine();
            writer.write("***************************************************************");

            System.out.println("Formatted groceries have been written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
