package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {
    @Test
    public void testSetNoteAndGetNoteValueSetsAndGetsValue()
    {
        Note note = new Note();
        note.setValue(33);
        assertEquals(note.getValue(), 33);
    }

    @Test
    public void testSetNoteAndGetNoteValueActuallyRwturnsCorrectly()
    {
        Note note = new Note();
        note.setValue(43);
        assertNotEquals(note.getValue(), 5);
    }

    @Test
    public void testAddNoteToTheBagWorks()
    {
        Note note = new Note();
        note.setValue(45);
        Bag bag = new Bag();
        bag.add(note);

        // lets assert that the note object has been stored
        assertEquals(bag.getBag().get(0), note);
        Note note2 = new Note();
        note2.setValue(90);
        bag.add(note2);
        // confirm that indeed the next note was added and it defers with the first
        assertNotEquals(bag.getBag().get(0), note2);
    }

}