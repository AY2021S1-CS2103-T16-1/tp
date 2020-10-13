package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.address.model.food.Food;
import seedu.address.model.tag.Tag;

/**
 * Represents an OrderItem in the Order.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class OrderItem extends Food {
    // Identity fields
    private int quantity;

    /**
     * Every field must be present and not null.
     */
    public OrderItem(String name, double price, Set<Tag> tags, int quantity) {
        super(name, price, tags);
        requireAllNonNull(quantity);
        this.quantity = quantity;
    }

    /**
     * Alternative constructor that takes in a food item and quantity. Every field must be present and not null.
     */
    public OrderItem(Food food, int quantity) {
        super(food.getName(), food.getPrice(), food.getTags());
        requireAllNonNull(quantity);
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    /**
     * Returns true if both OrderItems of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two OrderItems.
     */
    public boolean isSameOrderItem(OrderItem orderItem) {
        if (orderItem == this) {
            return true;
        }

        return orderItem != null
                && orderItem.getName().equals(getName())
                && (orderItem.getPrice() == (getPrice()));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(super.name, super.price, super.tags, quantity);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Price: ")
                .append(getPriceString())
                .append(" Quantity: ")
                .append(getQuantity())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
