package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.dom4j.Element;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class loadXml{
    //解析xml的目录结构的公共函数
    private Logger logger = LoggerFactory.getLogger(loadXml.class);
    @Autowired
    private xmlcsvConfig xmlcsvConfig;

    public Map<String,String> eleRoot(){
        //解析
       Map<String ,String > elements =new LinkedHashMap<String ,String >();
        if (xmlcsvConfig == null){
           elements.put("Failed","500");
           return elements;
        }
        Document document = xmlcsvConfig.readPTNXMLDocument();
        Element root = document.getRootElement();
        String rootName = root.getName();
        logger.info(">>>>>>>>>>> Root Name is %s.",rootName);
        // 获取配置文件的相应的信息
        List<Element> chidlElement = root.elements(); //获得root下的所有子元素
        for(Element element:chidlElement){
            elements.put(element.getName(),element.getText());
            logger.info(">>>>>>>>>>> %s Name is %s.",element.getName(),element.getText());
        }
        return elements;
    }

    //判断xml的元素是否为list
    public Boolean IfList(Document document,String path){
        List list = document.selectNodes(path);
        if (list.size() == 1){
            logger.info(">>>>>>>>>>> List has not elements.");
            return Boolean.FALSE;
        }else {
            return Boolean.TRUE;
        }
    }
    /**
     * 以追加的方式写入数据到csv文件中:写入的是测试的结果信息
     * @param filepath：文件路径
     * @param filename：生成的文件名
     * @param colnames：生成的文件的列名
     */
    public File CreateCSV(String filepath,String filename,String[] colnames){
        File filecsv = new File(filepath,filename);
        try{
            PrintWriter pt = new PrintWriter(filecsv,"GBK");
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
