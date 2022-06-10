package com.jhkang.fhir;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "fhir")
@RequiredArgsConstructor
@Getter
public final class ApplicationProperties {
    private final Profile profile;

    @Getter
    @RequiredArgsConstructor
    public static final class Profile {
        private final String version;
    }
}
