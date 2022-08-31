package com.amazon.ata.futures;

import com.amazon.ata.futures.apitasks.APITaskRequest;
import com.amazon.ata.futures.apitasks.APITaskResponse;
import com.amazon.ata.futures.apitasks.HttpMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    //TODO: Implement timeout on requests
    public static int TIMEOUT = 4000;

    public static void main(String[] args) {
        MockApi mockApi = new MockApi();

        List<APITaskRequest> apiTaskRequests = new ArrayList<>();
            apiTaskRequests.add(new APITaskRequest(HttpMethod.GET, "/categories"));
            apiTaskRequests.add(new APITaskRequest(HttpMethod.GET,"/products/product/1"));
            apiTaskRequests.add(new APITaskRequest(HttpMethod.GET,"/products/all"));

        List<APITaskResponse> responses = makeApiCalls(mockApi, apiTaskRequests);

        //TODO: Output progress message on processing requests

        for (APITaskResponse response : responses) {
            System.out.println(response);
        }

        mockApi.shutdown();
    }

    public static List<APITaskResponse> makeApiCalls(MockApi mockApi, List<APITaskRequest> apiRequests) {
            List<APITaskResponse> responses = new ArrayList<>();
            for (APITaskRequest apiRequest : apiRequests) {
                System.out.println("Making " + apiRequest.getHttpMethod() + " request to " + apiRequest.getPath());
                responses.add(mockApi.performRequest(apiRequest));
            }

            return responses;
    }
}
