package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

@Component
public class loadXml{
    //解析xml的目录结构的公共函数
    private Logger logger = LoggerFactory.getLogger(loadXml.class);
    @Autowired
    private xmlcsvConfig xmlcsvConfig;

    public HashMap<String,String> eleRoot(){
        //解析
       HashMap<String ,String > elements =new HashMap<String ,String >();
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

}
