package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV;
import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.service.Impl.AnaXMLImpl;
import com.sun.org.apache.xml.internal.security.utils.XalanXPathAPI;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@JobHandler("dsctestJobHandler")
@Component
/**
 * xml to csv:主函数的内容；
 */
public class dsctestJobHandler extends IJobHandler{
    @Autowired
    public AnaXMLImpl service;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("Analysis Starting...");
        //解析获得结构xml的数据


        return SUCCESS;
    }
}
