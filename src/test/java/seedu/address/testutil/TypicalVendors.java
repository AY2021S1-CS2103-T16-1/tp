package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import seedu.address.model.VendorBook;
import seedu.address.model.food.Food;
import seedu.address.model.vendor.Vendor;

/**
 * A utility class containing a list of {@code Vendor} objects to be used in tests.
 */
public class TypicalVendors {
    static final List<Food> FOODS = Arrays.asList(new Food("Prata", 12, new HashSet<>()));

    public static final Vendor ALICE = new VendorBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends").withMenu(FOODS).build();
    public static final Vendor BENSON = new VendorBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432").withMenu(FOODS)
            .withTags("owesMoney", "friends").build();
    public static final Vendor CARL = new VendorBuilder().withName("Carl Kurz").withPhone("95352563").withMenu(FOODS)
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Vendor DANIEL = new VendorBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").withMenu(FOODS).build();
    public static final Vendor ELLE = new VendorBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").withMenu(FOODS).build();
    public static final Vendor FIONA = new VendorBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").withMenu(FOODS).build();
    public static final Vendor GEORGE = new VendorBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withMenu(FOODS).build();

    // Manually added
    //    public static final Vendor HOON = new VendorBuilder().withName("Hoon Meier").withPhone("8482424")
    //            .withEmail("stefan@example.com").withAddress("little india").build();
    //    public static final Vendor IDA = new VendorBuilder().withName("Ida Mueller").withPhone("8482131")
    //            .withEmail("hans@example.com").withAddress("chicago ave").build();
    //
    //    // Manually added - Vendor's details found in {@code CommandTestUtil}
    //    public static final Vendor AMY = new VendorBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
    //            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();

    //    public static final Vendor BOB = new VendorBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
    //            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND,
    //            VALID_TAG_FRIEND)
    //            .build();

    //    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalVendors() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical Vendors.
     */
    public static VendorBook getTypicalVendorBook() {
        VendorBook ab = new VendorBook();
        for (Vendor vendor : getTypicalVendors()) {
            ab.addVendor(vendor);
        }
        return ab;
    }

    public static List<Vendor> getTypicalVendors() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
