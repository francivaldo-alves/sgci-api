package com.f3pro.sgci.schema;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort.Direction;

public class FilterPageable{
    @NotNull
   private Integer page;
    @NotNull
    private  Integer size;
    @NotNull
    private Direction direction;
    @NotNull
    private String ordenarPo;

    public @NotNull Integer getPage() {
        return page;
    }

    public void setPage(@NotNull Integer page) {
        this.page = page;
    }

    public @NotNull Integer getSize() {
        return size;
    }

    public void setSize(@NotNull Integer size) {
        this.size = size;
    }

    public @NotNull Direction getDirection() {
        return direction;
    }

    public void setDirection(@NotNull Direction direction) {
        this.direction = direction;
    }

    public @NotNull String getOrdenarPo() {
        return ordenarPo;
    }

    public void setOrdenarPo(@NotNull String ordenarPo) {
        this.ordenarPo = ordenarPo;
    }
}

