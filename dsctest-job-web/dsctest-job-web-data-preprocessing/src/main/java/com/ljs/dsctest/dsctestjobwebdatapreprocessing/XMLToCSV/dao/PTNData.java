package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.dao;

import lombok.Data;

import java.util.LinkedList;

@Data
public class PTNData {
    private String timestamp;
    private String timezone;
    private String vendername;
    private String elementtype;
    private String cmversion;
    private String objecttype;
    private String[] N;
    private String rmuid;
    private String[] V;


    @Override
    public String toString(){
        return rmuid+"^#"+
                N[1]+"^#"+N[2]+"^#"+N[3]+"^#"+
                timestamp;
    }
}
