package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] rsl = items;
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                rsl[size++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = items;
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item != null && item.getName().equals(key)) {
                rsl[size++] = items[i];
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index] != null && items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        } else
            return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if(index != -1) {
            System.arraycopy(items, index + 1, items, index, size - 1 - index);
            items[size - 1] = null;
            return true;
        } else return false;
    }

}