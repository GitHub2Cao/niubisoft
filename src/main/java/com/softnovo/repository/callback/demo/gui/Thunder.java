package com.softnovo.repository.callback.demo.gui;

import java.util.Date;

public class Thunder {
    public void download(){
        new Downloader().download("a.zip",this);
        new Downloader().download("b.jpg",this);
        new Downloader().download("win10.iso",this);
    }

    public void downloadDone(String filename){
        System.out.println(new Date() + filename + "下载完成！");
    }

    public static void main(String[] args) {
        Thunder thunder = new Thunder();
        thunder.download();
    }
}
