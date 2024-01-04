package Question_2;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
    private List<Property> properties = null;

    /**
     * Creates a new property management system.
     */
    public PropertyManagement() {
        super();
        this.properties = new ArrayList<Property>();
    }

    /**
     * Adds a property to the list of properties.
     *
     * @param p the property to add
     * @throws NullPointerException     if the property is null
     * @throws IllegalArgumentException if the property already exists
     */
    public void addProperty(Property p)
            throws NullPointerException, IllegalArgumentException {
        if (p == null) {
            throw new NullPointerException("Property must not be null");
        }
        if (this.properties.contains(p)) {
            throw new IllegalArgumentException("Property already exists");
        }
        this.properties.add(p);
    }

    /**
     * Adds a tenant to a property.
     *
     * @param p the property to add the tenant to
     * @param r the room to add the tenant to
     * @param t the tenant to add
     * @throws NullPointerException     if the property, room or tenant is null
     * @throws IllegalArgumentException if the room is already
     *                                  occupied or if the property is full
     */
    public void addTenant(Property p, Room r, ITenant t)
            throws NullPointerException, IllegalArgumentException {
        if (this.nullCheck(p, r, t)) {
            throw new NullPointerException("Property, room and"
                    + " tenant must not be null");
        }
        p.occupy(r, t);
    }

    /**
     * Displays the properties in the property management system.
     *
     * @return a string containing the properties in the
     * property management system
     */
    public String displayProperties() {
        StringBuilder output = new StringBuilder();
        for (Property p : this.properties) {
            output.append(p.isAvailable() ? String.format("%s\n", p)
                    : p.displayOccupiedProperty());
        }
        return output.toString();
    }

    /**
     * Displays the properties of a type in the property management system.
     *
     * @param type the type of property to count
     * @return the number of properties of the specified type
     * in the property management system
     */
    public int numberOfPropertyType(String type) {
        return (int) this.properties.stream().filter(p ->
                p.getClass().getSimpleName().equalsIgnoreCase(type)).count();
    }

    /**
     * Displays the percentage of properties that are council
     * tax-exempt in the property management system.
     *
     * @return the percentage of properties that are council tax-exempt
     */
    public double percentageCouncilTaxExemption() {
        int count = (int) this.properties.stream().filter(p ->
                p.getCouncilTax() == 0).count();

        if (this.properties.isEmpty()) {
            return 0;
        }
        return (double) count / this.properties.size() * 100;
    }

    /**
     * Removes a property from the list of properties.
     *
     * @param p the property to remove
     * @throws NullPointerException     if the properties is null
     * @throws IllegalArgumentException if the properties is not found
     */
    public void removeProperty(Property p)
            throws IllegalArgumentException, NullPointerException {
        if (p == null) {
            throw new NullPointerException("Property must not be null");
        }
        if (!this.properties.contains(p)) {
            throw new IllegalArgumentException("Property not found");
        }
        this.properties.remove(p);
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
