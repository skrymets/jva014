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
package com.luxoft.training.jva014;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author skrymets
 */
@Converter
public class MapToStringConverter implements AttributeConverter<Map<String, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        if (attribute == null) {
            return null;
        }

        String collect = attribute.entrySet().stream()
                .map(e -> e.getKey() + "=" + ofNullable(e.getValue()).orElse(""))
                .collect(Collectors.joining("\n"));

        return collect;
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {

        class Entry {

            String key;
            String value;

            Entry(String first, String second) {
                this.key = first;
                this.value = second;
            }

        }

        String data = ofNullable(dbData).orElse("");
        String[] splitted = data.split("\n");
        Map<String, String> properties = Arrays.stream(splitted)
                .map((String s) -> {
                    String[] split = s.split("=");
                    return new Entry(split[0], (split.length > 1) ? split[1] : null);
                })
                .collect(Collectors.toMap((p) -> p.key, (p) -> p.value));
        return properties;
    }

}
