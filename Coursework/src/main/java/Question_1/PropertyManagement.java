package Question_1;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
    private List<House> properties = null;

    public PropertyManagement() {
        this.properties = new ArrayList<House>();
    }

    public void addProperty(House p) throws NullPointerException {
        if (p == null) throw new NullPointerException("Property must not be null");
        this.properties.add(p);
    }

    public void addTenant(House p, Room r, ITenant t) throws NullPointerException {
        if (this.nullCheck(p, r, t)) throw new NullPointerException("Property, room and tenant must not be null");
        p.occupy(r, t);
    }

    public String displayProperties() {
        StringBuilder output = new StringBuilder();
        for (House p : this.properties) {
            output.append(String.format("%s\n", p.toString()));
        }
        return output.toString();
    }

    public void removeProperty(House p) throws IllegalArgumentException {
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
