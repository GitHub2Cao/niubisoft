package com.softnovo.repository.callback.demo.gui;

public class Downloader extends Thread {
    private String url;
    private Thunder thunder;

    public void download(String url, Thunder t) {
        this.url = url;
        this.thunder = t;
        this.start();
    }

    @Override
    public void run() {
        if (url == null) return;
        switch (url) {
            case "a.zip":
                tryToSleep(3000);
                break;
            case "b.jpg":
                tryToSleep(100);
                break;
            case "win10.iso":
                tryToSleep(5000);
                break;
        }
        thunder.downloadDone(url);
    }

    private void tryToSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
