package model.actor;

/**
 * Strength determines weapon damage and inventory size Agility determines
 * weapon hit chance and speed Intellect determines spell damage and literacy
 */
class ActorStats {

	private int strength, agility, intellect;

	public ActorStats() {
		strength = 10;
		agility = 10;
		intellect = 10;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

}