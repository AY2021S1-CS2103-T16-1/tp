package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.food.Food;
import seedu.address.model.menu.MenuManager;
import seedu.address.model.menu.ReadOnlyMenuManager;
import seedu.address.model.vendor.Vendor;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final VendorBook vendorList;
    private final List<MenuManager> menuManagers;
    private final UserPrefs userPrefs;
    private final FilteredList<Vendor> filteredVendors;
    private FilteredList<Food> filteredFoods;
    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyVendorList vendorList, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(vendorList, userPrefs);

        logger.fine("Initializing with address book: " + vendorList + " and user prefs " + userPrefs);

        this.vendorList = new VendorBook(vendorList);
        this.menuManagers = new ArrayList<>();
        this.userPrefs = new UserPrefs(userPrefs);
        filteredVendors = new FilteredList<>(this.vendorList.getVendorList());

    }

    /**
     * Initializes a ModelManager with the given addressBook, userPrefs and menuManager.
     */
    public ModelManager(ReadOnlyVendorList vendorList, ReadOnlyUserPrefs userPrefs, List<MenuManager> menuManagers) {
        super();
        requireAllNonNull(vendorList, userPrefs, menuManagers);

        logger.fine("Initializing with address book: " + vendorList + " and user prefs " + userPrefs);

        this.vendorList = new VendorBook(vendorList);
        this.userPrefs = new UserPrefs(userPrefs);
        this.menuManagers = menuManagers;
        filteredVendors = new FilteredList<>(this.vendorList.getVendorList());
    }

    public ModelManager() {
        this(new VendorBook(), new UserPrefs(), new ArrayList<>());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getVendorListFilePath() {
        return userPrefs.getVendorListFilePath();
    }

    @Override
    public void setVendorListFilePath(Path vendorListFilePath) {
        requireNonNull(vendorListFilePath);
        userPrefs.setAddressBookFilePath(vendorListFilePath);
    }

    @Override
    public Path getMenuManagerFolderPath() {
        return userPrefs.getMenuManagerFolderPath();
    }

    @Override
    public void setMenuManagerFolderPath(Path menuManagerFolderPath) {
        requireNonNull(menuManagerFolderPath);
        userPrefs.setAddressBookFilePath(menuManagerFolderPath);
    }


    //=========== AddressBook ================================================================================

    @Override
    public void setVendorList(ReadOnlyVendorList addressBook) {
        this.vendorList.resetData(addressBook);
    }

    @Override
    public ReadOnlyVendorList getVendorList() {
        return vendorList;
    }

    @Override
    public boolean hasVendor(Vendor vendor) {
        requireNonNull(vendor);
        return vendorList.hasVendor(vendor);
    }

    @Override
    public void deleteVendor(Vendor target) {
        vendorList.removeVendor(target);
    }

    @Override
    public void addVendor(Vendor vendor) {
        vendorList.addVendor(vendor);
        updateFilteredVendorList(PREDICATE_SHOW_ALL_VENDORS);
    }

    @Override
    public void setVendor(Vendor target, Vendor editedVendor) {
        requireAllNonNull(target, editedVendor);

        vendorList.setVendor(target, editedVendor);
    }

    @Override
    public void setMenuManager(ReadOnlyMenuManager menuManager, int index) {
        this.menuManagers.get(index).resetData(menuManager);
    }

    @Override
    public ReadOnlyMenuManager getMenuManager(int index) {
        return menuManagers.get(index);
    }

    @Override
    public boolean hasFood(Food food, int index) {
        requireNonNull(food);
        return menuManagers.get(index).hasFood(food);
    }

    @Override
    public void deleteFood(Food target, int index) {
        menuManagers.get(index).removeFood(target);
    }

    @Override
    public void addFood(Food food, int index) {
        menuManagers.get(index).addFood(food);
        updateFilteredFoodList(PREDICATE_SHOW_ALL_FOODS, index);
    }

    @Override
    public void setFood(Food target, Food editedFood, int index) {
        requireAllNonNull(target, editedFood);

        menuManagers.get(index).setFood(target, editedFood);
    }

    //=========== Filtered Vendor List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Vendor} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Vendor> getFilteredVendorList() {
        return filteredVendors;
    }

    @Override
    public void updateFilteredVendorList(Predicate<Vendor> predicate) {
        requireNonNull(predicate);
        filteredVendors.setPredicate(predicate);
    }

    @Override
    public ObservableList<Food> getFilteredFoodList(int index) {
        if (filteredFoods == null) {
            updateFilteredFoodList(PREDICATE_SHOW_ALL_FOODS, index);
        }
        return filteredFoods;
    }

    @Override
    public void updateFilteredFoodList(Predicate<Food> predicate, int index) {
        if (!this.menuManagers.isEmpty()) {
            filteredFoods = new FilteredList<>(this.menuManagers.get(index).getFoodList());
        }
    }


    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return vendorList.equals(other.vendorList)
                && userPrefs.equals(other.userPrefs)
                && filteredVendors.equals(other.filteredVendors);
    }

}
