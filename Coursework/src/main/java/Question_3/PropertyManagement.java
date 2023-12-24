package Question_3;

import java.util.*;

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
            List<ITenant> tenants = new ArrayList<ITenant>(property.rooms.values());
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

                if (tenant.getTenantType().equals(TenantType.PROFESSIONAL)) {
                    data.put("Professional", data.get("Professional") + 1);
                } else if (tenant.getTenantType().equals(TenantType.STUDENT)) {
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
                data.get("17-25"), data.get("26-35"), data.get("36-49"), data.get("50-60"), data.get("60+"),
                data.get("Professional"), data.get("Student"));
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

    public String findProblematicProperty() {
        Optional<Property> property = this.properties.stream()
                .filter(p -> p.calculateImpact() > 0)
                .min((p1, p2) -> Integer.compare(p2.calculateImpact(), p1.calculateImpact()));
        return property.isPresent() ? property.get().toString() : "";
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
