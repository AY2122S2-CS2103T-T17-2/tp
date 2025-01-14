// package seedu.address.logic.parser;
//
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
// import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
// import static seedu.address.testutil.Assert.assertThrows;
// import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
//
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;
//
// import org.junit.jupiter.api.Test;
//
// import seedu.address.logic.commands.AddCommand;
// import seedu.address.logic.commands.ClearCommand;
// import seedu.address.logic.commands.HelpCommand;
// import seedu.address.logic.parser.exceptions.ParseException;
// import seedu.address.model.recipe.NameContainsKeywordsPredicate;
// import seedu.address.model.recipe.Recipe;
// import seedu.address.testutil.EditRecipeDescriptorBuilder;
// import seedu.address.testutil.RecipeBuilder;
// import seedu.address.testutil.RecipeUtil;
//
// public class RecipeBookParserTest {
//
//     private final RecipeBookParser parser = new RecipeBookParser();
//
//     @Test
//     public void parseCommand_add() throws Exception {
//         Recipe recipe = new RecipeBuilder().build();
//         AddCommand command = (AddCommand) parser.parseCommand(RecipeUtil.getAddCommand(recipe));
//         assertEquals(new AddCommand(recipe), command);
//     }
//
//     @Test
//     public void parseCommand_clear() throws Exception {
//         assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
//         assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
//     }
//
//     @Test
//     public void parseCommand_delete() throws Exception {
//         DeleteCommand command = (DeleteCommand) parser.parseCommand(
//                 DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
//         assertEquals(new DeleteCommand(INDEX_FIRST_PERSON), command);
//     }
//
//     @Test
//     public void parseCommand_edit() throws Exception {
//         Recipe recipe = new RecipeBuilder().build();
//         EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder(recipe).build();
//         EditCommand command = (EditCommand) parser.parseCommand(EditCommand.COMMAND_WORD + " "
//                 + INDEX_FIRST_PERSON.getOneBased() + " " + RecipeUtil.getEditRecipeDescriptorDetails(descriptor));
//         assertEquals(new EditCommand(INDEX_FIRST_PERSON, descriptor), command);
//     }
//
//     @Test
//     public void parseCommand_exit() throws Exception {
//         assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
//         assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
//     }
//
//     @Test
//     public void parseCommand_find() throws Exception {
//         List<String> keywords = Arrays.asList("foo", "bar", "baz");
//         FindCommand command = (FindCommand) parser.parseCommand(
//                 FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
//         assertEquals(new FindCommand(new NameContainsKeywordsPredicate(keywords)), command);
//     }
//
//     @Test
//     public void parseCommand_help() throws Exception {
//         assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
//         assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
//     }
//
//     @Test
//     public void parseCommand_list() throws Exception {
//         assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
//         assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
//     }
//
//     @Test
//     public void parseCommand_unrecognisedInput_throwsParseException() {
//         assertThrows(ParseException.class,
//         String.format(MESSAGE_INVALID_COMMAND_FORMAT,HelpCommand.MESSAGE_USAGE),
//         () -> parser.parseCommand(""));
//     }
//
//     @Test
//     public void parseCommand_unknownCommand_throwsParseException() {
//         assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
//     }
// }
