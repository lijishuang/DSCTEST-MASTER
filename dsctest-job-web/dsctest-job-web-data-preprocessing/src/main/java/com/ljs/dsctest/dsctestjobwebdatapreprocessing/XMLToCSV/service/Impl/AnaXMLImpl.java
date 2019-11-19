package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service.Impl;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service.AnaXML;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils.loadXml;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.xxl.job.core.log.XxlJobLogger;
import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap;

@Service
public class AnaXMLImpl implements AnaXML {
    private Logger logger = LoggerFactory.getLogger(AnaXMLImpl.class);
    @Autowired
    private xmlcsvConfig document;

    @Autowired
    private loadXml lxml;

    @Override
    public Map<String ,String> eleHash(){
        XxlJobLogger.log(">>>>>>>>>>> xml PTN analysis service finish.");
        return lxml.eleRoot();
    }

    @Override
    /**
     * 解析结构的xml文件
     */
    public List<Object> eleList(String path){
        XxlJobLogger.log(">>>>>>>>>>> xml PTN data service.");
        //logger.info(">>>>>>>>>>> xml PTN data service.");
        Document doc  = document.readPTNDataDocument();
        List<Object> list = doc.selectNodes(path);
        return list;
    }

    @Override
    public StringBuilder[] DataKeyValue(){
        Map<String,String> hashxmlJiegou =  eleHash();
        Set<Entry<String, String>> set = hashxmlJiegou.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();
        List<Object> listObject = null;
        while(iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if(key == "Object"){
                if(lxml.IfList(document.readPTNDataDocument(),value) == Boolean.TRUE){

                }
                listObject = eleList(value);
            }

        }
    }

}
