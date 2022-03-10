// package seedu.address.model.recipe;
//
// import org.junit.jupiter.api.Test;
// import seedu.address.model.person.Person;
// import seedu.address.testutil.PersonBuilder;
// import seedu.address.testutil.RecipeBuilder;
//
// import static org.junit.jupiter.api.Assertions.*;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
// import static seedu.address.testutil.Assert.assertThrows;
// import static seedu.address.testutil.TypicalPersons.ALICE;
// import static seedu.address.testutil.TypicalPersons.BOB;
//
// class RecipeTest {
//
//     @Test
//     public void asObservableList_modifyList_throwsUnsupportedOperationException() {
//         Recipe recipe = new RecipeBuilder().build();
//         assertThrows(UnsupportedOperationException.class, () -> recipe.getTags().remove(0));
//     }
//
//     @Test
//     public void isSameRecipe() {
//         // same object -> returns true
//         assertTrue(ALICE.isSamePerson(ALICE));
//
//         // null -> returns false
//         assertFalse(ALICE.isSamePerson(null));
//
//         // same name, all other attributes different -> returns true
//         Person editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
//                 .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
//         assertTrue(ALICE.isSamePerson(editedAlice));
//
//         // different name, all other attributes same -> returns false
//         editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
//         assertFalse(ALICE.isSamePerson(editedAlice));
//
//         // name differs in case, all other attributes same -> returns false
//         Person editedBob = new PersonBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
//         assertFalse(BOB.isSamePerson(editedBob));
//
//         // name has trailing spaces, all other attributes same -> returns false
//         String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
//         editedBob = new PersonBuilder(BOB).withName(nameWithTrailingSpaces).build();
//         assertFalse(BOB.isSamePerson(editedBob));
//     }
//
//     @Test
//     public void equals() {
//         // same values -> returns true
//         Person aliceCopy = new PersonBuilder(ALICE).build();
//         assertTrue(ALICE.equals(aliceCopy));
//
//         // same object -> returns true
//         assertTrue(ALICE.equals(ALICE));
//
//         // null -> returns false
//         assertFalse(ALICE.equals(null));
//
//         // different type -> returns false
//         assertFalse(ALICE.equals(5));
//
//         // different person -> returns false
//         assertFalse(ALICE.equals(BOB));
//
//         // different name -> returns false
//         Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));
//
//         // different phone -> returns false
//         editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));
//
//         // different email -> returns false
//         editedAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));
//
//         // different address -> returns false
//         editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));
//
//         // different tags -> returns false
//         editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
//         assertFalse(ALICE.equals(editedAlice));
//     }
//
//     @Test
//     void getName() {
//     }
//
//     @Test
//     void getIngredients() {
//     }
//
//     @Test
//     void getPortion() {
//     }
//
//     @Test
//     void getDirections() {
//     }
//
//     @Test
//     void getTags() {
//     }
//
//     @Test
//     void isSameRecipe() {
//     }
// }