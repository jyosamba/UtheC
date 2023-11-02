package com.UtheC2.UtheC2.DTO;

import com.UtheC2.UtheC2.Entities.BooksEntity;

import java.util.List;

public class BasketDTO {

    private List<BooksEntity> basket;


    public void setBasket(List<BooksEntity> basket){
        this.basket = basket;
    }
    public List<BooksEntity>getBasket(){
        return basket;
    }
}
