package com.version_hit.VO;

public class SuspendPairVo {
    private Integer SuspendID;
    private boolean status;

    public Integer getSuspendID() {
        return SuspendID;
    }

    public boolean isStatus() {
        return status;
    }

    public SuspendPairVo(Integer suspendID, boolean status) {
        SuspendID = suspendID;
        this.status = status;
    }
}
