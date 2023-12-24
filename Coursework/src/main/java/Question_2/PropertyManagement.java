package Question_2;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
    private List<Property> properties = null;

    public PropertyManagement() {
        this.properties = new ArrayList<Property>();
    }

    public void addProperty(Property p) throws NullPointerException {
        if (p == null) throw new NullPointerException("Property must not be null");
        this.properties.add(p);
    }

    public void addTenant(Property p, Room r, ITenant t) throws NullPointerException {
        if (this.nullCheck(p, r, t)) throw new NullPointerException("Property, room and tenant must not be null");
        p.occupy(r, t);
    }

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

    public int numberOfPropertyType(String type) {
        return (int) this.properties.stream().filter(p ->
                p.getClass().getSimpleName().equalsIgnoreCase(type)).count();
    }

    public double percentageCouncilTaxExemption() {
        int count = 0;
        for (Property p : this.properties) {
            if (p.getCouncilTax() == 0) {
                count++;
            }
        }

        if (this.properties.isEmpty()) return 0;
        return (double) count / this.properties.size() * 100;
    }

    public void removeProperty(Property p) throws IllegalArgumentException {
        if (!this.properties.contains(p)) throw new IllegalArgumentException("Property not found");
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
