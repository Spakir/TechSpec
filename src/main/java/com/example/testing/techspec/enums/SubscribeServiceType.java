package com.example.testing.techspec.enums;


import lombok.Getter;
import java.util.stream.Stream;

@Getter
public enum SubscribeServiceType {
    YOUTUBE_PREMIUM("youtube"),
    NETFLIX("netflix"),
    VK_MUSIC("vk music"),
    YANDEX_PLUS("yandex plus"),
    SPOTIFY("spotify");

    private final String alias;

    SubscribeServiceType(String alias) {
        this.alias = alias;
    }

    public static SubscribeServiceType fromAlias(String serviceName) {
        return Stream.of(values())
                .filter(type -> type.alias.equalsIgnoreCase(serviceName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid subscription type: " + serviceName));
    }
}
