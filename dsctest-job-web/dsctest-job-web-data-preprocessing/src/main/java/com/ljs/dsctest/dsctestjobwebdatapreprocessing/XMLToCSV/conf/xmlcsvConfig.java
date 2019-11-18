package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.configuration.ConfigurationUtils;
import org.dom4j.Document;

import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import java.net.URL;
@Component
@Configuration
public class xmlcsvConfig {
    private Logger logger = LoggerFactory.getLogger(xmlcsvConfig.class);
    @Value("${xml.PTN.jiegou.path}")
    private String xmlptnjiegoupath;
    @Value("${xml.PTN.data.path}")
    private String xmlptndatapath;

    @Bean
    public Document readPTNXMLDocument(){
        logger.info(">>>>>>>>>>> xml PTN analysis init.");
        URL url = ConfigurationUtils.locate(xmlptnjiegoupath);
        SAXReader reader = new SAXReader();
        Document document = null;
        try{
            document = reader.read(url);
        }catch (DocumentException e){
            logger.error(">>>>>>>>>>> xml PTN analysis error.>>%e",e);
        }
        return document;
    }

    @Bean
    public Document readPTNDataDocument(){
        logger.info(">>>>>>>>>>> xml PTN data init.");
        URL url = ConfigurationUtils.locate(xmlptndatapath);
        SAXReader reader = new SAXReader();
        Document document = null;
        try{
            document = reader.read(url);
        }catch (DocumentException e){
            logger.error(">>>>>>>>>>> xml PTN data error.>>%e",e);
        }
        return document;
    }
}
