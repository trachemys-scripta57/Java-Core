package Modul_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

public class MamaMylaRamu2 {
    public static void main(String[] args) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            buff
                    .lines().map(e -> e.toLowerCase().replaceAll("\\s*(\\s|,|!|-|\\.)\\s*", " "))
                    .flatMap(e -> Stream.of(e.split(" ")))
                    .forEach(w -> {
                        if (resultMap.containsKey(w)) {
                            resultMap.put(w, (resultMap.get(w) + 1));
                        } else {
                            resultMap.put(w, 1);
                        }
                    });

            resultMap
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        if (e1.getValue().equals(e2.getValue())) {
                            return e1.getKey().compareTo(e2.getKey());
                        } else {
                            return e2.getValue().compareTo(e1.getValue());
                        }
                    })
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
