package com.rks.springbootstater.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topices = new ArrayList<>(Arrays.asList(
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("hibernate", "Hibernate Framework", "Hibernate Framework Description")
			));
	
	public List<Topic> getAllTopics(){
		return topices;
	}
	
	public Topic getTopic(String id) {
		return topices.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTpopic(Topic topic) {
		topices.add(topic);
	}

	public void updateTpopic(Topic topic, String id) {

		for (int i = 0; i < topices.size(); i++) {
			Topic t = topices.get(i);
			if (t.getId().equals(id)) {
				topices.set(i, topic);
				return;
			}
		}

	}

	public void deleteTopic(String id) {
		topices.removeIf(t -> t.getId().equals(id));
	}
}
