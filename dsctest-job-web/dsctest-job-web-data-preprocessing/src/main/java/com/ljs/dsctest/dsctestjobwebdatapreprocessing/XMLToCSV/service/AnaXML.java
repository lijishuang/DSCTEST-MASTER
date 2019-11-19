package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service;

import org.dom4j.Document;
import org.springframework.stereotype.Component;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface AnaXML {
    //定义解析xml的接口
    List<Object> eleList(String path);
    Map<String,String> eleHash();
    //获取的hash值后，要对数据文件进行解的操作
    ArrayList<String> DataKeyValue();
}
