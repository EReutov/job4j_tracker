package ru.job4j.tracker;

public class FoundByNameAction implements UserAction {
    @Override
    public String name() {
        return "Found by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Found items by enter name ====");
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
