package com.financeserver.wzj.finance.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws Exception{

            URL httpurl=new URL("https://touhao.oss-ap-southeast-1.aliyuncs.com/yv6gkzvkmixkv70kfh6k.xlsx");
            System.out.println("https://touhao.oss-ap-southeast-1.aliyuncs.com/yv6gkzvkmixkv70kfh6k.xlsx");
            URLConnection urlConnection = httpurl.openConnection();
            InputStream is = urlConnection.getInputStream();
            XSSFWorkbook wb = new XSSFWorkbook (is);
            XSSFSheet sheet = wb.getSheetAt(0);
            int rowNo = sheet.getLastRowNum()+1;
            System.out.println("rowNo"+rowNo);
            for (int i = 0; i < rowNo; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell1 = row.getCell((short) 0);
                XSSFCell cell2 = row.getCell((short) 1);
                XSSFCell cell3 = row.getCell((short) 2);
                String ce1 = cell1 == null?"空":cell1.getStringCellValue();
                String ce2 = cell2 == null?"空":cell2.getStringCellValue();
                String ce3 = cell3 == null?"空":cell3.getStringCellValue();
                System.out.println("112");
                System.out.println(ce1 + "\t" + ce2 + "\t" + ce3);
                System.out.println("11");
            }
            //wb.close();

        }

}
