package org.droidplanner.services.android.impl.core.drone.variables;

import com.MAVLink.enums.MAV_TYPE;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public enum ApmModes {
	FIXED_WING_MANUAL (0,"Manual",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_CIRCLE (1,"Circle",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_STABILIZE (2,"Stabilize",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_TRAINING (3,"Training",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_ACRO(4, "Acro", MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_FLY_BY_WIRE_A (5,"FBW A",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_FLY_BY_WIRE_B (6,"FBW B",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_CRUISE(7, "Cruise", MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_AUTOTUNE(8, "AutoTune", MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_AUTO (10,"Auto",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_RTL (11,"RTL",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_LOITER (12,"Loiter",MAV_TYPE.MAV_TYPE_FIXED_WING),
	FIXED_WING_GUIDED (15,"Guided",MAV_TYPE.MAV_TYPE_FIXED_WING),

	ROTOR_STABILIZE(0, "Stabilize", MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_ACRO(1,"Acro", MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_ALT_HOLD(2, "Alt Hold",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_AUTO(3, "Auto",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_GUIDED(4, "Guided",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_LOITER(5, "Loiter",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_RTL(6, "RTL",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_CIRCLE(7, "Circle",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_LAND(9, "Land",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_TOY(11, "Drift",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_SPORT(13, "Sport",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_AUTOTUNE(15, "Autotune",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_POSHOLD(16, "PosHold",MAV_TYPE.MAV_TYPE_QUADROTOR),
	ROTOR_BRAKE(17,"Brake",MAV_TYPE.MAV_TYPE_QUADROTOR),

	ROVER_MANUAL(0, "MANUAL", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_LEARNING(2, "LEARNING", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_STEERING(3, "STEERING", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_HOLD(4, "HOLD", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_AUTO(10, "AUTO", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_RTL(11, "RTL", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_GUIDED(15, "GUIDED", MAV_TYPE.MAV_TYPE_GROUND_ROVER),
	ROVER_INITIALIZING(16, "INITIALIZING", MAV_TYPE.MAV_TYPE_GROUND_ROVER),

	VTOL_STABILIZE(17, "QSTABILIZE", MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR),
	VTOL_HOVER(18, "QHOVER", MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR),
	VTOL_LOITER(19, "QLOITER", MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR),
	VTOL_LAND(20, "QLAND", MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR),
	VTOL_RTL(21, "QRTL", MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR),

	UNKNOWN(-1, "Unknown", MAV_TYPE.MAV_TYPE_GENERIC);

	private final long number;
    private final String name;
	private final int type;

	ApmModes(long number,String name, int type){
		this.number = number;
		this.name = name;
		this.type = type;
	}

	public long getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public static ApmModes getMode(long i, int type) {
        if (isCopter(type)) {
            type = MAV_TYPE.MAV_TYPE_QUADROTOR;
        } else if(isVtol(type)) {
        	type = MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR;
		}

		for (ApmModes mode : ApmModes.values()) {
			if (i == mode.getNumber() && type == mode.getType()) {
				return mode;
			}
		}
		return UNKNOWN;
	}

	public static ApmModes getModeNoType(long i) {
		for (ApmModes mode : ApmModes.values()) {
			if (i == mode.getNumber()) {
				return mode;
			}
		}
		return UNKNOWN;
	}

	public static ApmModes getMode(String str, int type) {
        if (isCopter(type)) {
            type = MAV_TYPE.MAV_TYPE_QUADROTOR;
        } else if(isVtol(type)) {
        	type = MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR;
		}

		for (ApmModes mode : ApmModes.values()) {
			if (str.equals(mode.getName()) && type == mode.getType()) {
				return mode;
			}
		}
		return UNKNOWN;
	}

	public static List<ApmModes> getModeList(int type) {
		List<ApmModes> modeList = new ArrayList<ApmModes>();

		if (isCopter(type)) {
			type = MAV_TYPE.MAV_TYPE_QUADROTOR;
		} else if(isVtol(type)) {
			type = MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR;
		}

		for (ApmModes mode : ApmModes.values()) {
			if (mode.getType() == type) {
				modeList.add(mode);
			}
		}
		return modeList;
	}

	public static boolean isValid(ApmModes mode) {
		return mode!=ApmModes.UNKNOWN;
	}


	public static boolean isCopter(int type){
		switch (type) {
		case MAV_TYPE.MAV_TYPE_TRICOPTER:
		case MAV_TYPE.MAV_TYPE_QUADROTOR:
		case MAV_TYPE.MAV_TYPE_HEXAROTOR:
		case MAV_TYPE.MAV_TYPE_OCTOROTOR:
		case MAV_TYPE.MAV_TYPE_HELICOPTER:
			return true;

		default:
			return false;
		}
	}
	
	public static boolean isVtol(int type) {
		Timber.d("isVtol(%d)", type);

		switch(type) {
			case MAV_TYPE.MAV_TYPE_VTOL_DUOROTOR:
			case MAV_TYPE.MAV_TYPE_VTOL_QUADROTOR:
			case MAV_TYPE.MAV_TYPE_VTOL_TILTROTOR:
			case MAV_TYPE.MAV_TYPE_VTOL_RESERVED2:
			case MAV_TYPE.MAV_TYPE_VTOL_RESERVED3:
			case MAV_TYPE.MAV_TYPE_VTOL_RESERVED4:
			case MAV_TYPE.MAV_TYPE_VTOL_RESERVED5:
				return true;
			default:
				return false;
		}
	}
}
