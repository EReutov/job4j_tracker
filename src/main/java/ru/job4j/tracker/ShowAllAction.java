package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] result = tracker.findAll();
        for (Item i : result) {
            System.out.println(i);
        }
        return true;
    }
}
