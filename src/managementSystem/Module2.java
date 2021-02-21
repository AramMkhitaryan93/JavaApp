package managementSystem;

public class Module2 {
    public void chemistry(){
        String[] chem ={"Organic chemistry","Bio chemistry","Inorganic chemistry","Polymer chemistry"};
        System.out.println("The box available in chemistry department are as follow");
        for (String s : chem) {
            System.out.println(s);
        }
    }
    public void physics(){
        String[] phy ={"Mechanics","Dynamics","Solid physics","Astro physics","Electromagnetism"};
        System.out.println("The box available in Physics department are as follow");
        for (String s : phy) {
            System.out.println(s);
        }
    }
    public  void biology(){
        String[] bio={"Zoology","Botany","Medical Science","xyz","abs"};
        System.out.println("The box available in Biology department are as follow");
        for (String s : bio) {
            System.out.println(s);
        }
    }
}
