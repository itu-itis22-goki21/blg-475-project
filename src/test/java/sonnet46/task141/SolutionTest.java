package sonnet46.task141;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals("Yes", s.filenameCheck("example.txt"));
        assertEquals("No", s.filenameCheck("1example.dll"));
        assertEquals("No", s.filenameCheck("s1sdf3.asd"));
        assertEquals("Yes", s.filenameCheck("K.dll"));
        assertEquals("Yes", s.filenameCheck("MY16FILE3.exe"));
        assertEquals("No", s.filenameCheck("His12FILE94.exe"));
        assertEquals("No", s.filenameCheck("_Y.txt"));
        assertEquals("No", s.filenameCheck("?aREYA.exe"));
        assertEquals("No", s.filenameCheck("this_is_valid.wow"));
        assertEquals("Yes", s.filenameCheck("this_is_valid.txt"));
        assertEquals("No", s.filenameCheck("all.exe.txt"));
        assertEquals("Yes", s.filenameCheck("I563_No.exe"));
        assertEquals("No", s.filenameCheck("final..txt"));
        assertEquals("No", s.filenameCheck("final132"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Empty name before dot — covers name.isEmpty() branch
        assertEquals("No", s.filenameCheck(".txt"));
        // Valid extensions
        assertEquals("Yes", s.filenameCheck("a.exe"));
        assertEquals("Yes", s.filenameCheck("a.dll"));
        // Exactly 3 digits — still valid
        assertEquals("Yes", s.filenameCheck("a123.txt"));
        // 4 digits — too many
        assertEquals("No", s.filenameCheck("a1234.txt"));
        // Empty string
        assertEquals("No", s.filenameCheck(""));
        // null input: hits the file_name == null TRUE branch of the null || isEmpty() guard
        assertEquals("No", s.filenameCheck(null));
    }
}
