package com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV;
import com.sun.org.apache.xml.internal.security.utils.XalanXPathAPI;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@JobHandler("dsctestJobHandler")
@Component
/**
 * xml to csv:主函数的内容；
 */
public class dsctestJobHandler extends IJobHandler{
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World.");

        return SUCCESS;
    }
}
