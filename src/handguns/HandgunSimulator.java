package handguns;

public class HandgunSimulator {

  public static void main(String[] args) {
    Handgun handgun = new Handgun(8);
    
    handgun.shoot();
    handgun.reload();
    for (int i = 0; i < 10; i++) {
      handgun.shoot();
      //if (handgun.getRounds() == 0) {
        //handgun.reload();
      //}
    }
    //handgun.unload();
    /*
    handgun.reload();
    handgun.shoot();
    handgun.unload();
    
    handgun.reload();
    handgun.unload();
    handgun.shoot();*/
  }
}
