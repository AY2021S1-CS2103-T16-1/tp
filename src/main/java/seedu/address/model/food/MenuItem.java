package seedu.address.model.food;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import javafx.scene.image.Image;
import seedu.address.model.tag.Tag;

public class MenuItem extends Food {

    private final String filePath;

    /**
     * Every field must be present and not null.
     */
    public MenuItem (String name, double price, Set<Tag> tags, String filePath) {
        super(name, price, tags);
        this.filePath = filePath;
    }

    @Override
    public Set<Tag> getTags() {
        return this.tags;
    }

    public String getFilePath() {
        return filePath;
    }

    public Image getImage() throws FileNotFoundException {
        return new Image(new FileInputStream(filePath));
    }
}
