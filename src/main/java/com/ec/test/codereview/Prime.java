package com.ec.test.codereview;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "primes")
public class Prime {

    @Id
    private int value;

    public Prime() {
    }

    public Prime(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
