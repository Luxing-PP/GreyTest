package com.version_hit.VO;

import lombok.Data;

@Data
public class RuleVO {
    private Integer aid;
    private String platform;
    private String download_url;
    private String update_version_code;
    private String md5;
//    private String device_id_list;
    private String max_update_version_code;
    private String min_update_version_code;
    private Integer max_os_api;
    private Integer min_os_api;
    private Integer cpu_arch;
    private String channel;
    private String title;
    private String update_tips;
    private boolean usable=true;

    public Integer getAid() {
        return aid;
    }

    public String getPlatform() {
        return platform;
    }

    public String getDownload_url() {
        return download_url;
    }

    public String getUpdate_version_code() {
        return update_version_code;
    }

    public String getMd5() {
        return md5;
    }

//    public String getDevice_id_list() {
//        return device_id_list;
//    }





    public String getChannel() {
        return channel;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdate_tips() {
        return update_tips;
    }

    public RuleVO(String platform) {
        this.platform = platform;
    }

    public RuleVO( Integer aid,String platform, String download_url, String update_version_code, String md5,  String max_update_version_code, String min_update_version_code, Integer max_os_api, Integer min_os_api, Integer cpu_arch, String channel, String title, String update_tips) {
        this.aid=aid;
        this.platform = platform;
        this.download_url = download_url;
        this.update_version_code = update_version_code;
        this.md5 = md5;
//        this.device_id_list = device_id_list;
        this.max_update_version_code = max_update_version_code;
        this.min_update_version_code = min_update_version_code;
        this.max_os_api = max_os_api;
        this.min_os_api = min_os_api;
        this.cpu_arch = cpu_arch;
        this.channel = channel;
        this.title = title;
        this.update_tips = update_tips;
        this.usable=true;
    }

    public RuleVO() {

    }
}
