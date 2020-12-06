package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC", "Install Windows"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created1 = tracker.findAll()[0];
        Item created2 = tracker.findAll()[1];
        Item expected1 = new Item("Fix PC");
        Item expected2 = new Item("Install Windows");
        assertThat(created1.getName(), is(expected1.getName()));
        assertThat(created2.getName(), is(expected2.getName()));
    }

    @Test
    public void whenEdit() {
        Tracker tracker = new Tracker();
        Item item = new Item("PC");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "PS5"};
        StartUI.editItem(new StubInput(answers), tracker);
        assertThat(tracker.findById(item.getId()).getName(), is("PS5"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("PC");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}