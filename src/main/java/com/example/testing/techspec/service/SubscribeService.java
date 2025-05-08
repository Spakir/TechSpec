package com.example.testing.techspec.service;

import com.example.testing.techspec.dto.SubscribeDto;
import com.example.testing.techspec.dto.TopSubscriptionDto;
import com.example.testing.techspec.entities.Subscribe;

import java.util.List;

public interface SubscribeService {

    SubscribeDto addSubscription(Long userId, SubscribeDto subscribeDto);

    List<SubscribeDto> getSubscriptionsByUserId(Long userId);

    void deleteSubscription(Long userId, Long subscriptionId);

    List<TopSubscriptionDto> getTopSubscriptions();
}
