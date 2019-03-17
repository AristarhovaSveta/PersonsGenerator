package core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Table {
    private String[] headers;
    private String[][] rows;
}
