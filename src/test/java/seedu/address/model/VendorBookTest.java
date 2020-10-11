package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalVendors.ALICE;
import static seedu.address.testutil.TypicalVendors.getTypicalVendorBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.vendor.Vendor;
import seedu.address.model.vendor.exceptions.DuplicateVendorException;
import seedu.address.testutil.VendorBuilder;

public class VendorBookTest {

    private final VendorBook vendorList = new VendorBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), vendorList.getVendorList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> vendorList.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyVendorList_replacesData() {
        VendorBook newData = getTypicalVendorBook();
        vendorList.resetData(newData);
        assertEquals(newData, vendorList);
    }

    @Test
    public void resetData_withDuplicateVendors_throwsDuplicateVendorException() {
        // Two vendors with the same identity fields
        Vendor editedAlice = new VendorBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Vendor> newVendors = Arrays.asList(ALICE, editedAlice);
        AddressBookStub newData = new AddressBookStub(newVendors);

        assertThrows(DuplicateVendorException.class, () -> vendorList.resetData(newData));
    }

    @Test
    public void hasVendor_nullVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> vendorList.hasVendor(null));
    }

    @Test
    public void hasVendor_vendorNotInAddressBook_returnsFalse() {
        assertFalse(vendorList.hasVendor(ALICE));
    }

    @Test
    public void hasVendor_vendorInAddressBook_returnsTrue() {
        vendorList.addVendor(ALICE);
        assertTrue(vendorList.hasVendor(ALICE));
    }

    @Test
    public void hasVendor_vendorWithSameIdentityFieldsInAddressBook_returnsTrue() {
        vendorList.addVendor(ALICE);
        Vendor editedAlice = new VendorBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(vendorList.hasVendor(editedAlice));
    }

    @Test
    public void getVendorList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> vendorList.getVendorList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose vendors list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyVendorList {
        private final ObservableList<Vendor> vendors = FXCollections.observableArrayList();

        AddressBookStub(Collection<Vendor> vendors) {
            this.vendors.setAll(vendors);
        }

        @Override
        public ObservableList<Vendor> getVendorList() {
            return vendors;
        }
    }

}
