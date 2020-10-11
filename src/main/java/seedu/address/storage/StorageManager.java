package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.ReadOnlyVendorList;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of VendorBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private VendorListStorage vendorListStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(VendorListStorage vendorListStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.vendorListStorage = vendorListStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getVendorListFilePath() {
        return vendorListStorage.getVendorListFilePath();
    }

    @Override
    public Optional<ReadOnlyVendorList> readVendorList() throws DataConversionException, IOException {
        return readVendorList(vendorListStorage.getVendorListFilePath());
    }

    @Override
    public Optional<ReadOnlyVendorList> readVendorList(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return vendorListStorage.readVendorList(filePath);
    }

    @Override
    public void saveVendorList(ReadOnlyVendorList vendorList) throws IOException {
        saveVendorList(vendorList, vendorListStorage.getVendorListFilePath());
    }

    @Override
    public void saveVendorList(ReadOnlyVendorList vendorList, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        vendorListStorage.saveVendorList(vendorList, filePath);
    }

}
