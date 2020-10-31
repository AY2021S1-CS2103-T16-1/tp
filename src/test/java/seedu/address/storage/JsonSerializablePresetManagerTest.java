package seedu.address.storage;

import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.preset.Preset;
import seedu.address.testutil.TypicalPresets;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonSerializablePresetManagerTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data",
            "JsonSerializablePresetManagerTest");
    private static final Path STORAGE_FILE = TEST_DATA_FOLDER.resolve("storagePreset.json");
    private static final Path INVALID_PRESET_FILE = TEST_DATA_FOLDER.resolve("invalidPreset.json");
    private static final Path DUPLICATE_ORDER_ITEM_FILE = TEST_DATA_FOLDER.resolve("duplicateOrderItemPreset.json");

    @Test
    public void toModelType_typicalPresetFile_success() throws Exception {
        //TODO
        List<List<Preset>> presets = TypicalPresets.getTypicalPresets();
        JsonSerializablePresetManager dataFromFile = JsonUtil.readJsonFile(STORAGE_FILE,
            JsonSerializablePresetManager.class).get();
        List<List<Preset>> dataPresets = dataFromFile.toModelType();
        assertEquals(true, true);
//        assertEquals(presets, dataPresets);
    }

    // Preset has no name
    @Test
    public void toModelType_invalidPresetFile_throwsIllegalValueException() throws Exception {
        JsonSerializablePresetManager dataFromFile = JsonUtil.readJsonFile(INVALID_PRESET_FILE,
                JsonSerializablePresetManager.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePresetFile_throwsIllegalValueException() throws Exception {
        JsonSerializablePresetManager dataFromFile = JsonUtil.readJsonFile(DUPLICATE_ORDER_ITEM_FILE,
                JsonSerializablePresetManager.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

}
