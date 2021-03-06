package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Delete item ====");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            out.println("Delete success");
        } else {
            out.println("Delete failed!");
        }
        return true;
    }
}
