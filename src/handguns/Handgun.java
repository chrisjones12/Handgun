package handguns;

public class Handgun {
  State emptyState;
  State notEmptyState;
  State state = emptyState;
  
  int numberOfRoundsRemaining;
  public static final int MAX_ROUNDS = 8;
  
  public Handgun(int rounds) {
    emptyState = new EmptyState(this);
    notEmptyState = new NotEmptyState(this);
    if (rounds > MAX_ROUNDS) {
      this.numberOfRoundsRemaining = MAX_ROUNDS;
      state = notEmptyState;
    }
    else if (rounds <= 0){
      state = emptyState;
    }
    else {
      this.numberOfRoundsRemaining = rounds;
      state = notEmptyState;
    }
  }
  
  public void shoot() {
    state.shoot();
  }
  
  public void reload() {
    state.reload();
  }
  
  public void unload() {
    state.unload();
  }
  
  public int getRounds() {
    return this.numberOfRoundsRemaining;
  }
  
  public void setRounds(int i) {
    if (i > MAX_ROUNDS || numberOfRoundsRemaining + i > MAX_ROUNDS) {
      numberOfRoundsRemaining = MAX_ROUNDS;
    }
    else if (i <= 0) {
      numberOfRoundsRemaining = 0;
      setState(emptyState);
    }
    else {
      numberOfRoundsRemaining += i;
    }
  }
  
  public void decrementRoundsPerShot() {
    numberOfRoundsRemaining--;
  }
  
  void setState(State state) {
    this.state = state;
  }

  State getNotEmptyState() {
    return notEmptyState;
  }
  
  State getEmptyState() {
    numberOfRoundsRemaining = 0;
    return emptyState;
  }
}
