package BattleofKings;

public class Platoon {
	
	private  String unitType;
    private  int count;

    public Platoon(String unitType, int count) {
        this.unitType = unitType;
        this.count = count;
    }

    public String getUnitType() {
        return unitType;
    }

    public int getCount() {
        return count;
    }

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
	    return unitType + "#" + count;
	}

    
    
	
	
	

}
