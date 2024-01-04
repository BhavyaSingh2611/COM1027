package Question_3;

public interface ITenant {
    /**
     * Gets the age of the tenant.
     *
     * @return the age of the tenant
     */
    public abstract int getAge();

    /**
     * Gets the full name of the tenant.
     *
     * @return the full name of the tenant
     */
    public abstract String getName();

    /**
     * Gets the type of the tenant.
     *
     * @return the type of the tenant
     */
    public abstract TenantType getType();
}

