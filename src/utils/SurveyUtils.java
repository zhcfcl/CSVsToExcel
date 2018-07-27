package utils;

public class SurveyUtils {

    public static int convertIntent(String str){
        switch (str){
            case "参加希望":
                return 0;
            case "検討中":
                return 1;
            case "その他":
                return 2;
            case "参加しない":
                return 3;
        }
        return -1;
    }

    public static int convertVIP(String str){
        switch (str){
            case "Promoter":
                return 0;
            case "Adopter":
                return 1;
            case "Public":
                return 2;
//            case "Academic":
//                return 3;
        }
        return -1;
    }

    public static String convertMobile(String str){
        if(str.contains("モビ")){
            return "1";
        }else{
            return "";
        }
    }

    public static String convertInteligen(String str){
        if(str.contains("スマート")){
            return "1";
        }else{
            return "";
        }
    }

    public static String convertSocial(String str){
        if(str.contains("ソーシャル")){
            return "1";
        }else{
            return "";
        }
    }

    public static String convertSmart(String str){
        if(str.contains("スマート")){
            return "1";
        }else{
            return "";
        }
    }

    public static String convertOther(String str){
        if(str.contains("その他")){
            return "1";
        }else{
            return "";
        }
    }

}
