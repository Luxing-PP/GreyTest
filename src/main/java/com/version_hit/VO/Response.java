package com.version_hit.VO;

public class Response {
    String message;

    ReturnVO returnVO;

    HitReturnVO hitReturnVO;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnVO getReturnVO() {
        return returnVO;
    }

    public void setReturnVO(ReturnVO returnVO) {
        this.returnVO = returnVO;
    }

    public HitReturnVO getHitReturnVO() {
        return hitReturnVO;
    }

    public void setHitReturnVO(HitReturnVO hitReturnVO) {
        this.hitReturnVO = hitReturnVO;
    }

    public Response(String message, ReturnVO returnVO) {
        this.message = message;
        this.returnVO = returnVO;
    }

    public Response(String message, HitReturnVO hitReturnVO) {
        this.message = message;
        this.hitReturnVO = hitReturnVO;
    }

    public Response() {
    }
}
