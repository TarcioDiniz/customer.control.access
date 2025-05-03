package com.customer.control.access.domain.extensions;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Converter
public class PasswordAttributeConverterExtension implements AttributeConverter<String, String> {

    private final PasswordEncoder encoder;

    public PasswordAttributeConverterExtension(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String convertToDatabaseColumn(String rawPassword) {
        return (rawPassword == null) ? null : encoder.encode(rawPassword);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
