package com.tron.automation.util;

import com.tron.automation.core.OperationGroup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void writeExcel(List<Map> dataList, int cloumnCount, String finalXlsxPath) {
        OutputStream out = null;
        try {
            File finalXlsxFile = new File(finalXlsxPath);
            if(!finalXlsxFile.exists()){
                //创建一个Excel
                createExcel(finalXlsxPath);
            }
            //读取上一行创建的Excel
            finalXlsxFile = new File(finalXlsxPath);
            // 获取总列数
            int columnNumCount = cloumnCount;
            // 读取Excel文档
            Workbook workBook = getWorkbok(finalXlsxFile);
            // sheet 对应一个工作页
            Sheet sheet = workBook.getSheetAt(0);
            // 获得总行数-1（LastRowNum从0开始计算行数）
            int rows = sheet.getLastRowNum();
            /**
             * 往Excel中写新数据
             */
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行
                Row row = sheet.createRow(++rows);
                // 得到要插入的每一条记录
                Map dataMap = dataList.get(j);
                String name = dataMap.get("isSuccess").toString();
                String address = dataMap.get("code").toString();
                String phone = dataMap.get("message").toString();
                for (int k = 0; k <= columnNumCount; k++) {
                    // 在一行内循环
                    Cell first = row.createCell(0);
                    first.setCellValue(name);

                    Cell second = row.createCell(1);
                    second.setCellValue(address);

                    Cell third = row.createCell(2);
                    third.setCellValue(phone);
                }
            }
            // 创建文件输出流
            out = new FileOutputStream(finalXlsxPath);
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List readExcel(File file) {
        try {
            // 获得工作簿
            Workbook workbook = WorkbookFactory.create(file);
            // 获得工作表个数
            int sheetCount = workbook.getNumberOfSheets();
            for (int index = 0; index < sheetCount; index++) {
                List<List> outerList = new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = workbook.getSheetAt(index);
                // 获得总行数
                int rows = sheet.getLastRowNum() + 1;
                // 获得总列数，先获得一行，在得到改行列数
                Row tmp = sheet.getRow(0);
                if (tmp == null) {
                    continue;
                }
                int cols = tmp.getPhysicalNumberOfCells();
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < rows; i++) {
                    Row r = sheet.getRow(i);
                    List innerList = new ArrayList();
                    for (int j = 0; j < cols; j++) {
                        Cell cell = r.getCell(j);
                        if (cell==null) {
                            continue;
                        }
                        String cellinfo = cell.getStringCellValue();
                        if (cellinfo.isEmpty()) {
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
//                    System.out.println();
                }
                return outerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //创建Excel文件
    public static void createExcel(String path) throws Exception {
        //创建Excel文件对象
        Workbook wb = null;
        if (path.endsWith(EXCEL_XLS)) {
            wb = new HSSFWorkbook();
        } else if (path.endsWith(EXCEL_XLSX)) {
            wb = new XSSFWorkbook();
        }
        //用文件对象创建sheet对象  
        Sheet sheet = wb.createSheet("第一个sheet页");
        //用sheet对象创建行对象  
        Row row = sheet.createRow(0);
        //创建单元格样式     
        CellStyle cellStyle = wb.createCellStyle();
        //用行对象创建单元格对象Cell并设置Excel工作表的值
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("是否成功");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("错误码");
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("错误备注");
        //输出Excel文件
        FileOutputStream output = new FileOutputStream(path);
        wb.write(output);
        output.flush();
    }

    /**
     * 判断Excel的版本,获取Workbook
     */
    public static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
}
