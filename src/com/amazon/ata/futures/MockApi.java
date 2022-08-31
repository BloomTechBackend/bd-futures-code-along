package com.amazon.ata.futures;

import com.amazon.ata.futures.apitasks.APITaskRequest;
import com.amazon.ata.futures.apitasks.APITaskResponse;

import java.util.concurrent.*;

public class MockApi {
    private final ExecutorService mockApiExecutorService;

    public MockApi() {
        mockApiExecutorService = Executors.newCachedThreadPool();
    }

    public void shutdown() {
        mockApiExecutorService.shutdown();
    }

    APITaskResponse performRequest(APITaskRequest apiTaskRequest) {
        Future<APITaskResponse> responseFuture =
                mockApiExecutorService.submit(waitForTaskDuration(apiTaskRequest));

        try {
            return responseFuture.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private Callable<APITaskResponse> waitForTaskDuration(APITaskRequest apiTaskRequest) {
        return () -> {
            Thread.sleep(apiTaskRequest.getCompletionTime());
            return new APITaskResponse(apiTaskRequest.getHttpMethod() + " request to " + apiTaskRequest.getPath(), apiTaskRequest.getCompletionTime(), false);
        };
    }
}
