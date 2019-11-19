package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service.Impl;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service.AnaXML;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils.Compare;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils.loadXml;
import org.dom4j.Document;
import org.dom4j.Element;
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
    public ArrayList<String> DataKeyValue(){
        ArrayList<String> stringBuilder = new ArrayList<>();
        Map<String,String> hashxmlJiegou =  eleHash();
        List<Object> listObject = null;
        String objectValue = hashxmlJiegou.get("object");
        listObject = eleList(objectValue);
        Element nextiter =null;
        for (int i=0;i<=listObject.size();i++){
            StringBuilder strBuild = new StringBuilder();
            nextiter = (Element) listObject.get(i);
            String rmuid = nextiter.attributeValue("rmUid");
            strBuild.append(rmuid+"^#");
            String Vpath = objectValue+"["+i+"]"+"/V";
            List<Object> prefelements = eleList(Vpath);
            for(int j=0;j<prefelements.size();j++){
                Element V1 = (Element)prefelements.get(j);
                String V1Test = V1.getText();
                if(j<prefelements.size()-1){
                    strBuild.append(V1Test+"^#");
                }else {
                    strBuild.append(V1Test);
                }
            }
            stringBuilder.add(strBuild.toString());
        }
        return stringBuilder;
    }

    @Autowired
    private Compare compare;
    public void WriteResult() throws Exception{
       ArrayList<String> destinct =document.ReadCSV();
       ArrayList<String> source =DataKeyValue();
       String[] comm = compare.CompareSD(source,destinct);
       compare.CreateCSV(document.getCsvpath(),document.getCsvpathresult(),comm);
    }

}
