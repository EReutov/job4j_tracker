package ru.job4j.tracker;

public class FoundByIdAction implements UserAction {
    @Override
    public String name() {
        return "Found by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Found item by id ====");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item with this id found!");
        } else {
            System.out.println("Item not found!");
        }
        return true;
    }
}
