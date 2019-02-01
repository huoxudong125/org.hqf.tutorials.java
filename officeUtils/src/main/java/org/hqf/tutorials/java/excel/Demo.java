package org.hqf.tutorials.java.excel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huoquanfu
 * @date 2018/08/20
 */
public class Demo {

    public static void main(String args[]) {


        try {
            //Create an array with the data in the same order in which you //expect to be filled in excel file
            String[] valueToWrite = {"abc@gmail.com", "Pass@123"};

            //Create an object of current class
            Demo objExcelFile = new Demo();

            //Write the file using file name, sheet name and the data to be filled
            objExcelFile.writeExcel(System.getProperty("user.dir") + "\\testData", "data.xlsx", "LoginDataSheet", valueToWrite);

            //Prepare the path of excel file
            String filePath = System.getProperty("user.dir") + "\\testData";

            //Call read file method of the class to read data
            objExcelFile.readExcelFile(filePath, "data.xlsx", "LoginDataSheet");

            //read special column
            String name = objExcelFile.readDataFromExcelUsingColumnName("name");
            System.out.println("name = " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readExcelFile(String filePath, String fileName, String sheetName) throws IOException {

        //Create an object of File class to open xlsx file

        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class

            workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if (fileExtensionName.equals(".xls")) {

            //If it is xls file then create object of XSSFWorkbook class

            workbook = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet sheet = workbook.getSheet(sheetName);

        //Find number of rows in excel file

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it

        for (int i = 0; i < rowCount + 1; i++) {

            Row row = sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue() + "|| ");

            }
        }
    }

    public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException {

        //Create an object of File class to open xlsx file

        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook qamantraWorkbook = null;
        //Find the file extension by splitting  file name in substring // and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class
            qamantraWorkbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if (fileExtensionName.equals(".xls")) {

            //If it is xls file then create object of XSSFWorkbook class

            qamantraWorkbook = new HSSFWorkbook(inputStream);

        }


        //Read excel sheet by sheet name
        Sheet sheet = qamantraWorkbook.getSheet(sheetName);

        //Get the current count of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //Get the first row from the sheet
        Row row = sheet.getRow(0);

        //Create a new row and append it at last of sheet
        Row newRow = sheet.createRow(rowCount + 1);

        //Create a loop over the cell of newly created Row
//        for (int j = 0; j < row.getLastCellNum(); j++) {
        for (int j = 0; j < dataToWrite.length; j++) {

            //Fill data in row
            Cell cell = newRow.createCell(j);
            cell.setCellValue(dataToWrite[j]);

        }

        //Close input stream
        inputStream.close();

        //Create an object of FileOutputStream class to create write data //in excel file
        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file

        qamantraWorkbook.write(outputStream);

        //close output stream

        outputStream.close();

    }

    public String readDataFromExcelUsingColumnName(String ColumnName)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        String SheetName = "LoginDataSheet";
        File file = new File("testData\\data.xlsx");
        FileInputStream fi = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheet(SheetName);
        // it will take value from first row
        Row row = sheet.getRow(0);
        // it will give you count of row which is used or filled
        short lastcolumnused = row.getLastCellNum();

        int colnum = 0;
        for (int i = 0; i < lastcolumnused; i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
                colnum = i;
                break;
            }
        }

        // it will take value from Second row
        row = sheet.getRow(1);
        Cell column = row.getCell(colnum);
        String CellValue = column.getStringCellValue();

        return CellValue;

    }
}