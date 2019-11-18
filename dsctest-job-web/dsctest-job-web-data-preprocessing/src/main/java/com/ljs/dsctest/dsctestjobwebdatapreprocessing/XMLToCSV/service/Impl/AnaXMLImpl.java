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
import java.util.List;

@Service
public class AnaXMLImpl implements AnaXML {
    private Logger logger = LoggerFactory.getLogger(AnaXMLImpl.class);
    @Autowired
    private xmlcsvConfig document;

    @Override
    public List<Object> eleList(String path){
        logger.info(">>>>>>>>>>> xml PTN data service.");
        Document doc  = document.readPTNDataDocument();
        List<Object> list = doc.selectNodes(path);
        return list;
    }

}
