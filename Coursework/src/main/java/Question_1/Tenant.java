package Question_1;

public class Tenant implements ITenant {
    private String forename = null;
    private String surname = null;
    private int age = 0;
    private TenantType tenantType = null;
    private static final String NAME_REGEX = "^[A-Z][a-z]*";

    /**
     * Creates a new tenant.
     *
     * @param forename   the forename of the tenant
     * @param surname    the surname of the tenant
     * @param age        the age of the tenant
     * @param tenantType the type of tenant
     * @throws IllegalArgumentException if the forename or surname does
     *                                  not start with a capital letter
     *                                  or if the age is less than 17
     * @throws NullPointerException     if the forename, surname or
     *                                  tenant type is null
     */
    public Tenant(String forename, String surname, int age,
                  TenantType tenantType)
            throws IllegalArgumentException, NullPointerException {
        super();
        if (this.nullCheck(forename, surname, tenantType)) {
            throw new NullPointerException("Forename, surname and"
                    + " tenant type must not be null");
        }
        if (!this.validateName(forename) || !this.validateName(surname)) {
            throw new IllegalArgumentException("Forename and surname must"
                    + " start with a capital letter");
        }
        if (age <= 16) {
            throw new IllegalArgumentException("Tenant must be at least"
                    + " 17 years old");
        }
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.tenantType = tenantType;
    }

    /**
     * Gets the age of the tenant.
     *
     * @return the age of the tenant
     */
    @Override
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the full name of the tenant.
     *
     * @return the full name of the tenant
     */
    @Override
    public String getName() {
        return String.format("%s %s", this.forename, this.surname);
    }

    /**
     * Gets the type of the tenant.
     *
     * @return the type of the tenant
     */
    @Override
    public TenantType getType() {
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
