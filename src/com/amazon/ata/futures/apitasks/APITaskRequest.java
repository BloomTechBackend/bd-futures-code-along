package com.amazon.ata.futures.apitasks;

public class APITaskRequest {
    private String path;
    private int completionTime;
    private HttpMethod httpMethod;


    public APITaskRequest(HttpMethod httpMethod, String name) {
        this.httpMethod = httpMethod;
        this.path = name;

        completionTime = 1000;
        if (path.contains("products")) {
            completionTime += 2000;
        }
        if (path.contains("all")) {
            completionTime += 3000;
        }
    }

    public String getPath() {
        return path;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
