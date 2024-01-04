package Question_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
     * @throws NullPointerException if the property is null
     */
    public void addProperty(Property p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException("Property must not be null");
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
     * Display the information about the tenants in
     * the property management system.
     *
     * @return a string containing the information about
     * the tenants in the property management system
     */
    public String displayInfographics() {
        Map<String, Integer> data = new HashMap<>(Map.of(
                "17-25", 0,
                "26-35", 0,
                "36-49", 0,
                "50-60", 0,
                "60+", 0,
                "Professional", 0,
                "Student", 0
        ));
        this.properties.forEach(property -> {
            List<ITenant> tenants =
                    new ArrayList<ITenant>(property.rooms.values());
            tenants.forEach(tenant -> {
                if (tenant.getAge() < 26) {
                    data.put("17-25", data.get("17-25") + 1);
                } else if (tenant.getAge() < 35) {
                    data.put("26-35", data.get("26-35") + 1);
                } else if (tenant.getAge() < 49) {
                    data.put("36-49", data.get("36-49") + 1);
                } else if (tenant.getAge() < 60) {
                    data.put("50-60", data.get("50-60") + 1);
                } else {
                    data.put("60+", data.get("60+") + 1);
                }

                if (tenant.getType().equals(TenantType.PROFESSIONAL)) {
                    data.put("Professional", data.get("Professional") + 1);
                } else if (tenant.getType().equals(TenantType.STUDENT)) {
                    data.put("Student", data.get("Student") + 1);
                }
            });

        });
        return String.format("""
                        Confirmed Tenant Summary:
                        17-25:%d
                        26-35:%d
                        36-49:%d
                        50-60:%d
                        60+:%d
                        *****
                        Professional:%d
                        Student:%d""",
                data.get("17-25"), data.get("26-35"), data.get("36-49"),
                data.get("50-60"), data.get("60+"),
                data.get("Professional"), data.get("Student"));
    }

    /**
     * Displays the properties in the property management system.
     *
     * @return a string containing the properties in
     * the property management system
     */
    public String displayProperties() {
        StringBuilder output = new StringBuilder();
        for (Property p : this.properties) {
            if (!p.isAvailable()) {
                output.append(p.displayOccupiedProperty());
            } else {
                output.append(p).append("\n");
            }
        }
        return output.toString();
    }

    /**
     * Displays the property with the highest impact score.
     *
     * @return a string containing the property with the highest impact score
     */
    public String findProblematicProperty() {
        Optional<Property> property = this.properties.stream()
                .filter(p -> p.calculateImpact() > 0)
                .min((p1, p2) -> Integer.compare(p2.calculateImpact(),
                        p1.calculateImpact()));
        return property.isPresent() ? property.get().toString() : "";
    }

    /**
     * Displays the properties of a type in the property management system.
     *
     * @param type the type of property to count
     * @return the number of properties of the specified type in the
     * property management system
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
