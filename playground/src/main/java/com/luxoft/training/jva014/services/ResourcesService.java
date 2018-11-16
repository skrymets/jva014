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
import com.luxoft.training.jva014.model.InsufficientResourcesException;
import com.luxoft.training.jva014.model.Rent;
import com.luxoft.training.jva014.model.RentableResource;
import com.luxoft.training.jva014.model.Resource;
import java.util.List;

/**
 *
 * @author skrymets
 */
public interface ResourcesService {

    /**
     * Returns a list of all resources either Consumable or Rentable
     *
     * @return a list of resources. Never <code>null</code> - if there are no resources
     *         available - an empty list will be returned.
     */
    List<Resource> listAllAvailableResources();

    /**
     * Returns a list of consumable resources
     *
     * @return a list of resources. Never <code>null</code> - if there are no resources
     *         available - an empty list will be returned.
     */
    List<ConsumableResource> listResourcesForConsumption();

    /**
     * Returns a list of rentable resources
     *
     * @return a list of resources. Never <code>null</code> - if there are no resources
     *         available - an empty list will be returned.
     */
    List<RentableResource> listResourcesForRent();

    /**
     * Makes an attempt to consume some amount of a resource
     *
     * @param resource a type of resource that is being consumed
     * @param amount   an amount of the resource intended to be consumed
     *
     * @throws InsufficientResourcesException if the requested <code>amount</code> does exceed the
     *                               existing amount of the requested resources.
     */
    void consumeResource(ConsumableResource resource, int amount) throws InsufficientResourcesException;

    List<ConsumableResource> listConsumedResources();

    ConsumableResource replenishResource(ConsumableResource resource, int amount);

    Rent checkoutResource(RentableResource resource);

    void checkinResource(RentableResource resource);

    void addResourceToInventory(RentableResource resource);

    void writeOffResourceFromInventory(RentableResource resource);

    /**
     * Return a list of rents that belong to an arbitrary user
     *
     * @return a list of <code>Rent</code> objects. Never <code>null</code> - if there
     *         are no resources available - an empty list will be returned.
     */
    List<Rent> listMyActiveRents();
}
