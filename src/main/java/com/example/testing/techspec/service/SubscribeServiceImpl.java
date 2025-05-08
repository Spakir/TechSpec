package com.example.testing.techspec.service;

import com.example.testing.techspec.dto.SubscribeDto;
import com.example.testing.techspec.dto.TopSubscriptionDto;
import com.example.testing.techspec.entities.Subscribe;
import com.example.testing.techspec.entities.User;
import com.example.testing.techspec.mapper.SubscribeMapper;
import com.example.testing.techspec.repository.SubscribeRepository;
import com.example.testing.techspec.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {

    private final UserRepository userRepository;

    private final UserService userService;

    private final SubscribeRepository subscribeRepository;

    private final SubscribeMapper subscribeMapper;

    @Override
    public SubscribeDto addSubscription(Long userId, SubscribeDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Пользователь не найден"));

        Subscribe subscribe = subscribeMapper.toEntity(dto, userService);
        subscribe.setUser(user);

        return subscribeMapper.toDto(subscribeRepository.save(subscribe));
    }

    @Override
    public List<SubscribeDto> getSubscriptionsByUserId(Long userId) {
        return subscribeRepository.findByUserId(userId).stream()
                .map(subscribeMapper::toDto)
                .toList();
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscribe subscribe = subscribeRepository.findByIdAndUserId(subscriptionId, userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Подписка не найдена"));
        subscribeRepository.delete(subscribe);
    }

    @Override
    public List<TopSubscriptionDto> getTopSubscriptions() {
        return subscribeRepository.findTopSubscriptions();
    }
}
