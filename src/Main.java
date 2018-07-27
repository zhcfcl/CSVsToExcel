import Entity.SurveyEntity;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.css.CSSValue;
import utils.CSVUtils;
import utils.FileUtils;
import utils.SurveyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args){
        List<File> filelist = FileUtils.getFileList("data");

        ArrayList<SurveyEntity> surveyEntities = new ArrayList<>();

        for(int i=0;i<filelist.size();i++){
            SurveyEntity surveyEntity = CSVUtils.load(filelist.get(i).getPath());
            surveyEntities.add(surveyEntity);
        }
        outputExcel(surveyEntities);
    }



    private static void outputExcel(ArrayList<SurveyEntity> surveyEntities){
        ArrayList<HSSFRow> hssfRows = new ArrayList<>();
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        for(int i=0;i<surveyEntities.size();i++){
            //创建HSSFRow对象
            SurveyEntity data = surveyEntities.get(i);
            HSSFRow row = sheet.createRow(i);
//            hssfRows.add(row);
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(data.getCompanyName());
            row.createCell(2).setCellValue(data.getFamilyName()+" "+data.getName());

            int flag = SurveyUtils.convertIntent(data.getJoinIntent());
            row.createCell(3+flag).setCellValue(1);

            flag = SurveyUtils.convertVIP(data.getVip());
            row.createCell(7+flag).setCellValue(1);

            row.createCell(10).setCellValue(SurveyUtils.convertMobile(data.getWGIntent()));
            row.createCell(11).setCellValue(SurveyUtils.convertInteligen(data.getWGIntent()));
            row.createCell(12).setCellValue(SurveyUtils.convertSocial(data.getWGIntent()));
            row.createCell(13).setCellValue(SurveyUtils.convertSmart(data.getWGIntent()));
            row.createCell(14).setCellValue(SurveyUtils.convertOther(data.getWGIntent()));

            row.createCell(15).setCellValue(data.getAdvice());

        }

        try {
            //输出Excel文件
            FileOutputStream output=new FileOutputStream("workbook.xls");
            wb.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
