import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LegacyRulesCompatibilityTest {
    @Test
    void legacyFacadeUsesTheModernHandScoring() {
        RegrasBJ hand = new RegrasBJ(new String("As"), new String("9"));
        hand.CardHit(new String("2"));

        assertEquals(12, hand.GetCardTotal());
        assertTrue(!hand.CheckBust());
    }
}
