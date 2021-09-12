package com.adidas.adidasPublicService.common;

import lombok.Getter;

/**
 * Class for Constans and messages used on the application
 */
public interface Constants {

    /**
     * Constants for Exceptions
     */
    @Getter
    class Exceptions{
        public static String INVALID_PARAMETER_EXCEPTION_MESSAGE = "Invalid parameter";
        public static String EXCEPTION_MESSAGE = "An unexpected error occour";
    }

    /**
     * Contants for URLs
     */
    @Getter
    class URIs{
        public static String BASE_PATH="http://localhost:8080/subscription";
        public static String CREATE_SUBSCRIPTION_URI="/create";
        public static String DELETE_SUBSCRIPTION_URI="/delete/";
        public static String RECOVER_SUBSCRIPTION_URI="/recover/single/";
        public static String RECOVER_ALL_SUBSCRIPTION_URI="/recover/all";
        public static String RECOVER_ALL_SUBSCRIPTION_URI2="/recover/all/";
    }
}
