package application.model;

/**
 * Name: CrewMember
 * Description: Defines what it means to be a crew member for the United Federation of Planets
 */
public class CrewMember {

  /*
    A CrewMember object must have:
    A name (i.e. James T. Kirk)
    A position (i.e. Commanding Officer)
    A rank (i.e. Captain)
    A species (i.e. Human)
    The remaining design of the model of this app is up to you - you may add other model classes if you find it necessary.
    */

    private String name = "";
    private String position="";
    private String rank="";
    private String species="";

    /**
     * Name: CrewMember()
     * Description: constructor sets the values needed to define a crew member
     *
     * @param n
     * @param p
     * @param r
     * @param s
     */
    public CrewMember(String n, String p, String r, String s){
        name=n;
        position=p;
        rank=r;
        species=s;
    }

    /**
     * Name:getName()
     * Description: gets the name of the desired crew member
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name:getPosition()
     * Description: gets the position of the desired crew member
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * Name:getRank()
     * Description: gets the rank of the desired crew member
     * @return
     */
    public String getRank() {
        return rank;
    }

    /**
     * Name:getSpecies()
     * Description: gets the species of the desired crew member
     * @return
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Name:setName()
     * Description: sets the name of the desired crew member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name:setPosition()
     * Description: sets the position of the desired crew member
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Name:setRank()
     * Description: sets the rank of the desired crew member
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Name:setSpecies()
     * Description: sets the species of the desired crew member
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Name: toString()
     * Description: returns the string representation of a crew member
     * @return
     */
    @Override
    public String toString() {
        return "-  "+rank+ " " + name + ", "+ position +" ("+ species +")";
    }

}
