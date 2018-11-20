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

import com.luxoft.training.jva014.model.ConsumableResource;
import com.luxoft.training.jva014.model.RentableResource;
import com.luxoft.training.jva014.model.UserActionLogRecord;
import com.luxoft.training.jva014.model.vews.ResourceView;
import com.luxoft.training.jva014.model.vews.UserActionLogRecordView;
import static java.time.LocalDateTime.now;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 *
 * @author skrymets
 */
@RunWith(MockitoJUnitRunner.class)
public class ResourcesServiceTest {

    @Mock
    private UserActionsLogService userActionsLogService;

    @Mock
    private ResourcesService resourcesService;

    @InjectMocks
    private DummyServiceImpl dummyService;

    public ResourcesServiceTest() {
    }

    @Before
    public void setupResources() {

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        given(userActionsLogService.recordUserAction(anyString(), anyInt(), anyMapOf(String.class, String.class)))
                .willAnswer((Answer<UserActionLogRecordView>) (InvocationOnMock invocation) -> {
                    Object[] arguments = invocation.getArguments();
                    UserActionLogRecord record = new UserActionLogRecord();
                    record.setLogTime(now());
                    record.setIpAddress((String) arguments[0]);
                    record.setUserId((int) arguments[1]);
                    record.setProperties((Map<String, String>) arguments[2]);
                    System.out.println(record);
                    return record;
                });

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        given(resourcesService.listAllAvailableResources())
                .willReturn(
                        Arrays.asList(
                                new ConsumableResource("Printer Paper A80", "CRPPA80"),
                                new ConsumableResource("Printer Paper A120", "CRPPA120"),
                                new ConsumableResource("Office Pen BIC (Black)", "CROPBB00"),
                                new ConsumableResource("Office Pen BIC (Blue)", "CROPBB01"),
                                new ConsumableResource("Office Pencil (HB)", "CROPHB00"),
                                new RentableResource("Office Chair Lux (Black)", "RROCLB00"),
                                new RentableResource("Office Chair Standard (Black)", "RROCSB00"),
                                new RentableResource("Projector HP 1200 N2349572439", "RRN2349572439"),
                                new RentableResource("Projector HP 1200 N4587043345", "RRN4587043345")
                        )
                );
    }

    @Test
    public void testListAllAvailableResources() {
        List<ResourceView> resourceViews = dummyService.listAllAvailableResources();
        assertThat(resourceViews.size(), is(9));
    }

//    @Test
//    public void testListResourcesForConsumption() {
//    }
//
//    @Test
//    public void testListResourcesForRent() {
//    }
//
//    @Test
//    public void testConsumeResource() throws Exception {
//    }
//
//    @Test
//    public void testListConsumedResources() {
//    }
//
//    @Test
//    public void testReplenishResource() {
//    }
//
//    @Test
//    public void testCheckoutResource() {
//    }
//
//    @Test
//    public void testCheckinResource() {
//    }
//
//    @Test
//    public void testAddResourceToInventory() {
//    }
//
//    @Test
//    public void testWriteOffResourceFromInventory() {
//    }
//
//    @Test
//    public void testListMyActiveRents() {
//    }
}
