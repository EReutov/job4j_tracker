package ru.job4j.tracker;

import java.util.List;

public class FoundByNameAction implements UserAction {
    private final Output out;

    public FoundByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Found by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Found items by enter name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item i : items) {
                out.println(i);
            }
        } else {
            out.println("Items not found!");
        }
        return true;
    }
}
