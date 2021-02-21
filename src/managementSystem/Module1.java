package managementSystem;

public class Module1 {
    String name, fName, uni_id, uid;
    int sem;

    public void getData(String name, String fName, String uni_id, String uid, Integer sem) {
       this.name=name;
       this.fName=fName;
       this.uni_id=uni_id;
       this.uid=uid;
       this.sem=sem;
    }
    public void setData(){
       System.out.println("Students name: "+name);
       System.out.println("Students father name: "+fName);
       System.out.println("Students uni_id: "+uni_id);
       System.out.println("Students uid: "+uid);
       System.out.println("Students sem: "+sem);
    }
}
