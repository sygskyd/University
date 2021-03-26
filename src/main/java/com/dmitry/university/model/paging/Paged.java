package com.dmitry.university.model.paging;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Paged<T> {

    private Page<T> page;
    private Paging paging;

}
