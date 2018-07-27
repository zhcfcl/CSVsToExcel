package utils;

import Entity.SurveyEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static SurveyEntity load(String path){
        SurveyEntity surveyEntity = new SurveyEntity();
        File csv = new File(path);  // CSV文件路径
        BufferedReader br = null;
        try
        {
//            Shift_JIS是日文编码，请按需求修改
            InputStreamReader read = new InputStreamReader(new FileInputStream(path),"Shift_JIS");
            br = new BufferedReader(read);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            List<String> allString = new ArrayList<>();
            br.readLine();  //去掉第一行
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                everyLine += line;
                System.out.println(everyLine);
                allString.add(everyLine);
            }
//            System.out.println("csv表格中所有行数："+allString.size());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        if(!everyLine.equals("")){
            everyLine = everyLine.replace("\"","");
            System.out.println(everyLine);
            String[] r = everyLine.split(",");


            surveyEntity.setFamilyName(r[1]);
            surveyEntity.setName(r[2]);
            surveyEntity.setEmail(r[3]);
            surveyEntity.setCompanyName(r[4]);
            surveyEntity.setDepartment(r[5]);
            surveyEntity.setPosition(r[6]);
            surveyEntity.setTotalContent(r[7]);
            surveyEntity.setUnderstand(r[8]);
            surveyEntity.setTreatment(r[9]);
            surveyEntity.setMeetingIntent(r[10]);
            surveyEntity.setJoinIntent(r[11]);
            surveyEntity.setVip(r[12]);
            surveyEntity.setWGIntent(r[13]);
            surveyEntity.setDistribute(r[14]);
            surveyEntity.setLeadExperience(r[15]);
            surveyEntity.setShowExperience(r[16]);
            surveyEntity.setAdvice(r[18]);
        }

        return surveyEntity;
    }
}
