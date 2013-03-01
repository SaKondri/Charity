package com.friends.charity.model.farzand;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DOKHTAR")
@PrimaryKeyJoinColumn(name="ID")
public class Dokhtar extends Farzandan {
	
}
