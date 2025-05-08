package com.example.testing.techspec.controller;

import com.example.testing.techspec.dto.SubscribeDto;
import com.example.testing.techspec.dto.TopSubscriptionDto;
import com.example.testing.techspec.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeService subscribeService;

    @PostMapping("/users/{userId}")
    public SubscribeDto create(@PathVariable Long userId, @RequestBody SubscribeDto dto) {
        return subscribeService.addSubscription(userId, dto);
    }

    @GetMapping("/users/{userId}")
    public List<SubscribeDto> getAll(@PathVariable Long userId) {
        return subscribeService.getSubscriptionsByUserId(userId);
    }

    @DeleteMapping("/users/{userId}/{subscriptionId}")
    public void delete(@PathVariable Long userId, @PathVariable Long subscriptionId) {
        subscribeService.deleteSubscription(userId, subscriptionId);
    }

    @GetMapping("/top")
    public List<TopSubscriptionDto> getTop() {
        return subscribeService.getTopSubscriptions();
    }
}