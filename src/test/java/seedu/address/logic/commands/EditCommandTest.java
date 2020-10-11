package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.showVendorAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_VENDOR;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_VENDOR;
import static seedu.address.testutil.TypicalVendors.getTypicalVendorBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand.EditVendorDescriptor;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.vendor.Vendor;
import seedu.address.testutil.EditVendorDescriptorBuilder;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class EditCommandTest {

    private Model model = new ModelManager(getTypicalVendorBook(), new UserPrefs());

    //TODO: pass
    //    @Test
    //    public void execute_allFieldsSpecifiedUnfilteredList_success() {
    //        Vendor editedVendor = new VendorBuilder().build();
    //        EditVendorDescriptor descriptor = new EditVendorDescriptorBuilder(editedVendor).build();
    //        EditCommand editCommand = new EditCommand(INDEX_FIRST_VENDOR, descriptor);
    //
    //        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_VENDOR_SUCCESS, editedVendor);
    //
    //        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
    //        expectedModel.setVendor(model.getFilteredVendorList().get(0), editedVendor);
    //
    //        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    //    }

    //TODO: pass
    //    @Test
    //    public void execute_someFieldsSpecifiedUnfilteredList_success() {
    //        Index indexLastVendor = Index.fromOneBased(model.getFilteredVendorList().size());
    //        Vendor lastVendor = model.getFilteredVendorList().get(indexLastVendor.getZeroBased());
    //
    //        VendorBuilder vendorInList = new VendorBuilder(lastVendor);
    //        Vendor editedVendor = vendorInList.withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
    //                .withTags(VALID_TAG_HUSBAND).build();
    //
    //        EditVendorDescriptor descriptor = new EditVendorDescriptorBuilder().withName(VALID_NAME_BOB)
    //                .withPhone(VALID_PHONE_BOB).withTags(VALID_TAG_HUSBAND).build();
    //        EditCommand editCommand = new EditCommand(indexLastVendor, descriptor);
    //
    //        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_VENDOR_SUCCESS, editedVendor);
    //
    //        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
    //        expectedModel.setVendor(lastVendor, editedVendor);
    //
    //        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    //    }

    //TODO: pass
    //    @Test
    //    public void execute_noFieldSpecifiedUnfilteredList_success() {
    //        EditCommand editCommand = new EditCommand(INDEX_FIRST_VENDOR, new EditVendorDescriptor());
    //        Vendor editedVendor = model.getFilteredVendorList().get(INDEX_FIRST_VENDOR.getZeroBased());
    //
    //        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_VENDOR_SUCCESS, editedVendor);
    //
    //        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
    //
    //        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    //    }

    //TODO: pass
    //    @Test
    //    public void execute_filteredList_success() {
    //        showVendorAtIndex(model, INDEX_FIRST_VENDOR);
    //
    //        Vendor vendorInFilteredList = model.getFilteredVendorList().get(INDEX_FIRST_VENDOR.getZeroBased());
    //        Vendor editedVendor = new VendorBuilder(vendorInFilteredList).withName(VALID_NAME_BOB).build();
    //        EditCommand editCommand = new EditCommand(INDEX_FIRST_VENDOR,
    //                new EditVendorDescriptorBuilder().withName(VALID_NAME_BOB).build());
    //
    //        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_VENDOR_SUCCESS, editedVendor);
    //
    //        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
    //        expectedModel.setVendor(model.getFilteredVendorList().get(0), editedVendor);
    //
    //        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    //    }

    @Test
    public void execute_duplicateVendorUnfilteredList_failure() {
        Vendor firstVendor = model.getFilteredVendorList().get(INDEX_FIRST_VENDOR.getZeroBased());
        EditVendorDescriptor descriptor = new EditVendorDescriptorBuilder(firstVendor).build();
        EditCommand editCommand = new EditCommand(INDEX_SECOND_VENDOR, descriptor);

        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_VENDOR);
    }

    @Test
    public void execute_duplicateVendorFilteredList_failure() {
        showVendorAtIndex(model, INDEX_FIRST_VENDOR);

        // edit vendor in filtered list into a duplicate in address book
        Vendor vendorInList = model.getVendorList().getVendorList().get(INDEX_SECOND_VENDOR.getZeroBased());
        EditCommand editCommand = new EditCommand(INDEX_FIRST_VENDOR,
                new EditVendorDescriptorBuilder(vendorInList).build());

        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_VENDOR);
    }

    @Test
    public void execute_invalidVendorIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredVendorList().size() + 1);
        EditVendorDescriptor descriptor = new EditVendorDescriptorBuilder().withName(VALID_NAME_BOB).build();
        EditCommand editCommand = new EditCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_VENDOR_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of address book
     */
    @Test
    public void execute_invalidVendorIndexFilteredList_failure() {
        showVendorAtIndex(model, INDEX_FIRST_VENDOR);
        Index outOfBoundIndex = INDEX_SECOND_VENDOR;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getVendorList().getVendorList().size());

        EditCommand editCommand = new EditCommand(outOfBoundIndex,
                new EditVendorDescriptorBuilder().withName(VALID_NAME_BOB).build());

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_VENDOR_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        final EditCommand standardCommand = new EditCommand(INDEX_FIRST_VENDOR, DESC_AMY);

        // same values -> returns true
        EditVendorDescriptor copyDescriptor = new EditVendorDescriptor(DESC_AMY);
        EditCommand commandWithSameValues = new EditCommand(INDEX_FIRST_VENDOR, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_SECOND_VENDOR, DESC_AMY)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_FIRST_VENDOR, DESC_BOB)));
    }

}
