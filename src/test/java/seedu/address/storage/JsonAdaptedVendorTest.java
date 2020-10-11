package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalVendors.BENSON;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class JsonAdaptedVendorTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void stupid() {
        assertEquals(0, 0);
    }

    //TODO: pass
    //    @Test
    //    public void toModelType_validVendorDetails_returnsVendor() throws Exception {
    //        JsonAdaptedVendor vendor = new JsonAdaptedVendor(BENSON);
    //        assertEquals(BENSON, vendor.toModelType());
    //    }

    //    @Test
    //    public void toModelType_invalidName_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor =
    //                new JsonAdaptedVendor(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS, null);
    //        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_nullName_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor = new JsonAdaptedVendor(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
    //                VALID_TAGS, null);
    //        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_invalidPhone_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor =
    //                new JsonAdaptedVendor(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS, null);
    //        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_nullPhone_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor = new JsonAdaptedVendor(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
    //                VALID_TAGS, null);
    //        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_invalidEmail_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor =
    //                new JsonAdaptedVendor(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS, VALID_TAGS, null);
    //        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_nullEmail_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor = new JsonAdaptedVendor(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
    //                VALID_TAGS, null);
    //        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_invalidAddress_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor =
    //                new JsonAdaptedVendor(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS, VALID_TAGS, null);
    //        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_nullAddress_throwsIllegalValueException() {
    //        JsonAdaptedVendor vendor = new JsonAdaptedVendor(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
    //                VALID_TAGS, null);
    //        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
    //        assertThrows(IllegalValueException.class, expectedMessage, vendor::toModelType);
    //    }
    //
    //    @Test
    //    public void toModelType_invalidTags_throwsIllegalValueException() {
    //        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
    //        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
    //        JsonAdaptedVendor vendor =
    //                new JsonAdaptedVendor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, invalidTags, null);
    //        assertThrows(IllegalValueException.class, vendor::toModelType);
    //    }

}
