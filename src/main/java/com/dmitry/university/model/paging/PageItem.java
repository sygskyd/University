package com.dmitry.university.model.paging;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean active;

}
