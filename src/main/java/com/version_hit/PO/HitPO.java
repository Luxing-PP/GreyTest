package com.version_hit.PO;

import lombok.Data;

@Data
public class HitPO {
    private Integer aid;
    private String platform;
    private String download_url;
    private String update_version_code;
    private String md5;
    private String max_update_version_code;
    private String min_update_version_code;
    private Integer max_os_api;
    private Integer min_os_api;
    private Integer cpu_arch;
    private String channel;
    private String title;
    private String update_tips;
    private boolean usable;

    public boolean isUsable() {
        return usable;
    }
}
