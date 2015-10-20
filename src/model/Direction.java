package model;

public enum Direction {
	NORTHWEST(+1,-1), NORTH(0,-1), NORTHEAST(-1,-1), 
	EAST(+1,0), 					WEST(-1,0),
	SOUTHEAST(+1,+1), SOUTH(0,+1), SOUTHWEST(-1,+1);
	
	private final int x,y;
	
	Direction(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	/**
	 * Returns the Direction towards a Point, relative to an arbitrary origin (0,0).
	 * Uses standard coordinate system for displays, so positive y's point south, positive x's point east.
	 * 
	 * (currently only returns NORTH/SOUTH/EAST/WEST)
	 */
	public static Direction towardsPoint(double x, double y) {
		if ( Math.abs(x) > Math.abs(y) ) {
			// point is farther away horizontally than vertically
			if ( x > 0 ) {
				return WEST;
			} else if ( x < 0 ) {
				return EAST;
			}
		} else if ( Math.abs(y) > Math.abs(x) ) {
			// point is farther away vertically than horizontally
			if ( y > 0 ) {
				return SOUTH;
			} else if ( y < 0 ) {
				return NORTH;
			}
		}
		return null;
	}
}
