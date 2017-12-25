package com.example.android.miwok;

/**
 * Created by manik on 20-12-2017.
 */

public class ObjectL {

    private int mImg= NO_IMG;
    private static final int NO_IMG = -1;

    private String mTrans;

    private String mEng;



    private int mAudio;

    public ObjectL(String mEng,String mTrans,  int mImg ,int mAudio) {
        this.mTrans = mTrans;
        this.mEng = mEng;
        this.mImg = mImg;
        this.mAudio= mAudio;
    }

    public ObjectL( String mEng, String mTrans,int mAudio){
        this.mTrans= mTrans;
        this.mEng=mEng;
        this.mAudio=mAudio;
    }





    public String getTrans() {
        return mTrans;
    }

    public String getEng() {
        return mEng;
    }

    public int getImg() {
        return mImg;
    }

    public boolean hasImg(){
       return mImg != NO_IMG;
    }

    public int getmAudio() {
        return mAudio;
    }
}
