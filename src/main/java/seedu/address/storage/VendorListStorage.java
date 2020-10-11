package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyVendorList;

/**
 * Represents a storage for {@link seedu.address.model.AddressBook}.
 */
public interface VendorListStorage {

    /**
     * Returns the file path of the data file.
     */
    //    Path getAddressBookFilePath();
    Path getVendorListFilePath();
    /**
     * Returns VendorList data as a {@link ReadOnlyVendorList}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyVendorList> readVendorList() throws DataConversionException, IOException;

    /**
     * @see #getVendorListFilePath()
     */
    Optional<ReadOnlyVendorList> readVendorList(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyVendorList} to the storage.
     * @param vendorList cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveVendorList(ReadOnlyVendorList vendorList) throws IOException;

    /**
     * @see #saveVendorList(ReadOnlyVendorList)
     */
    void saveVendorList(ReadOnlyVendorList vendorList, Path filePath) throws IOException;

}
