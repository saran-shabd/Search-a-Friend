package info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
			
			Graph g = new Graph();
			
			int choice = 7;
			
			do {
				
				System.out.println("1. create new person");
				System.out.println("2. create a friend of an existing person");
				System.out.println("3. view friend list of an existing person");
				System.out.println("4. check connection");
				System.out.println("5. show connection");
				System.out.println("6. view all people");
				System.out.println("7. exit\n");
				
				System.out.print("Enter your choice : ");
				
				boolean flag = false;			
				while (!flag) {
					try {
						choice = Integer.parseInt(buffReader.readLine());
						flag = true;
					} catch (NumberFormatException e) {
						System.out.println("Enter a number this time\n");
					}
				}
				
				switch (choice) {
					
					case 1 :
						System.out.print("Enter name of the new person : ");
						String tempPerson = buffReader.readLine();

						if (g.personExists(tempPerson)) {
							System.out.println("Person with same name already exists");
							continue;
						}

						g.addPerson(tempPerson);
						break;
				
					case 2 :
						System.out.print("Enter name of the person : ");
						tempPerson = buffReader.readLine();

						if (!g.personExists(tempPerson)) {
							System.out.println("No such person exists");
							continue;
						}

						System.out.print("Enter name of the friend : ");
						String tempFriend = buffReader.readLine();

						if (!g.personExists(tempFriend)) {
							System.out.println("No such person exists");
							continue;
						}

						g.addFriend(tempPerson, tempFriend);
						break;
				
					case 3 :
						System.out.print("Enter name of the person : ");
						tempPerson = buffReader.readLine();

						if (!g.personExists(tempPerson)) {
							System.out.println("No such person exists");
							continue;
						}

						LinkedList<String> tempFriendList = g.getFriendList(tempPerson);
						for (String tempFriends : tempFriendList) {
							System.out.print(tempFriends + ", ");
						}
						System.out.println();
						break;
							
					case 4 :
						System.out.print("Enter name of the person : ");
						tempPerson = buffReader.readLine();

						if (!g.personExists(tempPerson)) {
							System.out.println("No such person exists");
							continue;
						}

						System.out.print("Enter name of the friend : ");
						tempFriend = buffReader.readLine();

						if (!g.personExists(tempFriend)) {
							System.out.println("No such person exists");
							continue;
						}

						if (g.connectionExists(tempPerson, tempFriend)) {
							System.out.println("Connection exists");
						} else {
							System.out.println("Connection does not exists");
						}

						break;
							
					case 5 :
						System.out.print("Enter name of the person : ");
						tempPerson = buffReader.readLine();

						if (!g.personExists(tempPerson)) {
							System.out.println("No such person exists");
							continue;
						}

						System.out.print("Enter name of the friend : ");
						tempFriend = buffReader.readLine();

						if (!g.personExists(tempFriend)) {
							System.out.println("No such person exists");
							continue;
						}

						LinkedList<ArrayList<String>> connection = g.showConnection(tempPerson, tempFriend);
						for (ArrayList<String> counter : connection) {
							for (String i : counter) {
								System.out.print(i + " <-> ");
							}
							System.out.println();
						}

						break;

					case 6 :
					    LinkedList<String> allPeopleList = g.getAllPeople();
					    for (String counter : allPeopleList) {
                            System.out.print(counter + " ");
                        }
                        System.out.println();
                        break;
					
					case 7 :
						System.out.println("Exiting...");
						break;
							
					default :
						System.out.println("Enter a valid choice this time");

				}
				
			} while (7 != choice);
			
			buffReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
