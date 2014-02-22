package org.droidplanner.drone.variables.missionD.waypoints;

import java.util.List;

import org.droidplanner.drone.variables.mission.Mission;
import org.droidplanner.drone.variables.missionD.MissionItemD;
import org.droidplanner.helpers.units.Altitude;

import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.enums.MAV_CMD;
import com.google.android.gms.maps.model.LatLng;

public abstract class LoiterTimeD extends LoiterD {

	double time;

	public LoiterTimeD(MissionItemD item) {
		super(item);
	}

	public LoiterTimeD(Mission mission, LatLng coord, Altitude altitude) {
		super(mission, coord, altitude);
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public List<msg_mission_item> packMissionItem() {
		List<msg_mission_item> list = super.packMissionItem();
		msg_mission_item mavMsg = list.get(0);
		mavMsg.command = MAV_CMD.MAV_CMD_NAV_LOITER_TIME;
		mavMsg.param1 = (float) getTime();
		return list;
	}

	@Override
	public void unpackMAVMessage(msg_mission_item mavMsg) {
		super.unpackMAVMessage(mavMsg);
		setTime(mavMsg.param1);
	}

}