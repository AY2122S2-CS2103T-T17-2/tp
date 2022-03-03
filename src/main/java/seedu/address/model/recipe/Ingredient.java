package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

/**
 * Represents a Recipe's ingredient in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidIngredientName(String)},
 * {@link #isValidQuantity(double)}, and {@link #isValidQuantifier(String)}.
 */
public class Ingredient {

    public static final String NAME_CONSTRAINTS = "Ingredients name should not be left blank";
    public static final String QUANTITY_CONSTRAINTS =
            "Quantity should be a valid number (greater than 0.0) and should not be left blank";
    public static final String QUANTIFIER_CONSTRAINTS = "Quantifier name should not be left blank";

    /*
     * The first character of the ingredient must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    /*
     * The quantity of the ingredient must be a valid number.
     */
    public static final String QUANTITY_VALIDATION_REGEX = "[0-9]+\\.?[0-9]*|\\.[0-9]+";

    /**
     * The first character of the quantifier must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String QUANTIFIER_VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String ingredientName;
    public final double quantity;
    public final String quantifier;

    /**
     * Constructs a {@code Ingredient}.
     *
     * @param name A valid name.
     * @param quantity A valid quantity.
     * @param quantifier A valid quantifier.
     */
    public Ingredient(String name, double quantity, String quantifier) {
        requireNonNull(name);
        checkArgument(isValidIngredientName(name), NAME_CONSTRAINTS);

        checkArgument(isValidQuantity(quantity), QUANTITY_CONSTRAINTS);

        requireNonNull(quantifier);
        checkArgument(isValidQuantifier(quantifier), QUANTIFIER_CONSTRAINTS);

        this.ingredientName = name;
        this.quantity = quantity;
        this.quantifier = quantifier;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getQuantifier() {
        return quantifier;
    }

    public static boolean isValidIngredientName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    public static boolean isValidQuantity(double test) {
        return test > 0;
    }

    public static boolean isValidQuantifier(String test) {
        return test.matches(QUANTIFIER_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s : %s %s", ingredientName, quantity, quantifier);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ingredient)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Ingredient other = (Ingredient) o;
        return this.ingredientName.equals(other.ingredientName)
                && this.quantity == other.quantity
                && this.quantifier.equals(other.quantifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName, quantity, quantifier);
    }
}
