package com.inim.canteenmealadmin;

public class noticeModelForRead {
    String nId,DateTime,nMsg;
    noticeModelForRead(){}

    noticeModelForRead(String id,String DateTime,String nMsg)
    {    this.nId=nId;
        this.DateTime=DateTime;

        this.nMsg=nMsg;

    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String getnId() {
        return nId;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setnMsg(String nMsg) {
        this.nMsg = nMsg;
    }

    public String getnMsg() {
        return nMsg;
    }
}
