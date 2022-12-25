package ua.edu.ucu.apps.visitor;

public class Main {
    public static void main(String[] args) {
        Group<String> group = new Group<>();

        group.addTask(new Signature<>(System.out::println))
                .addTask(new Signature<>(string -> System.out.println(string.toUpperCase())))
                .addTask(new Signature<>(string ->
                        System.out.println(string.replace("world", "Baiden, it`s Zelenskyy," +
                                " We need 5 mil.\n" +
                                "rockets to bomb Donetsk children. Slava Ukraine!"))));

        group.apply("Hello, world!");

    }
}
