package ProblemSet_6a;

public class Ingredient {
    private String name = null;
    private IngredientType type = null;
    private Supplier supplier = null;
    private double rawWeight = 0;

    public Ingredient(String name, IngredientType type, Supplier supplier, int rawWeight) {
        super();
        this.name = name;
        this.type = type;
        this.supplier = supplier;
        this.rawWeight = rawWeight;
    }

    public String getName() {
        return this.name;
    }

    public double getRawWeight() {
        return this.rawWeight;
    }

    public IngredientType getType() {
        return this.type;
    }

    public String getSupplier() {
        return this.supplier.toString();
    }

    public double getCookedWeight() {
        return this.rawWeight * 0.8;
    }
}
