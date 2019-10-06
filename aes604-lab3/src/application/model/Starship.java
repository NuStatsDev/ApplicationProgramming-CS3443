package application.model;

import java.util.ArrayList;

/**
 * Name: Starship
 * Description: defines what it means to be a starship.... to initialize you need atleast a name,registry, and starship class!
 */
public class Starship{

    /*
    A Starship object must have:
    A name (i.e. USS Enterprise)
    A registry (i.e. NCC-1701-A)
    A class of starship (i.e. Constitution)
    An ArrayList of CrewMember objects
    There is no limit on the number of crew members on board a starship. (They said it's "bigger on the inside", whatever that means..)
     */

    protected ArrayList<CrewMember> crew = new ArrayList<CrewMember>();
    protected String name="";
    protected String registry="";
    protected String starshipClass="";

    /**
     * Name: Starship()
     * Description: Constructor of the starship, only takes in 3 params.. name registry and starship class
     * @param n
     * @param r
     * @param sC
     * @param cM
     */
    public Starship(String n,String r, String sC,ArrayList<CrewMember> cM){
        name=n;
        registry=r;
        starshipClass=sC;
        crew=cM;
    }

    /**
     * Name: Starship()
     * Description: Constructor of the starship, only takes in 3 params.. name registry and starship class
     * @param n
     * @param r
     * @param sC
     */
    public Starship(String n,String r, String sC){
        name=n;
        registry=r;
        starshipClass=sC;
    }

    /**
     * Name: getName()
     * Description: gets the name of the desired starship
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name: getCrew()
     * Description: gets the array list of the crew members for the desired starship
     * @return
     */
    public ArrayList<CrewMember> getCrew() {
        return crew;
    }

    /**
     * Name: getRegistry()
     * Description: gets the registry value of the desired starship
     * @return
     */
    public String getRegistry() {
        return registry;
    }

    /**
     * Name:getStarshipClass()
     * Description: gets the class of the desired starship
     * @return
     */
    public String getStarshipClass() {
        return starshipClass;
    }

    /**
     * Name: setName()
     * Description: sets the name of the desired starship
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name: setCrew()
     * Description: sets the crew of the desired starship depending on the users input.
     * @param crew
     */
    public void setCrew(ArrayList<CrewMember> crew) {
        this.crew = crew;
    }

    /**
     * Name: setRegistry()
     * Description: sets the registry string of the desired starship
     * @param registry
     */
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /**
     * Name:setStarshipClass()
     * Description: sets the class of the desired starship
     * @param starshipClass
     */
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    /**
     * Name: AddToCrew()
     * Description: adds a crew member to the current starship
     * @param crewMember
     */
    public void AddToCrew(CrewMember crewMember){
        crew.add(crewMember);
    }

    /**
     * Name: RemoveFromCrew()
     * Description: Removes a crew member depending on what name the user passed the function
     * @param name
     */
    public void RemoveFromCrew(String name){
        for(int i=0; i<crew.size();i++) {
            if (crew.get(i).getName().equals(name)) {
                crew.remove(i);
                break;
            }
        }
    }

    /**
     * Name: PrintCrew()
     * Description: Prints the toString representation of the crew
     * @return
     */
    public String PrintCrew(){
        String crewDetails = "\n";
        for(int i =0; i < crew.size();i++){
            crewDetails+= "      "+crew.get(i).toString() +"\n";
        }
        return crewDetails;
    }

    /**
     * Name: toString()
     * Description: returns the string representation of the desired starship
     * @return
     */
    @Override
    public String toString() {
        return  name +" [" + registry+ "], " + "Class: "+ starshipClass+ " Crew: "+ getCrew().size() + PrintCrew();
    }
}