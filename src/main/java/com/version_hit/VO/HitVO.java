package com.version_hit.VO;

import lombok.Data;

@Data

public class HitVO {
    private String version;
    private String device_platform;
    private String device_id;
    private Integer os_api;
    private String channel;
    private String update_version_code;
    private Integer aid;
    private Integer cpu_arch;

    public HitVO(String version, String device_platform, String device_id, Integer os_api, String channel, String update_version_code, Integer aid, Integer cpu_arch) {
        this.version = version;
        this.device_platform = device_platform;
        this.device_id = device_id;
        this.os_api = os_api;
        this.channel = channel;
        this.update_version_code = update_version_code;
        this.aid = aid;
        this.cpu_arch = cpu_arch;
    }
}
