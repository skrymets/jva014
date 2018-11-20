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
package com.luxoft.training.jva014.services;

import com.luxoft.training.jva014.model.Resource;
import com.luxoft.training.jva014.model.vews.ResourceView;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author skrymets
 */
public class DummyServiceImpl {

    private UserActionsLogService userActionsLogService;

    private ResourcesService resourcesService;

    public DummyServiceImpl() {
    }

    public List<ResourceView> listAllAvailableResources() {
        userActionsLogService.recordUserAction("0.0.0.0", 0, Collections.emptyMap());
        return Collections.unmodifiableList(resourcesService.listAllAvailableResources());
    }

    public UserActionsLogService getUserActionsLogService() {
        return userActionsLogService;
    }

    public void setUserActionsLogService(UserActionsLogService userActionsLogService) {
        this.userActionsLogService = userActionsLogService;
    }

    public ResourcesService getResourcesService() {
        return resourcesService;
    }

    public void setResourcesService(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

}
