package com.green.greengram.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram.common.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@EqualsAndHashCode
public class Paging {
    @Schema(example = "1", description = "Selected Page")
    private int page;
    @Schema(example = "30", description = "item count per page")
    private int size;
    @JsonIgnore
    private int startIdx;

    public Paging(Integer page, Integer size) {
        this.page = (page == null || page <= 0) ? 1 : page;
        this.size = (size == null || size <= 0) ? Constants.getDefault_page_size() : size;
        this.startIdx = ( this.page - 1 ) * this.size;
    }
}
