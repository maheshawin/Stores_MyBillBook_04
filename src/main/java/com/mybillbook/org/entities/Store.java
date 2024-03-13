package com.mybillbook.org.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	private String storeType;
	private String storeName;
	private String Address;
	private String gstNo;
	private String userId;
	public Store(String storeType, String storeName, String address, String gstNo, String userId) {
		super();
		this.storeType = storeType;
		this.storeName = storeName;
		Address = address;
		this.gstNo = gstNo;
		this.userId = userId;
	}
	
	

	
	
}
