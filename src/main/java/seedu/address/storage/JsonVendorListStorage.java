package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyVendorList;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonVendorListStorage implements VendorListStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonVendorListStorage.class);

    private Path filePath;

    public JsonVendorListStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getVendorListFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyVendorList> readVendorList() throws DataConversionException, IOException {
        return readVendorList(filePath);
    }

    /**
     * Similar to {@link #readVendorList()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyVendorList> readVendorList(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableAddressBook> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableAddressBook.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveVendorList(ReadOnlyVendorList vendorList) throws IOException {
        saveVendorList(vendorList, filePath);
    }

    /**
     * Similar to {@link #saveVendorList(ReadOnlyVendorList)} (ReadOnlyAddressBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveVendorList(ReadOnlyVendorList vendorList, Path filePath) throws IOException {
        requireNonNull(vendorList);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableAddressBook(vendorList), filePath);
    }

}
