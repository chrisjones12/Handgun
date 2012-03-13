package handguns;

public class EmptyState implements State {
  Handgun handgun;
  
  public EmptyState(Handgun handgun) {
    this.handgun = handgun;
  }
  
  @Override
  public void shoot() {
    System.out.println("Click.. Looks like you're out of ammo.");
  }
  
  @Override
  public void reload() {
    System.out.println("Reloading your gun..");
    int reloadRounds = Handgun.MAX_ROUNDS - handgun.getRounds();
    handgun.setRounds(reloadRounds);
    System.out.println("After reloading, you have " + handgun.getRounds() + " bullets remaining.");
    handgun.setState(handgun.getNotEmptyState());
  }
  
  @Override
  public void unload() {
    System.out.println("You cannot unload your gun if you have no rounds left.");
  }
}
