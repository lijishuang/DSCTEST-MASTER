package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dom4j.Element;
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
        if (list.size() == 0){
            logger.info(">>>>>>>>>>> List has not elements.");
            return Boolean.FALSE;
        }else {
            return Boolean.TRUE;
        }
    }


}
