package com.ms.mongo.msmongoservice.models;

import org.bson.types.ObjectId;

public class Pet {
	
	private ObjectId _id;
	private String name;
	private String type;
	
	public Pet() {
		super();
	}

	
	
	public Pet(ObjectId _id, String name, String type) {
		super();
		this._id = _id;
		this.name = name;
		this.type = type;
	}



	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
