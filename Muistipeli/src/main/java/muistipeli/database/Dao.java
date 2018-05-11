

package muistipeli.database;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * Dao luokka.
 */
interface Dao<T, K> {
    T bestScore(String gamemode) throws SQLException;
    boolean saveScore(T object) throws SQLException;

}
