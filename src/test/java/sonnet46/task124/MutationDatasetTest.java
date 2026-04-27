package sonnet46.task124;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertTrue(s.validDate("03-11-2000")),
                () -> assertFalse(s.validDate("15-01-2012")),
                () -> assertFalse(s.validDate("04-0-2040")),
                () -> assertTrue(s.validDate("06-04-2020")),
                () -> assertTrue(s.validDate("01-01-2007")),
                () -> assertFalse(s.validDate("03-32-2011")),
                () -> assertFalse(s.validDate("")),
                () -> assertFalse(s.validDate("04-31-3000")),
                () -> assertTrue(s.validDate("06-06-2005")),
                () -> assertFalse(s.validDate("21-31-2000")),
                () -> assertTrue(s.validDate("04-12-2003")),
                () -> assertFalse(s.validDate("04122003")),
                () -> assertFalse(s.validDate("20030412")),
                () -> assertFalse(s.validDate("2003-04")),
                () -> assertFalse(s.validDate("2003-04-12")),
                () -> assertFalse(s.validDate("04-2003")),
                () -> assertTrue(s.validDate("01-31-2001")),
                () -> assertTrue(s.validDate("04-30-2001")),
                () -> assertTrue(s.validDate("02-29-2001")),
                () -> assertFalse(s.validDate("02-30-2001")),
                () -> assertFalse(s.validDate("02-31-2001")),
                () -> assertFalse(s.validDate("00-10-2001")),
                () -> assertFalse(s.validDate(null)),
                () -> assertThrows(Throwable.class, () -> Solution.class.getDeclaredMethod("validDate", String.class).invoke(s, 12345))
        );
    }
}
