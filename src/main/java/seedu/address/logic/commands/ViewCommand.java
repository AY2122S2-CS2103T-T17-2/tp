package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.Step;

/**
 * Displays the contents of a recipe to the result display.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the details of a recipe identified by the name of "
            + "the recipe in the recipe list.\n"
            + "Parameters: name (must be a valid case sensitive name)\n"
            + "Example: " + COMMAND_WORD + " Mac and cheese";

    public static final String RECIPE_CONTENT = "Name: %s\n\n"
            + "Ingredients:\n%s\n"
            + "Steps:\n%s\n"
            + "Total time: %s\n"
            + "Servings: %s";

    private final Name targetName;

    /**
     * Create a ViewCommand that displays the contents of stored recipe
     * with the same {@code Name} as the specified name.
     *
     * @param targetName Name of recipe to be viewed.
     */
    public ViewCommand(Name targetName) {
        this.targetName = targetName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Recipe> lastShownList = model.getFilteredRecipeList();
        Recipe recipe = getRecipe(lastShownList, targetName);

        if (recipe == null) { // Recipe not found in LastShownList
            throw new CommandException(String.format(Messages.MESSAGE_RECIPE_NOT_FOUND, targetName.fullName));
        }

        return new CommandResult(String.format(RECIPE_CONTENT,
                recipe.getName(), getIngredients(recipe), getSteps(recipe),
                recipe.getCompletionTime(), recipe.getServingSize()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewCommand // instanceof handles nulls
                && targetName.equals(((ViewCommand) other).targetName)); // state check
    }

    /**
     * Retrieves the {@code Recipe} with the same name as the specified name
     * from a given list of recipes.
     * Returns null if a recipe with the same name cannot be found.
     *
     * @param lastShownList the list of recipes to search from.
     * @param recipeName the name of the recipe to match.
     * @return the recipe from the list matching the specified name.
     */
    private Recipe getRecipe(List<Recipe> lastShownList, Name recipeName) {
        for (Recipe recipe : lastShownList) {
            if (recipeName.equals(recipe.getName())) {
                return recipe;
            }
        }
        return null;
    }

    /**
     * Parses the {@code Ingredient}s of a given {@code Recipe} into a formatted String for display.
     *
     * @param recipe the recipe to parse.
     * @return the formatted String of ingredients.
     */
    private String getIngredients(Recipe recipe) {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredients.append(String.format("%s %s %s\n", ingredient.getIngredientName(),
                    ingredient.getQuantity(), ingredient.getQuantifier()));
        }
        return ingredients.toString();
    }

    /**
     * Parses the {@code Step}s of a given {@code Recipe} into a formatted String for display.
     *
     * @param recipe the recipe to parse.
     * @return the formatted String of steps.
     */
    private String getSteps(Recipe recipe) {
        int index = 1;
        StringBuilder steps = new StringBuilder();
        for (Step step : recipe.getSteps()) {
            steps.append(String.format("%d. %s\n", index, step.toString()));
            index++;
        }
        return steps.toString();
    }
}