package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalVendors.getTypicalAddressBook;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.order.OrderItem;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code RemoveCommand}.
 */
public class RemoveCommandTest {


    private Model initialiseModel() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        // Vendor vendorReference = model.getFilteredVendorList().get(INDEX_FIRST_VENDOR.getZeroBased());
        model.addOrderItem(new OrderItem("Hashybrownies", 4.20, new HashSet<>(), 3));
        return model;
    }

    @Test
    public void execute_validIndex_success() {
        Model model = initialiseModel();
        Index first = Index.fromOneBased(1);
        RemoveCommand removeCommand = new RemoveCommand(first);
        List<OrderItem> lastShownList = model.getFilteredOrderItemList();
        OrderItem orderItemToRemove = lastShownList.get(first.getZeroBased());
        String expectedMessage = String.format(RemoveCommand.MESSAGE_DELETE_ORDERITEM_SUCCESS, orderItemToRemove);

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        assertCommandSuccess(removeCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_validQuantity_success() {
        Model model = initialiseModel();
        Index first = Index.fromOneBased(1);
        RemoveCommand removeCommand = new RemoveCommand(first, 1);
        OrderItem item = new OrderItem("Hashybrownies", 4.20, new HashSet<>(), 2);
        String expectedMessage = String.format(RemoveCommand.MESSAGE_CUT_ORDERITEM_SUCCESS, item);

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addOrderItem(item);

        assertCommandSuccess(removeCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Model model = initialiseModel();
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredVendorList().size() + 1);
        RemoveCommand removeCommand = new RemoveCommand(outOfBoundIndex);

        assertCommandFailure(removeCommand, model, Messages.MESSAGE_INVALID_ORDERITEM_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidQuantity_throwsCommandException() {
        Model model = initialiseModel();
        Index first = Index.fromOneBased(1);
        // ensures that Index is still in bounds of order item list
        assertTrue(first.getZeroBased() < model.getFilteredOrderItemList().size());

        RemoveCommand removeCommand = new RemoveCommand(first, 0);

        assertCommandFailure(removeCommand, model, Messages.MESSAGE_INVALID_ORDERITEM_DISPLAYED_QUANTITY);
    }

    @Test
    public void equals() {
        RemoveCommand removeFirstCommand = new RemoveCommand(Index.fromOneBased(1));
        RemoveCommand removeSecondCommand = new RemoveCommand(Index.fromOneBased(2));

        // same object -> returns true
        assertTrue(removeFirstCommand.equals(removeFirstCommand));

        // same values -> returns true
        RemoveCommand removeFirstCommandCopy = new RemoveCommand(Index.fromOneBased(1));
        assertTrue(removeFirstCommand.equals(removeFirstCommandCopy));

        // different types -> returns false
        assertFalse(removeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(removeFirstCommand.equals(null));

        // different vendor -> returns false
        assertFalse(removeFirstCommand.equals(removeSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoVendor(Model model) {
        model.updateFilteredVendorList(p -> false);

        assertTrue(model.getFilteredVendorList().isEmpty());
    }
}
