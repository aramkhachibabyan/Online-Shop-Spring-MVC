package com.smartCode.springMvc.util.constants;

public interface Message {
    String AUTHENTICATION_SUCCESS = "AUTHENTICATION SUCCESS";
    String INVALID_EMAIL = "INVALID EMAIL";
    String BLANK_EMAIL = "EMAIL MUST NOT BE BLANK";
    String BLANK_PASSWORD = "PASSWORD MUST NOT BE BLANK";
    String INVALID_PASSWORD = "INVALID PASSWORD";
    String USER_NOT_FOUND = "USER NOT FOUND";
    String PRODUCT_NOT_FOUND = "PRODUCT NOT FOUND";
    String INVALID_LENGTH_OF_PASSWORD = "PASSWORD CAN'T BE LESS THAN 8 SYMBOLS";
    String REGISTRATION_FAILED = "REGISTRATION FAILED";
    String INVALID_AGE = "AGE MUST BE MORE THAN 0";
    String INVALID_BALANCE = "BALANCE CAN'T BE NEGATIVE";
    String EMAIL_IS_NOT_AVAILABLE = "This username isn't available. Please try another.";
    String BLANK_PRODUCT_CATEGORY = "CATEGORY MUST NOT BE BLANK";
    String BLANK_PRODUCT_NAME = "NAME MUST NOT BE BLANK";
    String INVALID_DATE_FORMAT = "INVALID DATE FORMAT (DD/MM/YYYY)";
    String INVALID_PRICE = "PRICE MUST BE MORE THAN 0" ;
    String INVALID_ID = "ID MUST BE MORE THAN 0";
}
