package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Data
public class ReturnD<T> implements Serializable {
    private Logger logger = LoggerFactory.getLogger(ReturnD.class);
    //定义返回值
    public static final ReturnD<String> SUCCESS = new ReturnD((Object)null);

    public T[] getSource() {
        return source;
    }

    public void setSource(T[] source) {
        this.source = source;
    }

    private T[] source;

    public ReturnD(Object o){

    }
    public ReturnD(){

    }

    public ReturnD(T[] source_rmuid) {
        this.source = source_rmuid;
    }

}
