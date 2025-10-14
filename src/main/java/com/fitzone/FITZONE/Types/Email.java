package com.fitzone.FITZONE.Types;

public class Email {
        private String customerEmail;

        public Email() {
        }

        public Email(String email) {
            if(!validate(email)) {
                throw new IllegalArgumentException("Email inválido");
            }
            this.customerEmail = email;
        }

        public String getCustomerEmail() {
            return this.customerEmail;
        }

        private static boolean validate(String email) {
            String regex = "^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$";
            return email != null && email.matches(regex);
        }
}
