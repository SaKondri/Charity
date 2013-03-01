package com.friends.charity.model.farzand;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PESAR")
@PrimaryKeyJoinColumn(name="ID")
public class Pesar extends Farzandan {

}
