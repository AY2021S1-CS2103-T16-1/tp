package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyVendorList;
import seedu.address.model.food.Food;
import seedu.address.model.vendor.Vendor;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the VendorBook.
     *
     * @see Model#getVendorList()
     */
    ReadOnlyVendorList getVendorList();

    /** Returns an unmodifiable view of the filtered list of vendors */
    ObservableList<Vendor> getFilteredVendorList();

    /** Returns an unmodifiable view of the filtered list of foods */
    ObservableList<Food> getFilteredFoodList();

    /**
     * Returns the user prefs' address book file path.
     */
    //    Path getAddressBookFilePath();
    Path getVendorListFilePath();
    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
