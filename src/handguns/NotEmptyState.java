package handguns;

public class NotEmptyState implements State {
  Handgun handgun;
  
  public NotEmptyState(Handgun handgun) {
    this.handgun = handgun;
  }
  
  @Override
  public void shoot() {
    System.out.println("Shooting your gun..");
    handgun.decrementRoundsPerShot();
    if (handgun.getRounds() > 1) {
      System.out.println("You have " + handgun.getRounds() + " bullets remaining.");
    }
    else if (handgun.getRounds() == 1) {
      System.out.println("You have " + handgun.getRounds() + " bullet remaining.");
    }
    else {
      handgun.setState(handgun.getEmptyState());
    }
  }
  
  @Override
  public void reload() {
    System.out.println("Reloading your gun..");
    int reloadRounds = Handgun.MAX_ROUNDS - handgun.getRounds();
    handgun.setRounds(reloadRounds);
    System.out.println("After reloading, you have " + handgun.getRounds() + " bullets remaining.");
  }
  
  @Override
  public void unload() {
    System.out.println("Unloading your gun..");
    handgun.setState(handgun.getEmptyState());
    System.out.println("After unloading, you have " + handgun.getRounds() + " bullets remaining.");
  }
}
