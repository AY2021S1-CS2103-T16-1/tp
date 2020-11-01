package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.food.Food;
import seedu.address.model.menu.Menu;
import seedu.address.model.tag.Tag;
import seedu.address.model.vendor.Address;
import seedu.address.model.vendor.Email;
import seedu.address.model.vendor.Name;
import seedu.address.model.vendor.Phone;
import seedu.address.model.vendor.Vendor;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Vendor[] getSampleVendors() {
        Menu menu1 = new Menu();

        menu1.add(new Food("Butter Chicken", 7, new HashSet<>()));
        menu1.add(new Food("Pattaya", 5.5, new HashSet<>()));
        HashSet<Tag> vegTags = new HashSet<>();
        HashSet<Tag> spicyTags = new HashSet<>();
        spicyTags.add(new Tag("Spicy"));
        vegTags.add(new Tag("Vegetarian"));
        menu1.add(new Food("Veg Briyani", 5, new HashSet<>(vegTags)));
        menu1.add(new Food("Sambal Chicken", 5.5, new HashSet<>(spicyTags)));
        menu1.add(new Food("Cheese Fries", 4, new HashSet<>()));
        menu1.add(new Food("Kampong Style", 4.8, new HashSet<>()));
        //note that this is fried rice
        menu1.add(new Food("Sambal With Fried Sambal Chicken", 4.8, new HashSet<>()));
        menu1.add(new Food("Roti John", 4, new HashSet<>()));

        // Add cold and hot
        menu1.add(new Food("Milo Cold", 1.5, new HashSet<>()));
        menu1.add(new Food("Milo Hot", 1.3, new HashSet<>()));

        menu1.add(new Food("Milo Dinosaur", 2.5, new HashSet<>()));
        menu1.add(new Food("Milo Godzilla", 3, new HashSet<>()));




        Menu menu2 = new Menu();
        HashSet<Tag> tagList = new HashSet<>();
        tagList.add(new Tag("Egg"));
        tagList.add(new Tag("Cheese"));
        menu2.add(new Food("Tandoori", 6.50, new HashSet<>()));
        menu2.add(new Food("Mutton Briyani", 7.50, new HashSet<>()));
        menu2.add(new Food("Prata Plain", 1.2, new HashSet<>()));
        menu2.add(new Food("Prata Egg",1.7, new HashSet<>()));
        menu2.add(new Food("Milo Cold", 2, new HashSet<>()));
        menu2.add(new Food("Nasi Goreng Ikan Bilis",4.5, new HashSet<>()));
        menu2.add(new Food("Roti John Chicken",5.5, new HashSet<>()));
        menu2.add(new Food("Beef Pattaya",6.5, new HashSet<>()));
        menu2.add(new Food("Cheese Fries",4, new HashSet<>()));
        menu2.add(new Food("Plain Naan",1.7, new HashSet<>()));
        menu2.add(new Food("Butter Chicken Masala", 7.5, getTagSet("Small")));
        menu2.add(new Food("Butter Chicken Masala", 11, getTagSet("Large")));


        Menu menu3 = new Menu();
        HashSet<Tag> tagList2 = new HashSet<>();
        tagList2.add(new Tag("No ice"));
        menu3.add(new Food("Foie Gras Sliced Beef Roll", 18.90, new HashSet<>()));
        menu3.add(new Food("Mozzarella Corn Dog", 12.90, getTagSet("2 Piecess")));
        menu3.add(new Food("Prata Plain", 1.2, new HashSet<>()));
        menu3.add(new Food("Sausage Marinara Spaghetti",13.90, new HashSet<>()));
        menu3.add(new Food("Fusion Prawn Aglio Olio",13.90, spicyTags));
        menu3.add(new Food("Mentaiko Slide Beef Rice",7.90, spicyTags));
        menu3.add(new Food("Teriyaki Chicken Rice",7.90, spicyTags));
        menu3.add(new Food("Spicy Coney Rice",7.90, spicyTags));
        menu3.add(new Food("Japanese Kaarage Rice",7.90, spicyTags));
        menu3.add(new Food("Japanese Ebi Rice",7.90, spicyTags));


        return new Vendor[]{
            new Vendor(new Name("Al Amaan Restaurant"), new Phone("67770555"),
                        new Email("alamaanrestaurant@gmail.com"),
                        new Address("12 Clementi Road, Singapore 129742"),
                        getTagSet("halal"), menu1),
            new Vendor(new Name("Makan Express"), new Phone("91076367"), new Email("xpressmakanavenue@gmail.com"),
                        new Address("14 Clementi Roadd, Singapore 129743"),
                    getTagSet("halal"), menu2),
            new Vendor(new Name("Be Frank"), new Phone("97652509"), new Email("befrank@gmail.com"),
                        new Address("28 Clementi Road, Singapore 129754"), new HashSet<>(), menu3)
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Vendor sampleVendor : getSampleVendors()) {
            sampleAb.addVendor(sampleVendor);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
