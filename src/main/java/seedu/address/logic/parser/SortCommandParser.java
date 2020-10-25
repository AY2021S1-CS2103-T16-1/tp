package seedu.address.logic.parser;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns an SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SortCommand parse(String args) throws ParseException {
        String trimArgs = args.trim();
        String[] argsArr = trimArgs.split(" ");
        ParserUtil.checkArgsLength(argsArr, SortCommand.COMMAND_WORD, SortCommand.MESSAGE_USAGE, 2, 2);

        String sortedBy = argsArr[0].toLowerCase();
        String ascending = argsArr[1].toLowerCase();

        if (!sortedBy.equals(SortCommand.NAME) && !sortedBy.equals(SortCommand.PRICE)) {
            throw new ParseException(SortCommand.MESSAGE_USAGE);
        }

        if (!ascending.equals("t") && !ascending.equals("f")) {
            throw new ParseException(SortCommand.MESSAGE_USAGE);
        }

        return new SortCommand(sortedBy, ascending);
    }
}