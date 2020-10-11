package seedu.address.storage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_VENDORS_FILE = TEST_DATA_FOLDER.resolve("typicalVendorsAddressBook.json");
    private static final Path INVALID_VENDOR_FILE = TEST_DATA_FOLDER.resolve("invalidVendorList.json");
    private static final Path DUPLICATE_VENDOR_FILE = TEST_DATA_FOLDER.resolve("duplicateVendorAddressBook.json");

    //    @Test
    //    public void toModelType_typicalVendorsFile_success() throws Exception {
    //        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_VENDORS_FILE,
    //                JsonSerializableAddressBook.class).get();
    //        AddressBook addressBookFromFile = dataFromFile.toModelType();
    //        AddressBook typicalVendorsAddressBook = TypicalVendors.getTypicalAddressBook();
    //        assertEquals(addressBookFromFile, typicalVendorsAddressBook);
    //    }

    //TODO: pass

    //    @Test
    //    public void toModelType_invalidVendorFile_throwsIllegalValueException() throws Exception {
    //        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_VENDOR_FILE,
    //                JsonSerializableAddressBook.class).get();
    //        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    //    }

    //    @Test
    //    public void toModelType_duplicateVendors_throwsIllegalValueException() throws Exception {
    //        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_VENDOR_FILE,
    //                JsonSerializableAddressBook.class).get();
    //        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_VENDOR,
    //                dataFromFile::toModelType);
    //    }

}
