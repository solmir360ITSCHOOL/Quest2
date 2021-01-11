package net.rsnode.quest;

import android.view.View;

public class Story {
    private Situation start_story;
    public Situation current_situation;
    private MainActivity m;

    Story(MainActivity m) {
        this.m = m;
        start_story = new Situation(
                "неизвестность",
                "Вы попали в старый замок, и вам надо выбраться. Вы видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                3, 0, 0, 0);
        start_story.direction[1] = new Situation(
                "удача",
                "Вы нашли мешок с золотом! Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                3, 0, 0, 10);
        start_story.direction[2] = new Situation(
                "конец",
                "",
                0, 0, 0, 0);

        start_story.direction[0].direction[0] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);
        start_story.direction[0].direction[1] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);
        start_story.direction[0].direction[2] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);

        start_story.direction[1].direction[0] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);
        start_story.direction[1].direction[1] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);
        start_story.direction[1].direction[2] = new Situation(
                "ничего не обычного",
                "Вы снова видете 3 двери\n"
                        + "(1)пойти в первую дверь\n"
                        + "(2)пойти во вторую дверь\n"
                        + "(3)пойти в третью дверь ",
                0, 0, 0, 0);

        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length) {
            current_situation = current_situation.direction[num - 1];
            for(int i = 0; i < 3; i++){
                if (i < current_situation.direction.length) {
                    m.choices[i].setVisibility(View.VISIBLE);
                    m.choices[i].setText(Integer.toString(i + 1));
                } else {
                    m.choices[i].setVisibility(View.INVISIBLE);
                }
            }
        }
        else
            m.console.setText("Ошибочка! Вы можете выбирать только из "
                    + current_situation.direction.length + " вариантов");
    }
    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}