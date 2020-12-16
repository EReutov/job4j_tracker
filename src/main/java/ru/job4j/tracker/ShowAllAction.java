package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all";
    }



    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Show all items ====");
        List<Item> result = tracker.findAll();
        for (Item i : result) {
            out.println(i);
        }
        return true;
    }

    public Output getOut() {
        return out;
    }
}
