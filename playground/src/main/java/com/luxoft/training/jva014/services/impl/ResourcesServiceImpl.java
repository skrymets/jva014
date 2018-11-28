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

import com.luxoft.training.jva014.model.ConsumableResource;
import com.luxoft.training.jva014.model.InsufficientResourcesException;
import com.luxoft.training.jva014.model.Rent;
import com.luxoft.training.jva014.model.RentableResource;
import com.luxoft.training.jva014.model.vews.ResourceView;
import com.luxoft.training.jva014.services.ResourcesService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Override
    public List<ResourceView> listAllAvailableResources() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConsumableResource> listResourcesForConsumption() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RentableResource> listResourcesForRent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consumeResource(ConsumableResource resource, int amount) throws InsufficientResourcesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConsumableResource> listConsumedResources() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConsumableResource replenishResource(ConsumableResource resource, int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rent checkoutResource(RentableResource resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkinResource(RentableResource resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addResourceToInventory(RentableResource resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeOffResourceFromInventory(RentableResource resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rent> listMyActiveRents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
