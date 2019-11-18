package com.ljs.dsctest.dsctestjobadmin.core.model;

import lombok.Data;

import java.util.Date;

@Data
public class DsctestJobInfo {

    private int id;
    private String info_desc;
    private Date add_time;
    private Date update_time;

    //executer
    private String executer_handler;
    private String executer_paramer;
    private String executer_block_strategy;
    private int executer_timeout;
    private int executer_fail_retry_count;

    //trigger
    private int trigger_status;
    private int trigger_last_time;

    //child
    private int child_id;


}
