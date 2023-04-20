package com.ispan.springbootdemoteacher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//每一個資料庫的欄位受到@Entity的控管，才可以使用hibernate
//這個Messages類別使用了@Entity註解，這代表這個類別是一個實體，將會被映射到一個資料表（在這個範例中是"messages"）中。對應的屬性（id、text、added）將會被映射到資料表中的欄位，而在這個類別中使用的@Column註解則是用來指定對應的欄位名稱和類型的。
//此外，在這個類別中也定義了一個@PrePersist註解的方法，它會在將對象保存到資料庫之前被調用，並且會在對象的added屬性為null的時候自動為其賦值。這種方式可以確保對象的屬性在保存到資料庫之前被正確地設定。
@Table(name = "test1")
public class Test1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Test1() {
	}

}
