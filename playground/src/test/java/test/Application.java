/*
 * Copyright 2018 skrymets.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author skrymets
 */
public class Application {

    public void main() {
        List<Future<String>> futures = Collections.<Future<String>>emptyList();

        System.out.println("START");
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            futures = executorService.invokeAll(Collections.singleton(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return UUID.randomUUID().toString();
                }
            }), 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e.getMessage());
            executorService.shutdownNow();
            return;
        }

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        futures.stream().forEach((Future<String> f) -> {
            try {
                System.out.println("WAIT");
                String result = f.get();
                System.out.println("OK: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("ERROR: " + e.getMessage());
                return;
            }
        });

    }

}
