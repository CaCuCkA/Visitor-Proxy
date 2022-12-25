package ua.edu.ucu.apps.visitor;

import java.util.Map;

public interface Visitor<T> {
    Map<String, String> onSignature(Task<T> task);

    Map<String, String> onGroupStart(Task<T> task);

    Map<String, String> onGroupEnd(Task<T> task);
}
