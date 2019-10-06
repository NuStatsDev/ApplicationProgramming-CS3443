package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Fleet
 * Description: Class that defines what a fleet is, every fleet needs a name and holds Starships that hold crew members
 */
public class
Fleet {
    /*
        To initialized, a Fleet object must have a name. In addition,
        every Fleet has an ArrayList of Starship objects.
        The Fleet will be the access point for the data in the remainder of the app.
        The controller will call on methods in the Fleet class to access
        starship names, crew member information, and to load data in the files.
     */

    private ArrayList<Starship> strshps = new ArrayList<Starship>();
    private String name="";


    /**
     * Name: Fleet()
     * Description: Contructor that takes in the needed name to set the name for the fleet
     * @param name
     */
    public Fleet(String name) throws IOException {
        this.name=name;
        File f = new File("src/data/fleet.csv");
        File p = new File("src/data/personnel.csv");
        loadData(f,p);

    }


    /**
     * Name: getName()
     * Description: gets the name of the desired fleet
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name:getStarships()
     * Descriptio: Gets all the starships with the same name and returns a string representation of them
     * @param usrinput
     * @return
     */

    public String getRequestedStarships(String usrinput){
        String StarShips="";
        for(int i=0;i<strshps.size();i++){
            if(strshps.get(i).name.equals(usrinput)){
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
    private void loadData(File fleet, File personnel) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fleet));
        BufferedReader reader2 = new BufferedReader(new FileReader(personnel));

        String shipName ="",reg="",classShip="",line="",name="",position="",rank="",species="",regi="";
        Scanner scanFleet = new Scanner(fleet);

        while((line =reader.readLine()) != null ) {
            Scanner scanLine = new Scanner(line);
            scanLine.useDelimiter(",");
            shipName =  scanLine.next();
            reg = scanLine.next();
            classShip = scanLine.next();
           strshps.add(new Starship(shipName,reg,classShip));
        }
        scanFleet.close();

        line ="";
        while((line =reader2.readLine()) != null){

            Scanner scanPersonnel = new Scanner(line);
            scanPersonnel.useDelimiter(",");
            name = scanPersonnel.next();
            position = scanPersonnel.next();
            rank = scanPersonnel.next();
            regi = scanPersonnel.next();
            species = scanPersonnel.nextLine();

            if(species.charAt(0) == ',') {
                species = species.substring(1);
            }

            for(int i=0;i< strshps.size();i++){
                if(strshps.get(i).getRegistry().equals(regi)) {
                    strshps.get(i).AddToCrew(new CrewMember(name,position,rank,species));
                    break;
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
