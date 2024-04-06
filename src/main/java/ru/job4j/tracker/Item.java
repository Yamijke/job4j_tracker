package ru.job4j.tracker;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Item {
    private int id;
    @NonNull
    private String name;
    private LocalDateTime created = LocalDateTime.now().withNano(0);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
}
