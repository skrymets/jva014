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
package com.luxoft.training.jva014.model;

import com.luxoft.training.jva014.model.vews.UserActionLogRecordView;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author skrymets
 */
public class UserActionLogRecord implements Serializable, UserActionLogRecordView {

    private static final long serialVersionUID = 8749025480681500215L;

    private String ipAddress;

    private int userId;

    private Map<String, String> properties;

    public UserActionLogRecord() {
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = new HashMap<>(properties);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ipAddress);
        hash = 79 * hash + this.userId;
        hash = 79 * hash + Objects.hashCode(this.properties);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserActionLogRecord other = (UserActionLogRecord) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.ipAddress, other.ipAddress)) {
            return false;
        }
        if (!Objects.equals(this.properties, other.properties)) {
            return false;
        }
        return true;
    }

}
