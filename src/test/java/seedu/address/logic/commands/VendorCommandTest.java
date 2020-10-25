package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalVendors.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code VendorCommand}.
 */
public class VendorCommandTest {

    private Model initialiseModel() {
        return new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_validDefaultIndex_success() {
        Model model = initialiseModel();
        Index first = Index.fromOneBased(1);
        VendorCommand vendorCommand = new SwitchVendorCommand(first);

        Model expectedModel = initialiseModel();
        expectedModel.selectVendor(first.getZeroBased());
        String expectedMessage = String.format(SwitchVendorCommand.MESSAGE_SELECT_VENDOR_SUCCESS, 1);
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, false,
                false, true);
        assertCommandSuccess(vendorCommand, model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_validIndex_success() {
        Model model = initialiseModel();
        Index third = Index.fromOneBased(3);
        VendorCommand vendorCommand = new SwitchVendorCommand(third);

        Model expectedModel = initialiseModel();
        expectedModel.selectVendor(third.getZeroBased());
        String expectedMessage = String.format(SwitchVendorCommand.MESSAGE_SELECT_VENDOR_SUCCESS, 3);
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, false,
                false, true);
        assertCommandSuccess(vendorCommand, model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Model model = initialiseModel();
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredVendorList().size() + 1);
        VendorCommand vendorCommand = new SwitchVendorCommand(outOfBoundIndex);

        assertCommandFailure(vendorCommand, model, ParserUtil.MESSAGE_INVALID_VENDOR_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        VendorCommand removeFirstCommand = new SwitchVendorCommand(Index.fromOneBased(1));
        VendorCommand removeSecondCommand = new SwitchVendorCommand(Index.fromOneBased(2));

        // same object -> returns true
        assertTrue(removeFirstCommand.equals(removeFirstCommand));

        // same values -> returns true
        VendorCommand removeFirstCommandCopy = new SwitchVendorCommand(Index.fromOneBased(1));
        assertTrue(removeFirstCommand.equals(removeFirstCommandCopy));

        // different types -> returns false
        assertFalse(removeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(removeFirstCommand.equals(null));

        // different vendor -> returns false
        assertFalse(removeFirstCommand.equals(removeSecondCommand));
    }

    //    /**
    //     * Updates {@code model}'s filtered list to show no one.
    //     */
    //    private void showNoVendor(Model model) {
    //        model.updateFilteredVendorList(p -> false);
    //
    //        assertTrue(model.getFilteredVendorList().isEmpty());
    //    }
}
