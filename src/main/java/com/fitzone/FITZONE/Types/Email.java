package com.fitzone.FITZONE.Types;

public class Email {
        private String email;

        public Email() {
        }

        public Email(String email) {
            if(!validate(email)) {
                throw new IllegalArgumentException("Email inválido");
            }
            this.email = email;
        }

        public String getCustomerEmail() {
            return this.email;
        }

        private static boolean validate(String email) {
            String regex = "^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$";
            return email != null && email.matches(regex);
        }
}
