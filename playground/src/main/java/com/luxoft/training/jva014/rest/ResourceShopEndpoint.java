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
package com.luxoft.training.jva014.rest;

import com.luxoft.training.jva014.Roles;
import com.luxoft.training.jva014.model.ConsumableResource;
import com.luxoft.training.jva014.model.InsufficientResourcesException;
import com.luxoft.training.jva014.model.Rent;
import com.luxoft.training.jva014.model.RentableResource;
import com.luxoft.training.jva014.model.vews.ResourceView;
import com.luxoft.training.jva014.services.ResourcesService;
import com.luxoft.training.jva014.services.UserActionsLogService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skrymets
 */
@RestController
//@RequestMapping
public class ResourceShopEndpoint {

    @Autowired
    UserActionsLogService actionsLogService;

    @Autowired
    ResourcesService resourcesService;

    @GetMapping(path = "/version")
    public @ResponseBody
    String version() {
        return "1.0";
    }

    @GetMapping(path = "/inventory/resources")
    @Secured({Roles.ROLE_USER})
    public @ResponseBody
    List<ResourceView> listAllAvailableResources() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String authorizedUsername = ((UserDetails) principal).getUsername();
            actionsLogService.recordUserAction("", authorizedUsername, Collections.emptyMap());
        }

        return Collections.emptyList();
    }

}
