package com.version_hit.VO;

import lombok.Data;

@Data
public class HitReturnVO {
    String download_url;
    String update_version_code;
    String md5;
    String title;
    String update_tips;

    public HitReturnVO(String download_url, String update_version_code, String md5, String title, String update_tips) {
        this.download_url = download_url;
        this.update_version_code = update_version_code;
        this.md5 = md5;
        this.title = title;
        this.update_tips = update_tips;
    }

    public HitReturnVO() {
    }
}
