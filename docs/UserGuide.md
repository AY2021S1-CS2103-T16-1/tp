# User Guide for Supper Striker

## Commands

**Supper Strikers is a desktop application for managing your supper orders.** While it has a GUI (Graphical User Interface), most of the user interactions happen using a CLI (Command Line Interface).

* Table of Contents
{coming soon}

1. Download the latest `supperstrikers.jar` from [here](https://github.com/AY2021S1-CS2103-T16-1/tp/releases).

1. Copy the jar to the folder you want to use as the _home folder_ for your SupperStrikers.

1. Double-click the jar to start the app. The GUI similar to the one below should appear in a few seconds.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`vendor`** : List all the vendors available.

   * **`vendor i/1`** : Select the first vendor to make a supper order for.

   * **`create`** : Creates a new supper order.

   * **`add i/1 q/1`** : Adds one quantity of the first item from the vendor's menu to your supper menu.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>


### Getting Started: `help`

Shows the user instructions on how to use the application.


### View/select vendor: `vendor`

Shows the list of vendor. If an index is specified, that vendor is selected.

Format: `vendor INDEX`

Examples:
* `vendor 2` Selects the 2<sup>nd</sup> vendor in the list


### Displaying supper menu: `menu`

Shows the menu from the current selected vendor

Format: `menu


### Adding a food item: `add`

Adds a new food item for the user according to the index from the menu

Format: `add INDEX [QUANTITY]`

Examples:
* `add 1 1` add 1 quantity of item at index 1
* `add 2 3` add 3 quantity of item at index 2
* `add 1` add 1 quantity of item at index 1


### Removing an item : `remove`

Removes the specified item from the supper order.

Format: `remove INDEX [QUANTITY]`

* Removes the item at the specified `INDEX` of the user's supper order.
* Quantity can be specified to indicate the number of item to be deleted. Otherwise, it deletes all the item's quantity.
* The index refers to the index number shown in the displayed supper order list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `delete 2` deletes the second item in the supper order.
* `delete 1 2` deletes 2 instances of the first item in the supper order.


### Display total: 'total'

Displays the price of the current order

Format: `total`

### Submit the order: 'submit'

Displays the current order along with its total price

Format: `submit`

### Other features `[coming soon]`

_{coming soon}_

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Overwrite your current data file with your old data file.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Help**   | `help`
**Vendor** | `vendor INDEX` <br> e.g., `vendor 2`
**Menu**   | `menu` <br> e.g., `menu`
**Total** | `total` <br> e.g., `total`
**Add**    | `add INDEX [QUANTITY]` <br> e.g., `add 2 2`
**Delete** | `delete INDEX [QUANTITY]`<br> e.g., `delete 3 1`
**Submit**| `submit` <br> e.g., `submit`
