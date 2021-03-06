package com.lguplus.common.domain.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter @Setter
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    private String etc;
}
