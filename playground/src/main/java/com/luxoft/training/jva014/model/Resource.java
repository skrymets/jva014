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

import com.luxoft.training.jva014.model.vews.ResourceView;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;

/**
 *
 * @author skrymets
 */
@Entity
@Inheritance(strategy = JOINED)
public abstract class Resource extends PersistentEntity implements Serializable, ResourceView {

    private static final long serialVersionUID = 1114735898809056210L;

    private String title;

    private String code;

    public Resource() {
    }

    public Resource(String title, String code) {
        this.title = title;
        this.code = code;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
