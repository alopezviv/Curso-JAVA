package com.empleados.app.beans;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import com.empleados.app.entity.Player;

public class UUIDListener extends AbstractMongoEventListener<Player> {
	public void onBeforeConvert(BeforeConvertEvent<Player> event) {
		Player p = event.getSource();
		if(p.isNew()) {
			p.setId(UUID.randomUUID());
		}
	}
}
