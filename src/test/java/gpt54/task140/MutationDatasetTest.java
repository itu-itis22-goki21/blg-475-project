package gpt54.task140;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals("Example", s.fixSpaces("Example")),
                () -> assertEquals("One_Two", s.fixSpaces("One Two")),
                () -> assertEquals("Mudasir_Hanif_", s.fixSpaces("Mudasir Hanif ")),
                () -> assertEquals("Yellow_Yellow__Dirty__Fellow", s.fixSpaces("Yellow Yellow  Dirty  Fellow")),
                () -> assertEquals("Exa-mple", s.fixSpaces("Exa   mple")),
                () -> assertEquals("-Exa_1_2_2_mple", s.fixSpaces("   Exa 1 2 2 mple"))
        );
    }
}
