package Question_1;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
    private List<House> properties = null;

    /**
     * Creates a new property management system.
     */
    public PropertyManagement() {
        super();
        this.properties = new ArrayList<House>();
    }

    /**
     * Adds a house to the list of houses.
     *
     * @param p the house to add
     * @throws NullPointerException     if the house is null
     * @throws IllegalArgumentException if the house already exists
     */
    public void addProperty(House p)
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
     * Adds a tenant to a house.
     *
     * @param p the house to add the tenant to
     * @param r the room to add the tenant to
     * @param t the tenant to add
     * @throws NullPointerException     if the house, room or tenant is null
     * @throws IllegalArgumentException if the room is already
     *                                  occupied or if the house is full
     */
    public void addTenant(House p, Room r, ITenant t)
            throws NullPointerException, IllegalArgumentException {
        if (this.nullCheck(p, r, t)) {
            throw new NullPointerException("Property, room"
                    + " and tenant must not be null");
        }
        p.occupy(r, t);
    }

    /**
     * Displays the houses in the property management system.
     *
     * @return a string containing the houses in the property management system
     */
    public String displayProperties() {
        StringBuilder output = new StringBuilder();
        for (House p : this.properties) {
            output.append(String.format("%s\n", p.toString()));
        }
        return output.toString();
    }

    /**
     * Removes a house from the list of houses.
     *
     * @param p the house to remove
     * @throws NullPointerException     if the houses is null
     * @throws IllegalArgumentException if the houses is not found
     */
    public void removeProperty(House p)
            throws NullPointerException, IllegalArgumentException {
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
