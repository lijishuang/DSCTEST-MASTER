package com.ljs.dsctest.dsctestjobadmin.core.model;

import lombok.Data;

import java.util.Date;

/**
 * @author lijishuang
 */
@Data
public class DsctestJobLogger {
    private Long id;

    //执行器字段
    private int job_group;
    private int job_id;

    //execture
    private String executer_address;
    private String executer_handler;
    private String execture_paramer;
    private int executer_fail_retry_count;

    //trigger
    private int trigger_id;
    private Date trigger_time;
    private int triiger_code;
    private String trigger_msg;

    //handle
    private Date handle_time;
    private int handle_code;
    private String handle_msg;

}
