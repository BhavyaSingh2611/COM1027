package Question_3;

public class Tenant implements ITenant {
    private String forename = null;
    private String surname = null;
    private int age = 0;
    private TenantType tenantType = null;

    private static final String NAME_REGEX = "^[A-Z][a-z]*";

    public Tenant(String forename, String surname, int age, TenantType tenantType)
            throws IllegalArgumentException, NullPointerException {
        if (this.nullCheck(forename, surname, tenantType)) {
            throw new NullPointerException("Forename, surname and tenant type must not be null");
        }
        if (!this.validateName(forename) || !this.validateName(surname)) {
            throw new IllegalArgumentException("Forename and surname must start with a capital letter");
        }
        if (age <= 16) {
            throw new IllegalArgumentException("Tenant must be at least 17 years old");
        }
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.tenantType = tenantType;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return String.format("%s %s", this.forename, this.surname);
    }

    @Override
    public TenantType getTenantType() {
        return this.tenantType;
    }

    private boolean validateName(String name) {
        return name.matches(NAME_REGEX);
    }

    private boolean nullCheck(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }
}
