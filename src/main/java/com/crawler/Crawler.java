package com.crawler;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

public class Crawler {
    public static void main(String[] args) {
        String url = "https://ai-bot.cn/";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Links");

        // 创建表头
        Row headerRow = sheet.createRow(0);
        String[] headers = {"栏目", "网址"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        try {
            // 连接到目标网站并获取 HTML 文档
            Document doc = Jsoup.connect(url).get();

            // 查找所有的链接
            Elements links = doc.select("a[href]");

            int rowNum = 1;
            // 遍历所有链接并将栏目和网址写入 Excel
            for (Element link : links) {
                String title = link.text();
                String href = link.attr("abs:href");

                Row row = sheet.createRow(rowNum++);
                Cell titleCell = row.createCell(0);
                titleCell.setCellValue(title);
                Cell hrefCell = row.createCell(1);
                hrefCell.setCellValue(href);
            }

            // 自动调整列宽
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // 保存 Excel 文件
            try (FileOutputStream fileOut = new FileOutputStream("links.xlsx")) {
                workbook.write(fileOut);
            }
            System.out.println("数据已成功导出到 links.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}