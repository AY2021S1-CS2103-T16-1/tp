package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.vendor.Vendor;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyVendorList {

    /**
     * Returns an unmodifiable view of the vendors list.
     * This list will not contain any duplicate vendors.
     */
    ObservableList<Vendor> getVendorList();

}
