package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List <Topic> topics = new ArrayList<> (Arrays.asList(
			
			new Topic("Spring","Spring Framework", "Spring Framework Description"),
			new Topic("Java","Core Java", "Core Java Description"),
			new Topic("Javascript"," JavaScript", "Javascript Description ")
			
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		 for(Topic topic : topics){
		      if(topic.getId().equals(id)){
		         return topic;
		      }
		   }
		   return null;		
	}
	
	public void addTopic(Topic topic)
	{
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topicUpdate) {
		for(int i=0; i <topics.size(); i++){
		      if(topics.get(i).getId().equals(id)){
		          topics.set(i, topicUpdate);
		          return;
		      }
		   }	   	
	}
	
	
	public void deleteTopic(String id)
	{
		for(Topic topic : topics){
		      if(topic.getId().equals(id)){
		         topics.remove(topic);
		         return;
		      }
		   }
	}   
	
	
}