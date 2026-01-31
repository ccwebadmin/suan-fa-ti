package com.util;

/**
 *
 * @author cc
 * @date 2026年01月12日 15:53
 * @return
 */
import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试1
 * Hutool 超大Excel导出（几百万条数据，拆分多Sheet）
 */
public class BigExcelExportDemo {
    // 单Sheet最大行号（.xlsx格式，预留1行作为表头）
    private static final int MAX_SHEET_ROWS = 1048575;
    // 每批查询/写入的数据量（根据JVM内存调整，建议1万-5万条）
    private static final int BATCH_SIZE = 50000;
    // 导出文件根路径
    private static final String EXPORT_PATH = "D:/export/big_data_excel.xlsx";

    public static void main(String[] args) {
        // 确保导出目录存在
        File exportFile = new File(EXPORT_PATH);
        if (!exportFile.getParentFile().exists()) {
            exportFile.getParentFile().mkdirs();
        }
        // 如果文件已存在，先删除（避免空文件或损坏文件导致的问题）
        if (exportFile.exists()) {
            exportFile.delete();
        }

        // 1. 初始化BigExcelWriter（指定导出文件，默认.xlsx格式，支持流式写入）
        try (BigExcelWriter bigExcelWriter = ExcelUtil.getBigWriter(EXPORT_PATH)) {
            // 2. 设置Excel表头
            String[] headers = {"用户ID", "用户名", "手机号", "注册时间", "订单金额"};
            bigExcelWriter.writeHeadRow(CollUtil.newArrayList(headers));

            // 3. 模拟总数据量（几百万条，此处以300万条为例）
            long totalDataCount = 3000000L;
            // 计算需要的Sheet数量
            int sheetCount = (int) Math.ceil((double) totalDataCount / MAX_SHEET_ROWS);
            // 当前已写入的数据总量
            long writtenCount = 0L;
            // 当前Sheet已写入的行数
            int currentSheetRows = 1; // 表头占1行

            for (int sheetIndex = 0; sheetIndex < sheetCount; sheetIndex++) {
                // 切换Sheet（第一个Sheet默认创建，后续Sheet手动创建）
                if (sheetIndex > 0) {
                    bigExcelWriter.setSheet("数据Sheet_" + (sheetIndex + 1));
                    // 新Sheet重新写入表头
                    bigExcelWriter.writeHeadRow(CollUtil.newArrayList(headers));
                    currentSheetRows = 1; // 重置当前Sheet行数
                }

                // 4. 分批获取并写入数据（每批BATCH_SIZE条，直到当前Sheet写满或数据写完）
                while (currentSheetRows < MAX_SHEET_ROWS && writtenCount < totalDataCount) {
                    // 计算本批次实际写入数量（不超过Sheet剩余容量和总剩余数据量）
                    int remainingInSheet = MAX_SHEET_ROWS - currentSheetRows;
                    long remainingTotal = totalDataCount - writtenCount;
                    int actualBatchSize = (int) Math.min(BATCH_SIZE, Math.min(remainingInSheet, remainingTotal));

                    // 模拟分批查询数据（实际场景替换为数据库分页查询、文件读取等）
                    List<Map<String, Object>> batchData = getBatchData(writtenCount, actualBatchSize);

                    // 5. 写入当前批次数据（流式写入，不占用大量内存）
                    bigExcelWriter.write(batchData);

                    // 更新已写入数据量
                    writtenCount += batchData.size();
                    currentSheetRows += batchData.size();

                    System.out.println("已写入数据：" + writtenCount + "/" + totalDataCount);
                }
            }

            System.out.println("超大Excel导出完成，文件路径：" + EXPORT_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("超大Excel导出失败：" + e.getMessage());
        }
    }

    /**
     * 模拟分批获取数据（实际场景替换为数据库分页查询、RPC分批拉取等）
     * @param startIndex 起始索引
     * @param batchSize  批次大小
     * @return 批次数据列表
     */
    private static List<Map<String, Object>> getBatchData(long startIndex, int batchSize) {
        List<Map<String, Object>> batchData = new ArrayList<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            long currentId = startIndex + i + 1;
            // 构造模拟数据
            Map<String, Object> rowData = new HashMap<>();
            rowData.put("用户ID", currentId);
            rowData.put("用户名", "user_" + currentId);
            rowData.put("手机号", "138" + String.format("%08d", currentId % 100000000));
            rowData.put("注册时间", "2026-01-12 " + (i % 24) + ":" + (i % 60) + ":" + (i % 60));
            rowData.put("订单金额", (currentId % 10000) / 100.0);
            batchData.add(rowData);
        }
        return batchData;
    }
}