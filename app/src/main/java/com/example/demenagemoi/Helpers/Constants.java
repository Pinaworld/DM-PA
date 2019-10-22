package com.example.demenagemoi.helpers;

public class Constants {

    public class User {

        private User() {

        }

        //MODEL FIELDS
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String ZIP_CODE = "zipCode";
        public static final String CITY = "city";
        public static final String EMAIL = "email";
        public static final String USER_PASS = "password";

        //ROUTES
        public static final String BASE_USER = "user/";
        public static final String LOGIN = BASE_USER + "login";
        public static final String GET_ALL = BASE_USER + "allUser";
        public static final String GET_BY_ID = BASE_USER;
        public static final String UPDATE_BY_ID = BASE_USER;
        public static final String DELETE_BY_ID = BASE_USER;
    }

    public class Removal {

        private Removal(){

        }

        //MODEL FIELDS
        public static final String DATE = "date";
        public static final String ADDRESS = "address";
        public static final String ARRIVAL_ADDRESS = "arrivalAddress";
        public static final String DESCRIPTION = "description";
        public static final String ID_USER = "idUser";

        //ROUTES
        public static final String BASE_REMOVAL = "removal/";
        public static final String GET_ALL = BASE_REMOVAL;
        public static final String GET_BY_ID = BASE_REMOVAL;
        public static final String UPDATE_BY_ID = BASE_REMOVAL;
        public static final String DELETE_BY_ID = BASE_REMOVAL;
    }

    public class Company {

        private Company(){

        }
        //MODEL FIELDS
        public static final String ID = "ID_COMPANY";
        public static final String NAME = "NAME";
        public static final String SIREN = "SIREN";
        public static final String CITY = "city";
        public static final String STREET = "street";
        public static final String NUMBER = "number";
        public static final String ZIPCODE = "zipCode";
        public static final String EMAIL = "email";
        public static final String COMPANY_PASS = "password";

        //ROUTES
        public static final String BASE_COMPANY = "company/";
        public static final String LOGIN = BASE_COMPANY + "login";
        public static final String GET_ALL = BASE_COMPANY;
        public static final String GET_BY_ID = BASE_COMPANY;
        public static final String UPDATE_BY_ID = BASE_COMPANY;
        public static final String DELETE_BY_ID = BASE_COMPANY;
    }

    public class Advertisement {

        private Advertisement(){

        }

        //MODEL FIELDS
        public static final String AVAILABILITY_DATE = "availabilityDate";
        public static final String DESCRIPTION = "description";
        public static final String LARGE = "large";
        public static final String MEDIUM = "medium";
        public static final String SMALL = "small";
        public static final String ID_COMPANY = "idCompany";

        //ROUTES
        public static final String BASE_ADVERTISEMENT = "advertisement/";
        public static final String GET_ALL = BASE_ADVERTISEMENT;
        public static final String GET_BY_ID = BASE_ADVERTISEMENT;
        public static final String UPDATE_BY_ID_AND_ID_COMPANY = BASE_ADVERTISEMENT;
        public static final String DELETE_BY_ID = BASE_ADVERTISEMENT;
    }
}
