package securityservice.util.constant;

public final class ConstantsEntity {
    private ConstantsEntity() {
    }

    public static class UserTable {
        public static final String NAME = "user";

        public static class Id {
            public static final String NAME = "user_id";
        }

        public static class Username {
            public static final String NAME = "username";

            public static final int LENGTH = 20;
        }

        public static class Password {
            public static final String NAME = "password";

            public static final int LENGTH = 100;
        }

        public static class FirstName {
            public static final String NAME = "first_name";

            public static final int LENGTH = 50;
        }

        public static class LastName {
            public static final String NAME = "last_name";

            public static final int LENGTH = 50;
        }

        public static class Email {
            public static final String NAME = "email";

            public static final int LENGTH = 30;
        }

        public static class Avatar {
            public static final String NAME = "avatar";
        }

        public static class IsDeleted {
            public static final String NAME = "is_deleted";
        }
    }

    public static class RoleTable {
        public static final String NAME = "role";

        public static class Id {
            public static final String NAME = "role_id";
        }

        public static class Name {
            public static final String NAME = "role_name";

            public static final int LENGTH = 30;
        }

        public static class Description {
            public static final String NAME = "description";

            public static final int LENGTH = 150;
        }

        public static class IsDeleted {
            public static final String NAME = "is_deleted";
        }
    }

    public static class AuditTable {
        public static final String NAME = "audit";

        public static class CreatedDate {
            public static final String NAME = "created_date";
        }

        public static class ModifiedDate {
            public static final String NAME = "modified_date";
        }
    }

}
