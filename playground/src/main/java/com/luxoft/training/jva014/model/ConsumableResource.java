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

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author skrymets
 */
@Entity
public class ConsumableResource extends Resource implements Serializable {

    private static final long serialVersionUID = -2996822251237728335L;

    public ConsumableResource() {
    }

    public ConsumableResource(String title, String code) {
        super(title, code);
    }

}
