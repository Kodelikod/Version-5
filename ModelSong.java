package Model;

public class ModelSong {


     private int nr;
     private String name;

     public ModelSong(String name, int nr) {
          this.name = name;
          this.nr = nr;

     }

     public String getName() { return name; }
     public void setName(String name) { this.name = name; }
     public int getNr() { return nr; }
     public void setNr(int nr) { this.nr = nr; }

     @Override
     public String toString() {
          return "ModelSong{" +
                  "nr=" + nr +
                  ", name='" + name + '\'' +
                  '}';
     }

}
