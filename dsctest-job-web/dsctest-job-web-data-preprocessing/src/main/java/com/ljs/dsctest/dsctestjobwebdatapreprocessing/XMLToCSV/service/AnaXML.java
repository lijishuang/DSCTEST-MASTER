package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service;

import org.dom4j.Document;
import org.springframework.stereotype.Component;
import org.dom4j.Element;

import java.util.List;

@Component
public interface AnaXML {
    //定义解析xml的接口
    List<Object> eleList(String path);
}
