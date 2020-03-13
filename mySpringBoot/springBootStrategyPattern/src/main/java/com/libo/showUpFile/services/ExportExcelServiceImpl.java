package com.libo.showUpFile.services;

import com.libo.showUpFile.dto.ApiResponse;
import com.libo.showUpFile.dto.ExportExcelData;
import com.libo.showUpFile.dto.SheetData;
import com.libo.showUpFile.dto.TabularData;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author riemann
 * @date 2019/04/28 22:05
 */
@Service
@Slf4j
public class ExportExcelServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ExportExcelServiceImpl.class);


    public ApiResponse exportExcel(ExportExcelData exportExcelData, HttpServletResponse response) {

        ApiResponse apiResponse = new ApiResponse();
        String fileName = exportExcelData.getFileName();
        int templateType = exportExcelData.getTemplateType();
        List<SheetData> sheetDataList = exportExcelData.getSheetData();

        HSSFWorkbook wb = new HSSFWorkbook();//创建工作薄
        //创建字体样式
        HSSFFont font = wb.createFont();
        font.setFontName("宋体");//使用宋体
        font.setFontHeightInPoints((short) 12);//字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
        //创建单元格样式style
        HSSFCellStyle style = wb.createCellStyle();
        style.setFont(font);//将字体注入
        style.setWrapText(true);//自动换行
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        style.setBorderTop((short) 1);//设置边框大小
        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);

        //循环遍历有多少个sheeet页
        for (int i = 0; i < sheetDataList.size(); i++) {
            SheetData sheetData = sheetDataList.get(i);
            String sheetName = sheetData.getSheetName();
            List<TabularData> tabularData = sheetData.getTabularData();
            HSSFSheet sheet = wb.createSheet();//创建工作表
            wb.setSheetName(i, sheetName);

            for (TabularData tab : tabularData) {
                HSSFRow row = sheet.getRow(tab.getLastRow() - 1);
                if (row == null) {
                    row = sheet.createRow(tab.getLastRow() - 1);//创建所需的行数
                }
                HSSFCell cell = row.getCell(tab.getLastCol() - 1);//设置单元格的数据
                if (cell == null) {
                    cell = row.createCell(tab.getLastCol() - 1);
                    cell.setCellValue(tab.getTabularContent());
                }
            }
        }

        if (downloadExcel(wb, response)) {
            apiResponse.setStatusCode("200");
            apiResponse.setMessage("export excel success");
        } else {
            apiResponse.setStatusCode("400");
            apiResponse.setMessage("export excel failed");
        }
        return apiResponse;
    }

    public boolean downloadExcel(HSSFWorkbook wb, HttpServletResponse response) {
        boolean flag = true;
        Date date = new Date();
        String sdf = "";
        sdf = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        String filePath = "D:\\excel\\excel导出测试表" + sdf + ".xls";
//        File file = new File(filePath);

        FileOutputStream fos = null;
        try {
            OutputStream outputStream = response.getOutputStream();
//            fos = new FileOutputStream(file);
//            response.setContentType("application/octet-stream");
//            response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//            response.addHeader("Pragma", "no-cache");

            response.setHeader("Content-type", "application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis() + ".xlsx");
            wb.write(response.getOutputStream());
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    flag = false;
                }
            }
        }
        return flag;
    }
}