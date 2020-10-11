package seedu.address.testutil;

import seedu.address.model.VendorBook;
import seedu.address.model.vendor.Vendor;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withVendor("John", "Doe").build();}
 */
public class VendorBookBuilder {

    private VendorBook vendorBook;

    public VendorBookBuilder() {
        vendorBook = new VendorBook();
    }

    public VendorBookBuilder(VendorBook addressBook) {
        this.vendorBook = addressBook;
    }

    /**
     * Adds a new {@code Vendor} to the {@code AddressBook} that we are building.
     */
    public VendorBookBuilder withVendor(Vendor vendor) {
        vendorBook.addVendor(vendor);
        return this;
    }

    public VendorBook build() {
        return vendorBook;
    }
}
