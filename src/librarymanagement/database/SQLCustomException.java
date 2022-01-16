package librarymanagement.database;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom SQL Exceptions
 */

@SuppressWarnings("serial")
public class SQLCustomException extends SQLException {
		  public static final Map<Integer, String> errors;

		  static {
		    errors = new HashMap<Integer, String>();
		    // Declare all the errors here
		    errors.put(401, "NON-EXISTENT/INVALID Author Id");
		    errors.put(402, "NON-EXISTENT/INVALID ISBN");
		    errors.put(403, "NON-EXISTENT/INVALID Borrower Id");
		    errors.put(404, "NON-EXISTENT/INVALID Category Id");
		    errors.put(405, "NON-EXISTENT/INVALID Staff Id");
		    errors.put(406, "NON-EXISTENT/INVALID Student Id");
		    errors.put(409, "Returned Date cannot be in the future");
		    errors.put(410, "Username already exists");
		    errors.put(411, "Author Id already exists");
		    errors.put(412, "ISBN already exists");
		    errors.put(413, "Borrower Id already exists");
		    errors.put(414, "Category Id already exists");
		    errors.put(415, "Staff Id already exists");
		    errors.put(416, "Student Id already exists");
		    errors.put(460, "Invalid Input");

		  }

		  /**
		   * Throws an error corresponding to the supplied error code
		   */
		  public SQLCustomException(int code) {
		    super(constructMessage(code));
		  }

		  /**
		   * Gets the error message from the error code
		   */
		  private static String constructMessage(int code) {
		    if (!errors.containsKey(code)) {
		      return String.format("Unknown error code: %s", code);
		    }

		    return errors.get(code);
		  }
		}
