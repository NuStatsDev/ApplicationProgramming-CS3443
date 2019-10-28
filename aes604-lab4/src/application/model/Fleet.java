package application.model;

import javafx.scene.image.Image;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Fleet
 * Description: Class that defines what a fleet is, every fleet needs a name and holds Starships that hold crew members
 */
public class Fleet{

		/*  	To initialized, a Fleet object must have a name. In addition,
				every Fleet has an ArrayList of Starship objects.
				The Fleet will be the access point for the data in the remainder of the app.
				The controller will call on methods in the Fleet class to access
				starship names, crew member information, and to load data in the files. 		*/

	private ArrayList<Starship> strshps = new ArrayList<Starship>();
	private String name="";
	private static String validatedUser="";


	/**
	 * Name: Fleet()
	 * Description: Contructor that takes in the needed name to set the name for the fleet
	 * @param name
	 */
	public Fleet(String name) throws IOException {
		this.name=name;
	}


	/**
	 * Name: getName()
	 * Description: gets the name of the desired fleet
	 * @return
	 */
	public String getName() {
		return name;
	}

	public String getValidatedUser(){
		return  validatedUser;
	}

	public void setValidatedUser(String validatedUser) {
		this.validatedUser = validatedUser;
	}

	/**
	 * Name:getStarships()
	 * Descriptio: Gets all the starships with the same name and returns a string representation of them
	 * @param usrinput
	 * @return
	 *
	 */
	public String getRequestedStarships(String usrinput){
		String StarShips="";
		for(int i=0;i<strshps.size();i++){
			if(strshps.get(i).getName().equals(usrinput)){
				StarShips+=strshps.get(i).toString() +"\n";
			}
		}
		if(!StarShips.isEmpty()){
			return StarShips;
		}
		else {
			return "Error: Incorrect Input";
		}
	}


public Starship getStarshipCap(String caplastname){
	Starship tmpship = new Starship();
	String tmpRegistry="";
	for( Starship ships : getStrshps()){
		tmpRegistry=ships.getRegistry();
		for(CrewMember crewmembers : ships.getCrew() ){
			if(crewmembers.getLastName().toUpperCase().equals(caplastname.toUpperCase())){
				tmpship=ships;
			}
		}
	}
return tmpship;
}

	/**
	 * Name: getStrshps()
	 * Descritpion: gets the array list of starships from the desired fleet
	 * @return
	 */
	public ArrayList<Starship> getStrshps() {
		return strshps;
	}


	/**
	 * Name: setName()
	 * Description: sets the name of the desired fleet
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Name: setStrshps()
	 * Description: sets the passed in array list of starships to be apart of the fleet
	 * @param strshps
	 */
	public void setStrshps(ArrayList<Starship> strshps) {
		this.strshps = strshps;
	}


	/**
	 * Name: AddToFleet()
	 * Description: adds a single starship to the current fleet
	 * @param s
	 */
	public void AddToFleet(Starship s){
		strshps.add(s);
	}


	/**5
	 * Name:RemoveFromFleet()
	 * Description: takes in a string representing the starships registry and removes it from the fleet
	 * @param registry
	 */
	public void RemoveFromFleet(String registry){
		for(int i=0; i<strshps.size();i++) {
			if (strshps.get(i).equals(registry)) {
				strshps.remove(i);
				break;
			}
		}
	}

	/**
	 * Name:fleetSize((
	 * Description: gets the fleets size
	 * @return
	 */
	public int fleetSize(){
		return strshps.size();
	}

	/**
	 * Name: printStarships()
	 * Description: prints the entirety of the fleets current starships in string form.
	 * @return
	 */
	private String printStarships(){
		String ships ="\n";
		for(int i=0;i<strshps.size();i++){
			ships+= "     "+ strshps.get(i).toString()+"\n";
		}
		//System.out.println("---------------"+ships.charAt(0));
		return ships;
	}


	/**
	 * Name: loadData()
	 * Description: loads in the data from the two files and creates out starships and crew memebers to populate
	 *               our fleet! Also formats the info so everything looks nice
	 * @param fleet
	 * @param personnel
	 * @throws IOException
	 */
	public void loadData(File fleet, File personnel) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fleet));
		BufferedReader reader2 = new BufferedReader(new FileReader(personnel));
		String line="",imagepath="",shipName ="",registryShip="",shipClass="",name="",position="",rank="",species="",registryCrew="";

		while((line =reader.readLine()) != null ) {

			Scanner scanLine = new Scanner(line);
			scanLine.useDelimiter(",");
			shipName =  scanLine.next();
			registryShip = scanLine.next();
			shipClass = scanLine.next();
			strshps.add(new Starship(shipName,registryShip,shipClass));

		}
		line ="";
		while((line =reader2.readLine()) != null){
			Scanner scanLine = new Scanner(line);
			scanLine.useDelimiter(",");
			name = scanLine.next();
			position = scanLine.next();
			rank = scanLine.next();
			registryCrew = scanLine.next();
			species = scanLine.next();

			for(int i=0;i< strshps.size();i++){
				if(strshps.get(i).getRegistry().equals(registryCrew)) {
					strshps.get(i).AddToCrew(new CrewMember(name,position,rank,species));
					break;
				}
			}
		}
	}

	public void setImages() {
//		String path="";
		for(int i=0;i< strshps.size();i++){
			for (int j=0;j<strshps.get(i).getCrew().size();j++) {
				if (new File("data/" + strshps.get(i).getCrew().get(j).getLastName().toLowerCase() + ".jpg").exists()){
					strshps.get(i).getCrew().get(j).setImage(new Image(new File("data/" + strshps.get(i).getCrew().get(j).getLastName().toLowerCase() + ".jpg").toURI().toString()));
				}
			}
		}
	}

	/**
	 * Name:toString()
	 * Description: returns the string representation of a fleet
	 * @return
	 */
	@Override
	public String toString() {
		return "Fleet Name: " + name +"\nStarShips:"+ printStarships();
	}
}