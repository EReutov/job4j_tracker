package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SortTest {

    @Test
    public void whenUpSort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "F"));
        items.add(new Item(2, "A"));
        items.add(new Item(3, "Z"));
        Collections.sort(items, new SortUpItem());
        assertThat(items.get(0).getName(), is("A"));
    }

    @Test
    public void whenDownSort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "F"));
        items.add(new Item(2, "A"));
        items.add(new Item(3, "Z"));
        Collections.sort(items, new SortDownItem());
        assertThat(items.get(0).getName(), is("Z"));
    }
}
