package com.amazon.ata.futures.apitasks;

public class APITaskResponse {
    private String body;
    private int completionTime;
    private boolean timedOut;


    public APITaskResponse(String body, int completionTime, boolean timedOut) {
        this.body = body;
        this.completionTime = completionTime;
        this.timedOut = timedOut;
    }

    public String getBody() {
        return body;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public boolean isTimedOut() {
        return timedOut;
    }

    @Override
    public String toString() {
        return "APITaskResponse{" +
                "body='" + body + '\'' +
                ", completionTime=" + completionTime +
                ", timedOut=" + timedOut +
                '}';
    }
}
