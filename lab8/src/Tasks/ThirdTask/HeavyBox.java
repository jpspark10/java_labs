package Tasks.ThirdTask;

import java.util.function.Consumer;

public class HeavyBox {

    private int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
        System.out.println("heavy box has created");
    }

    private static final Consumer<HeavyBox> printWeightMessage = (box) -> System.out.println("Отгрузили ящик с весом " + box.weight + " кг");

    public void shipWithMessage() {
        System.out.println("Отправляем ящик с весом " + weight + " кг");
        printWeightMessage.andThen(box -> System.out.println("Обработка ящика завершена")).accept(this); // Цепочка обработчиков
    }

}
