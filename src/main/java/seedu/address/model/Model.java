package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.food.Food;
import seedu.address.model.menu.ReadOnlyMenuManager;
import seedu.address.model.order.OrderItem;
import seedu.address.model.order.ReadOnlyOrderManager;
import seedu.address.model.vendor.Vendor;


/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Vendor> PREDICATE_SHOW_ALL_VENDORS = unused -> true;
    Predicate<Food> PREDICATE_SHOW_ALL_FOODS = unused -> true;
    Predicate<OrderItem> PREDICATE_SHOW_ALL_ORDERITEMS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' menu manager file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getMenuManagerFolderPath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setMenuManagerFolderPath(Path menuManagerFolderPath);

    /**
     * Replaces menu manager data with the data in {@code menuManager}.
     */

    void setAddressBook(ReadOnlyAddressBook addressBook);

    /**
     * Returns the AddressBook
     */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a vendor with the same identity as {@code vendor} exists in the address book.
     */
    boolean hasVendor(Vendor vendor);

    /**
     * Deletes the given vendor.
     * The vendor must exist in the address book.
     */
    void deleteVendor(Vendor target);

    /**
     * Adds the given vendor.
     * {@code vendor} must not already exist in the address book.
     */
    void addVendor(Vendor vendor);

    /**
     * Replaces the given vendor {@code target} with {@code editedVendor}.
     * {@code target} must exist in the address book.
     * The vendor identity of {@code editedVendor} must not be the same as another existing vendor in the address book.
     */
    void setVendor(Vendor target, Vendor editedVendor);

    /**
     * Replaces address book data with the data in {@code menuManager}.
     */
    void setMenuManager(ReadOnlyMenuManager menuManager, int index);

    /**
     * Returns the MenuManager at the ith index
     */
    ReadOnlyMenuManager getMenuManager(int index);

    /**
     * Returns true if a food with the same identity as {@code food} exists in the address book.
     */
    boolean hasFood(Food food, int index);

    /**
     * Deletes the given food.
     * The food must exist in the menu manager.
     */
    void deleteFood(Food target, int index);

    /**
     * Adds the given food.
     * {@code food} must not already exist in the menu manager.
     */
    void addFood(Food food, int index);

    /**
     * Replaces the given food {@code target} with {@code editedFood}.
     * {@code target} must exist in the menu manager.
     * The food identity of {@code editedFood} must not be the same as another existing food in the address book.
     */
    void setFood(Food target, Food editedFood, int index);

    /**
     * Replaces address book data with the data in {@code orderManager}.
     */
    void setOrderManager(ReadOnlyOrderManager orderManager);

    /**
     * Returns the MenuManager at the ith index
     */
    ReadOnlyOrderManager getOrderManager();

    /**
     * Returns true if an orderItem with the same identity as {@code orderItem} exists in the address book.
     */
    boolean hasOrderItem(OrderItem orderItem);

    /**
     * Deletes the given orderItem.
     * The orderItem must exist in the order manager.
     */
    void deleteOrderItem(OrderItem target);

    /**
     * Adds the given orderItem.
     * {@code orderItem} if orderItem exists in order manageradd to the current quantity.
     */
    void addOrderItem(OrderItem orderItem);

    /**
     * Replaces the given OrderItem {@code target} with {@code editedOrderItem}.
     * {@code target} must exist in the menu manager.
     * The OrderItem identity of {@code editedOrderItem}
     * must not be the same as another existing orderItem in the address book.
     */
    void setOrderItem(OrderItem target, OrderItem editedOrderItem);

    /**
     * Returns an unmodifiable view of the filtered vendor list
     */
    ObservableList<Vendor> getFilteredVendorList();


    /**
     * Updates the filter of the filtered vendor list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredVendorList(Predicate<Vendor> predicate);

    /**
     * Returns an unmodifiable view of the filtered food list at the corresponding index
     */
    ObservableList<Food> getFilteredFoodList(int index);

    /**
     * Clears the order.
     */
    void clearOrder();


    /**
     * Updates the filter of the filtered food list at the corresponding index to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredFoodList(Predicate<Food> predicate, int index);

    /**
     * Returns an unmodifiable view of the filtered orderItem list at the corresponding index
     */
    ObservableList<OrderItem> getFilteredOrderItemList();

    public int getOrderSize();

    /**
     * Updates the filter of the filtered orderItem list at the
     * corresponding index to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredOrderItemList(Predicate<OrderItem> predicate);
}
