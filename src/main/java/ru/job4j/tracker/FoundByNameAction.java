package ru.job4j.tracker;

public class FoundByNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Found items by enter name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item i : items) {
                System.out.println(i);
            }
        } else {
            System.out.println("Items not found!");
        }
        return true;
    }
}
