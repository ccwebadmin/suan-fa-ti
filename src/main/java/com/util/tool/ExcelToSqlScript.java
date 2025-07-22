package com.util.tool;

/**
 * @author cc
 * @date 2025年06月16日 19:38
 * @return
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ExcelToSqlScript {


    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Lenovo\\Desktop\\mbs\\1.xlsx";
        String sqlFilePath = "C:\\Users\\Lenovo\\Desktop\\mbs\\医保业务基础子系统-公共-菜单SQL脚本.sql";

        try {
            FileOutputStream fos = new FileOutputStream(new File(sqlFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(new File(excelFilePath));
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);

                String resuId = getCellValue(row.getCell(0));
                String parentResuId = getCellValue(row.getCell(1));
                int seq = Integer.parseInt(getCellValue(row.getCell(2)));
                String  leafondFlag = getCellValue(row.getCell(3));
                String menuLevel1 = getCellValue(row.getCell(4));
                String menuLevel2 = getCellValue(row.getCell(5));
                String menuLevel3 = getCellValue(row.getCell(6));
                String menuLevel4 = getCellValue(row.getCell(7));
                String menuCode = getCellValue(row.getCell(8));
                String menuPath = getCellValue(row.getCell(9));

                // 根目录
                if (i == 1) {
                    writeSqlToFile(fos, generateMenuSql("55fc3ce81e404ee8939fcde56abdcb49", "-1", "医保业务基础子系统-公共", "ybywjczxy-gg", "/#/", 1,"0"));
                    writeSqlToFile(fos, generatePermissionSql("医保业务基础子系统-公共", "55fc3ce81e404ee8939fcde56abdcb49"));
                    writeSqlToFile(fos, generateBasicFunctionSql("医保业务基础子系统-公共", generateRandomId(), "55fc3ce81e404ee8939fcde56abdcb49"));
                }


                // 一级菜单
                if (!menuLevel1.isEmpty()) {
                    writeSqlToFile(fos, generateMenuSql(resuId, parentResuId, menuLevel1, menuCode, menuPath, seq,leafondFlag));
                    writeSqlToFile(fos, generatePermissionSql(menuLevel1, resuId));
                    writeSqlToFile(fos, generateBasicFunctionSql(menuLevel1, generateRandomId(), resuId));
                }

                // 二级菜单
                if (!menuLevel2.isEmpty()) {
                    writeSqlToFile(fos, generateMenuSql(resuId, parentResuId, menuLevel2, menuCode, menuPath, seq,leafondFlag));
                    writeSqlToFile(fos, generatePermissionSql(menuLevel2, resuId));
                    writeSqlToFile(fos, generateBasicFunctionSql(menuLevel2, generateRandomId(), resuId));
                }

                // 三级菜单
                if (!menuLevel3.isEmpty()) {
                    writeSqlToFile(fos, generateMenuSql(resuId, parentResuId, menuLevel3, menuCode, menuPath, seq,leafondFlag));
                    writeSqlToFile(fos, generatePermissionSql(menuLevel3, resuId));
                    writeSqlToFile(fos, generateBasicFunctionSql(menuLevel3, generateRandomId(), resuId));
                }

                // 四级菜单
                if (!menuLevel4.isEmpty()) {
                    writeSqlToFile(fos, generateMenuSql(resuId, parentResuId, menuLevel4, menuCode, menuPath, seq,leafondFlag));
                    writeSqlToFile(fos, generatePermissionSql(menuLevel4, resuId));
                    writeSqlToFile(fos, generateBasicFunctionSql(menuLevel4, generateRandomId(), resuId));
                }
            }

            fos.close();
            workbook.close();
            System.out.println("SQL脚本已成功生成到文件: " + sqlFilePath);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // 检查是否为日期类型
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double numericValue = cell.getNumericCellValue();
                    // 检查数值是否为整数
                    if (numericValue == (long) numericValue) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return String.valueOf(numericValue);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    private static String generateRandomId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private static String generateMenuSql(String resuId, String parentResuId, String menuName, String menuCode, String menuPath, int seq, String leafondFlag) {
        return String.format("-- %s - 菜单\n" +
                        "INSERT INTO `sys_resu_d`(`RESU_ID`, `ADMDVS`, `RID`, `RESU_CODG`, `RESU_NAME`, `RESU_TYPE`, `RESU_PATH`, `RESU_IMG`, `RESU_ICON`, `PUB_COMT_FLAG`, `SEQ`, `DSCR`, `SUBSYS_ID`, `PRNT_RESU_ID`, `VALI_FLAG`, `LEAFNOD_FLAG`, `CRTER_ID`, `CRTER_NAME`, `CRTE_TIME`, `CRTE_OPTINS_NO`, `OPTER_ID`, `OPTER_NAME`, `OPT_TIME`, `OPTINS_NO`, `POOLAREA_NO`, `UPDT_TIME`) " +
                        "VALUES ('%s', 'XXXXXX', '%s', '%s', '%s', '1', '%s', NULL, 'el-icon-folder', NULL, %d, NULL, '【待批量替换】子系统ID', '%s', '1', '%s', '1595916681072029399', '系统管理员', now(), 'XXXXXX', '1595916681072029399', '系统管理员', now(), 'XXXXXX', 'XXXXXX', now());\n",
                menuName, resuId, generateRandomId(), menuCode, menuName, menuPath, seq, parentResuId,leafondFlag);
    }

    private static String generatePermissionSql(String menuName, String resuId) {
        return String.format("-- %s -- 权限\n" +
                        "INSERT INTO sys_role_perm_d(RESU_PERM_ID, ADMDVS, RID, ROLE_ID, RESU_ID, RESU_TYPE, AUTH_TYPE, SUBSYS_ID, ROLE_TYPE, CRTER_ID," +
                        " CRTER_NAME, CRTE_TIME, CRTE_OPTINS_NO, OPTER_ID, OPTER_NAME, OPT_TIME, OPTINS_NO, POOLAREA_NO, UPDT_TIME)" +
                        "select resu_id, 'XXXXXX', rid, '202008041802450000000100XXXXXX', resu_id, resu_type, '1', subsys_id, '1', '1', '系统管理员', now()," +
                        " '1584701988679006722', '1', '系统管理员', now(), '1584701988679006722', 'XXXXXX', now()" +
                        " from sys_resu_d where RESU_ID in ('%s');\n",
                menuName, resuId);
    }

    private static String generateBasicFunctionSql(String menuName, String resuId, String parentResuId) {
        return String.format("-- %s - 基础功能\n" +
                        "INSERT INTO `sys_resu_d`(`RESU_ID`, `ADMDVS`, `RID`, `RESU_CODG`, `RESU_NAME`, `RESU_TYPE`, `RESU_PATH`, `RESU_IMG`, `RESU_ICON`, " +
                        "`PUB_COMT_FLAG`, `SEQ`, `DSCR`, `SUBSYS_ID`, `PRNT_RESU_ID`, `VALI_FLAG`, `LEAFNOD_FLAG`, `CRTER_ID`, `CRTER_NAME`, `CRTE_TIME`, " +
                        "`CRTE_OPTINS_NO`, `OPTER_ID`, `OPTER_NAME`, `OPT_TIME`, `OPTINS_NO`, `POOLAREA_NO`, `UPDT_TIME`) " +
                        "VALUES ('%s', 'XXXXXX', '%s', 'jcgn', '基础功能', '5', NULL, NULL, NULL, NULL, 0, NULL, '【待批量替换】子系统ID', '%s', '1', '1', '1595916681072029399', '系统管理员', now(), 'XXXXXX', '1595916681072029399', '系统管理员', now(), 'XXXXXX', '1100', now());\n",
                menuName, resuId, generateRandomId(), parentResuId);
    }

    private static void writeSqlToFile(FileOutputStream fos, String sql) throws IOException {
        fos.write(sql.getBytes());
    }
}
