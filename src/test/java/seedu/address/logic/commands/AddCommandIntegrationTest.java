package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalVendors.getTypicalVendorBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.vendor.Vendor;
import seedu.address.testutil.VendorBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalVendorBook(), new UserPrefs());
    }

    @Test
    public void execute_newVendor_success() {
        Vendor validVendor = new VendorBuilder().build();

        Model expectedModel = new ModelManager(model.getVendorList(), new UserPrefs());
        expectedModel.addVendor(validVendor);

        assertCommandSuccess(new AddCommand(validVendor), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validVendor), expectedModel);
    }

    @Test
    public void execute_duplicateVendor_throwsCommandException() {
        Vendor vendorInList = model.getVendorList().getVendorList().get(0);
        assertCommandFailure(new AddCommand(vendorInList), model, AddCommand.MESSAGE_DUPLICATE_VENDOR);
    }

}
