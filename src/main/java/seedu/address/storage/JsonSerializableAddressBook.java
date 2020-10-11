package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlyVendorList;
import seedu.address.model.VendorBook;
import seedu.address.model.vendor.Vendor;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_VENDOR = "Vendors list contains duplicate vendor(s).";

    private final List<JsonAdaptedVendor> vendors = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given vendors.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("vendors") List<JsonAdaptedVendor> vendors) {
        this.vendors.addAll(vendors);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyVendorList source) {
        vendors.addAll(source.getVendorList().stream().map(JsonAdaptedVendor::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public VendorBook toModelType() throws IllegalValueException {
        VendorBook vendorList = new VendorBook();
        for (JsonAdaptedVendor jsonAdaptedVendor : vendors) {
            Vendor vendor = jsonAdaptedVendor.toModelType();
            if (vendorList.hasVendor(vendor)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_VENDOR);
            }
            vendorList.addVendor(vendor);
        }
        return vendorList;
    }

}
