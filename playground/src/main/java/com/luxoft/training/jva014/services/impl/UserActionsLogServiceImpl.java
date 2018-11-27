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
package com.luxoft.training.jva014.services.impl;

import com.luxoft.training.jva014.model.vews.UserActionLogRecordView;
import com.luxoft.training.jva014.repositories.UserActionsLogRepository;
import com.luxoft.training.jva014.services.UserActionsLogService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActionsLogServiceImpl implements UserActionsLogService {

    @Autowired
    UserActionsLogRepository actionsLogRepository;

    @Override
    public UserActionLogRecordView recordUserAction(String ipAddress, String userName, Map<String, String> properties) {
        
        
        return null;
    }

}
