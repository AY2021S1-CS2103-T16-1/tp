package seedu.address.model.vendor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalVendors.ALICE;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.vendor.exceptions.DuplicateVendorException;
import seedu.address.model.vendor.exceptions.VendorNotFoundException;
import seedu.address.testutil.VendorBuilder;

public class UniqueVendorListTest {

    private final UniqueVendorList uniqueVendorList = new UniqueVendorList();

    @Test
    public void contains_nullVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.contains(null));
    }

    @Test
    public void contains_vendorNotInList_returnsFalse() {
        assertFalse(uniqueVendorList.contains(ALICE));
    }

    @Test
    public void contains_vendorInList_returnsTrue() {
        uniqueVendorList.add(ALICE);
        assertTrue(uniqueVendorList.contains(ALICE));
    }

    @Test
    public void contains_vendorWithSameIdentityFieldsInList_returnsTrue() {
        uniqueVendorList.add(ALICE);
        Vendor editedAlice = new VendorBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(uniqueVendorList.contains(editedAlice));
    }

    @Test
    public void add_nullVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.add(null));
    }

    @Test
    public void add_duplicateVendor_throwsDuplicateVendorException() {
        uniqueVendorList.add(ALICE);
        assertThrows(DuplicateVendorException.class, () -> uniqueVendorList.add(ALICE));
    }

    @Test
    public void setVendor_nullTargetVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.setVendor(null, ALICE));
    }

    @Test
    public void setVendor_nullEditedVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.setVendor(ALICE, null));
    }

    @Test
    public void setVendor_targetVendorNotInList_throwsVendorNotFoundException() {
        assertThrows(VendorNotFoundException.class, () -> uniqueVendorList.setVendor(ALICE, ALICE));
    }

    @Test
    public void setVendor_editedVendorIsSameVendor_success() {
        uniqueVendorList.add(ALICE);
        uniqueVendorList.setVendor(ALICE, ALICE);
        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
        expectedUniqueVendorList.add(ALICE);
        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    }

    @Test
    public void setVendor_editedVendorHasSameIdentity_success() {
        uniqueVendorList.add(ALICE);
        Vendor editedAlice = new VendorBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        uniqueVendorList.setVendor(ALICE, editedAlice);
        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
        expectedUniqueVendorList.add(editedAlice);
        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    }

    //    @Test
    //    public void setVendor_editedVendorHasDifferentIdentity_success() {
    //        uniqueVendorList.add(ALICE);
    //        uniqueVendorList.setVendor(ALICE, BOB);
    //        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
    //        expectedUniqueVendorList.add(BOB);
    //        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    //    }

    //    @Test
    //    public void setVendor_editedVendorHasNonUniqueIdentity_throwsDuplicateVendorException() {
    //        uniqueVendorList.add(ALICE);
    //        uniqueVendorList.add(BOB);
    //        assertThrows(DuplicateVendorException.class, () -> uniqueVendorList.setVendor(ALICE, BOB));
    //    }

    @Test
    public void remove_nullVendor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.remove(null));
    }

    @Test
    public void remove_vendorDoesNotExist_throwsVendorNotFoundException() {
        assertThrows(VendorNotFoundException.class, () -> uniqueVendorList.remove(ALICE));
    }

    @Test
    public void remove_existingVendor_removesVendor() {
        uniqueVendorList.add(ALICE);
        uniqueVendorList.remove(ALICE);
        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    }

    @Test
    public void setVendors_nullUniqueVendorList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.setVendors((UniqueVendorList) null));
    }

    //    @Test
    //    public void setVendors_uniqueVendorList_replacesOwnListWithProvidedUniqueVendorList() {
    //        uniqueVendorList.add(ALICE);
    //        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
    //        expectedUniqueVendorList.add(BOB);
    //        uniqueVendorList.setVendors(expectedUniqueVendorList);
    //        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    //    }

    @Test
    public void setVendors_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueVendorList.setVendors((List<Vendor>) null));
    }

    //    @Test
    //    public void setVendors_list_replacesOwnListWithProvidedList() {
    //        uniqueVendorList.add(ALICE);
    //        List<Vendor> vendorList = Collections.singletonList(BOB);
    //        uniqueVendorList.setVendors(vendorList);
    //        UniqueVendorList expectedUniqueVendorList = new UniqueVendorList();
    //        expectedUniqueVendorList.add(BOB);
    //        assertEquals(expectedUniqueVendorList, uniqueVendorList);
    //    }

    @Test
    public void setVendors_listWithDuplicateVendors_throwsDuplicateVendorException() {
        List<Vendor> listWithDuplicateVendors = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicateVendorException.class, () -> uniqueVendorList.setVendors(listWithDuplicateVendors));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueVendorList.asUnmodifiableObservableList().remove(0));
    }
}
