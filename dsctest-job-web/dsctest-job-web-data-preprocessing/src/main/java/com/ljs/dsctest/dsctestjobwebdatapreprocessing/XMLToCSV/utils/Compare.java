package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Compare{


    public String[] CompareSD(ArrayList<String> source,ArrayList<String> desctince){
        //判断两个需要比对的数据的行数是否一致
        int compareLength;
        String[] write=null;
        if(source.size()!=desctince.size()){
            XxlJobLogger.log(">>>>>>>>>>>> 两个结果出现不一致的情况!");
            if(source.size() <= desctince.size()){
                ReturnD<String> pr = Pro(source,desctince);
                write= pr.getSource();
            }else {
                ReturnD<String> pr = Pro(desctince,source);
                write= pr.getSource();
            }
        }else{
            ReturnD<String> pr = Pro(source,desctince);
            write= pr.getSource();
        }
        return write;
    }

    public ReturnD<String> Pro(ArrayList<String> source,ArrayList<String> desctince){
        int compareLength = source.size();
        ReturnD<String> pt = null;
        String source_return_str=null;
        for (int i=0;i<compareLength;i++){
            for(int j =0;j<desctince.size();j++){
                if(FEN(source.get(i).toString(),"^#")[0].equals(FEN(desctince.get(i).toString(),"^#"))){
                    if(source.get(i).toString().equals(desctince.get(j).toString())){
                        continue;
                    }else{
                        String[] source_return = HEN(
                                FEN(source.get(i).toString(),"^#"),
                                FEN(desctince.get(j).toString(),"^#"));
                        source_return[source_return.length-1]="数据不一致";
                        pt=new ReturnD<String>();
                        pt.setSource(source_return);
                        return pt;

                    }
                }else{
                    String[] kong=new String[4];
                    for (int k=0;k<4;k++){
                        kong[k]="";
                    }
                    String[] source_return = HEN(
                            FEN(source.get(i).toString(),"^#"),
                            FEN(kong.toString(),""));
                    source_return[source_return.length-1]="缺少数据";
                    pt=new ReturnD<String>();
                    pt.setSource(source_return);
                    return pt;
                }
            }
        }
        return ReturnD.SUCCESS;
    }

    public String[] FEN(String source,String para){
        String[] sec = source.split(para);
        return sec;
    }
    public String[] HEN(String[] source,String[] desctince){
        int source_length=source.length;
        int desctince_length=desctince.length+1;
        source = Arrays.copyOf(source,source_length+desctince_length);
        System.arraycopy(desctince,0,source,source_length,desctince_length);
        return source;
    }
    /**
     * 以追加的方式写入数据到csv文件中:写入的是测试的结果信息
     * @param filepath：文件路径
     * @param filename：生成的文件名
     * @param colnames：生成的文件的列名
     */
    public File CreateCSV(String filepath, String filename, String[] colnames){
        File filecsv = new File(filepath,filename);
        try{
            PrintWriter pt = new PrintWriter(filecsv,"UTF-8");
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<colnames.length; i++){
                if(i<colnames.length-1){
                    sb.append(colnames[i]+"^#");
                }else{
                    sb.append(colnames[i]+"\r\n");
                }
            }
            pt.flush();
            pt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return filecsv;
    }
}