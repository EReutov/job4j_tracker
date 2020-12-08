package ru.job4j.tracker;

public class FoundByIdAction implements UserAction {
    private final Output out;

    public FoundByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Found by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Found item by id ====");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("Item with this id found!");
        } else {
            out.println("Item not found!");
        }
        return true;
    }
}
