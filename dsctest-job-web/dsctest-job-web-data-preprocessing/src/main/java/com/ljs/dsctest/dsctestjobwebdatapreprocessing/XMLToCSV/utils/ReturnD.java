package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnD<T> implements Serializable {
    public String Lable;
    public T content;

    public static final ReturnD<String> SUCCESS = new ReturnD((Object)null);

    public ReturnD(){

    }

    public ReturnD(Object object) {
    }

    public String toString(){
        return "ReturnD [label= "+ this.Lable+",content="+this.content+"]";
    }
}
