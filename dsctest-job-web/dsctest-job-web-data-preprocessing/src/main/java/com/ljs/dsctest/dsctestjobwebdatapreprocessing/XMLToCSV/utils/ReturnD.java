package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Data
public class ReturnD<T> implements Serializable {
    private Logger logger = LoggerFactory.getLogger(ReturnD.class);
    //定义返回值
    public T content;
    public int code;
    public String result;
    public ReturnD(){
    }
    public ReturnD(int code,String result){

    }

}
