package com.ljs.dsctest.dsctestjobadmin.core.model;

import lombok.Data;

@Data
public class DsctestJobGroup {

    private int id;
    private String app_name;
    private String title;
    private int order;
    private String group_address_list;
    private int group_type;
}
