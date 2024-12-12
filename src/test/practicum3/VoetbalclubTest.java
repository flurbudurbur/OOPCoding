package practicum3;

import dev.flur.practicum2.Voetbalclub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VoetbalclubTest {

    @Test
    public void testClubNaamNull__StringFC() {
        Voetbalclub v = new Voetbalclub(null);
        assertEquals("FC", v.getNaam());
    }

    @Test
    public void testClubNaamGeenInput__StringFC() {
        Voetbalclub v = new Voetbalclub();
        assertEquals("FC", v.getNaam());
    }

    @Test
    public void testClubNaamLegeString__StringFC() {
        Voetbalclub v = new Voetbalclub("");
        assertEquals("FC", v.getNaam());
    }

    @Test
    public void testClubNaamStringMetSpatie__StringFC() {
        Voetbalclub v = new Voetbalclub(" ");
        assertEquals("FC", v.getNaam());
    }

    @Test
    public void testClubNaamStringClub__StringClub() {
        Voetbalclub v = new Voetbalclub("Club");
        assertEquals("Club", v.getNaam());
    }

    @Test
    public void testAantalWedstrijdenGewonnen__int1() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('w');
        assertEquals(1, v.getAantalGewonnen());
    }

    @Test
    public void testAantalWedstrijdenVerloren__int1() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('v');
        assertEquals(1, v.getAantalVerloren());
    }

    @Test
    public void testAantalWedstrijdenGelijk__int1() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('g');
        assertEquals(1, v.getAantalGelijk());
    }

    @Test
    public void testAantalWedstrijdenGespeeldFoutieveInvoer__int0() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('x');
        assertEquals(0, v.aantalGespeeld());
    }

    @Test
    public void testAantalWedstrijdenGespeeldGeenInvoer__int0() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat(' ');
        assertEquals(0, v.aantalGespeeld());
    }

    @Test
    public void testVerwerkResultaatX__StringFC00000() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('x');
        assertEquals("FC 0 0 0 0 0", v.toString());
    }

    @Test
    public void testVerwerkResultaatW__StringFC11003() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('w');
        assertEquals("FC 1 1 0 0 3", v.toString());
    }

    @Test
    public void testVerwerkResultaatV__StringFC10010() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('v');
        assertEquals("FC 1 0 0 1 0", v.toString());
    }

    @Test
    public void testVerwerkResultaatG__StringFC10101() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('g');
        assertEquals("FC 1 0 1 0 1", v.toString());
    }

    @Test
    public void testVerwerkResultaatLeeg__FC00000() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat(' ');
        assertEquals("FC 0 0 0 0 0", v.toString());
    }

    @Test
    public void testHerhaaldelijkAantalWWW__StringFC33009() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('w');
        v.verwerkResultaat('w');
        v.verwerkResultaat('w');
        assertEquals("FC 3 3 0 0 9", v.toString());
    }

    @Test
    public void testHerhaaldelijkAantalVVV__StringFC33000() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('v');
        v.verwerkResultaat('v');
        v.verwerkResultaat('v');
        assertEquals("FC 3 0 0 3 0", v.toString());
    }

    @Test
    public void testHerhaaldelijkAantalGGG__StringFC30303() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('g');
        v.verwerkResultaat('g');
        v.verwerkResultaat('g');
        assertEquals("FC 3 0 3 0 3", v.toString());
    }

    @Test
    public void testHerhaaldelijkAantalWGV__StringFC31114() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('w');
        v.verwerkResultaat('g');
        v.verwerkResultaat('v');
        assertEquals("FC 3 1 1 1 4", v.toString());
    }

    @Test
    public void testHerhaaldelijkAantalWVX__StringFC21013() {
        Voetbalclub v = new Voetbalclub();
        v.verwerkResultaat('w');
        v.verwerkResultaat('v');
        v.verwerkResultaat('x');
        assertEquals("FC 2 1 0 1 3", v.toString());
    }
}
