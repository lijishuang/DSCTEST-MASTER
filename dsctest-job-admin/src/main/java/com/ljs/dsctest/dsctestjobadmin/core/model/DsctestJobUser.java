package com.ljs.dsctest.dsctestjobadmin.core.model;

import lombok.Data;

/**
 * @author lijishuang
 */
@Data
public class DsctestJobUser {
    private int id;
    private String username;
    private String password;
    private int role;
    private String permission;
}
