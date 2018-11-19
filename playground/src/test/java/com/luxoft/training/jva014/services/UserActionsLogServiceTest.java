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

import com.luxoft.training.jva014.model.vews.UserActionLogRecordView;
import java.util.Collections;
import java.util.Map;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.BDDMockito.*;

/**
 *
 * @author skrymets
 */
public class UserActionsLogServiceTest {

    public UserActionsLogServiceTest() {
    }

    @Test
        //(expected = IllegalArgumentException.class)
    public void testRecordUserAction() {

        UserActionsLogService logServiceMock = mock(UserActionsLogService.class);
        
        when(logServiceMock.recordUserAction(eq(null), anyInt(), anyMapOf(String.class, String.class)))
                .thenThrow(IllegalArgumentException.class);
        when(logServiceMock.recordUserAction(anyString(), anyInt(), eq(null)))
                .thenThrow(IllegalArgumentException.class);

        when(logServiceMock.recordUserAction(anyString(), anyInt(), anyMapOf(String.class, String.class)))
                .thenReturn(new UserActionLogRecordView() {
            @Override
            public String getIpAddress() {
                return "0.0.0.0";
            }

            @Override
            public Map<String, String> getProperties() {
                return Collections.emptyMap();
            }

            @Override
            public int getUserId() {
                return 0;
            }
        });
        
        UserActionLogRecordView logRecord = logServiceMock.recordUserAction("0.0.0.0", 0, Collections.emptyMap());
        assertEquals(logRecord.getIpAddress(), "0.0.0.0");
        assertEquals(logRecord.getUserId(), 0);
        assertEquals(logRecord.getProperties(), Collections.emptyMap());
        
        
    }

}
