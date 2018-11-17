package info;

import java.io.Serializable;
import java.util.*;

public class Graph implements Serializable {
	
	private int people;
	private LinkedList<LinkedList<String>> relations;
	private HashMap<String, Integer> peopleList;

	public Graph() {
		
		relations = new LinkedList<>();
		peopleList = new HashMap<>();
		
	}

	public void addPerson(String person) {
		
		peopleList.put(person, people);
		++people;
		relations.add(new LinkedList<>());
	
	}

	public void addFriend(String person, String friend) {
		
		relations.get(peopleList.get(person)).add(friend);
		relations.get(peopleList.get(friend)).add(person);
		
	}

	public LinkedList<String> getFriendList(String person) {
		
		return relations.get(peopleList.get(person));
		
	}

	public LinkedList<String> getAllPeople() {

	    LinkedList<String> tempList = new LinkedList<>();
	    tempList.addAll(peopleList.keySet());
	    return tempList;

    }

	public boolean personExists(String person) {
		
		Set<String> tempPeopleList = peopleList.keySet();
		for (String i : tempPeopleList) {
			if (i.equals(person)) {
				return true;
			}
		}
		
		return false;
		
	}

	public boolean connectionExists(String person, String friend) {
		
		if (!personExists(person) || !personExists(friend)) {
			return false;
		}
		
		return connectionExistsHelper(person, friend);
		
	}

	private boolean connectionExistsHelper(String person, String friend) {
		
		boolean[] visited = new boolean[people];
		Queue<String> queue = new LinkedList<>();
		
		String source = person;
		
		visited[peopleList.get(source)] = true;
		queue.add(source);
		
		while (!queue.isEmpty()) {
			
			source = queue.poll();
			
			if (source.equals(friend)) {
				return true;
			}
			
			Iterator<String> counter = relations.get(peopleList.get(source)).listIterator();
			while (counter.hasNext()) {
				
				String temp = counter.next();
				
				if (!visited[peopleList.get(temp)]) {
					visited[peopleList.get(temp)] = true;
					queue.add(temp);
				}
				
			}
			
		}
		
		return false;
		
	}

	public LinkedList<ArrayList<String>> showConnection(String person, String friend) {
		
		if (!connectionExists(person, friend)) {
			return null;
		}
		
		boolean[] visited = new boolean[people];
		ArrayList<String> pathList = new ArrayList<>();
		LinkedList<ArrayList<String>> totalPaths = new LinkedList<>();
		
		pathList.add(person);
		
		showConnectionHelper(person, friend, visited, pathList, totalPaths);
		
		return totalPaths;
		
	}
	
	private void showConnectionHelper(String person, String friend, boolean[] visited, ArrayList<String> pathList, LinkedList<ArrayList<String>> totalPaths) {
		
		visited[peopleList.get(person)] = true;
		
		if (person.equals(friend)) {
			
			totalPaths.addLast(new ArrayList<>());
			for (String i : pathList) {
				totalPaths.getLast().add(i);
			}
			
		}
		
		for (String i : relations.get(peopleList.get(person))) {
			if (!visited[peopleList.get(i)]) {
				
				pathList.add(i);
				showConnectionHelper(i, friend, visited, pathList, totalPaths);
				pathList.remove(i);
				
			}
		}
		
		visited[peopleList.get(person)] = false;
		
	}
	
}
