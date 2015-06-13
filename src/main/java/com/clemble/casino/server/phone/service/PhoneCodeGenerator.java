package com.clemble.casino.server.phone.service;

import java.util.Random;

/**
 * Created by mavarazy on 12/8/14.
 */
public interface PhoneCodeGenerator {

    String generateCode();

    static PhoneCodeGenerator noPhoneCodeGenerator() {
        return new NoOpPhoneCodeGenerator("123456");
    }

    static PhoneCodeGenerator randomPhoneCodeGenerator() {
        return new RandomPhoneCodeGenerator();
    }

    class NoOpPhoneCodeGenerator implements PhoneCodeGenerator {

        final private String code;

        public NoOpPhoneCodeGenerator(String code) {
            this.code = code;
        }

        @Override
        public String generateCode() {
            return code;
        }

    }

    class RandomPhoneCodeGenerator implements PhoneCodeGenerator {

        final Random RANDOM  = new Random();

        @Override
        public String generateCode() {
            return String.valueOf(Math.abs(RANDOM.nextLong() % 10_000));
        }
    }
}
