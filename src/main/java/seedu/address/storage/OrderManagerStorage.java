package seedu.address.storage;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.order.ReadOnlyOrderManager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public interface OrderManagerStorage {
    /**
     * Returns the file path of the data file.
     */
    Path getOrderManagerFilePath();

    /**
     * Returns OrderManager data as a {@link ReadOnlyOrderManager}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyOrderManager> readOrderManager() throws DataConversionException, IOException;

    /**
     * @see #getOrderManagerFilePath()
     */
    Optional<ReadOnlyOrderManager> readOrderManager(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyOrderManager} to the storage.
     * @param orderManager cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveOrderManager(ReadOnlyOrderManager orderManager) throws IOException;

    /**
     * @see #saveOrderManager(ReadOnlyOrderManager)
     */
    void saveOrderManager(ReadOnlyOrderManager orderManager, Path filePath) throws IOException;
}
