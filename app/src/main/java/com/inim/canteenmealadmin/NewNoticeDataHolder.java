package com.inim.canteenmealadmin;

public class NewNoticeDataHolder {


        String nId,DateTime,nMsg;
        NewNoticeDataHolder(){}

        NewNoticeDataHolder(String nId,String DateTime,String nMsg){
      this.DateTime=DateTime;
            this.nId=nId;
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


