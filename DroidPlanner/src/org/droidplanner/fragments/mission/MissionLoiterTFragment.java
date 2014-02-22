package org.droidplanner.fragments.mission;

import org.droidplanner.R;
import org.droidplanner.drone.variables.missionD.waypoints.LoiterD;
import org.droidplanner.drone.variables.missionD.waypoints.LoiterTimeD;
import org.droidplanner.widgets.SeekBarWithText.SeekBarWithText;
import org.droidplanner.widgets.SeekBarWithText.SeekBarWithText.OnTextSeekBarChangedListener;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MissionLoiterTFragment extends MissionDetailFragment implements
		OnTextSeekBarChangedListener, OnCheckedChangeListener {

	private SeekBarWithText altitudeSeekBar;
	private SeekBarWithText loiterTimeSeekBar;

	@Override
	protected int getResource() {
		return R.layout.fragment_editor_detail_loitert;
	}


	@Override
	protected void setupViews(View view) {
		super.setupViews(view);
		typeSpinner.setSelection(commandAdapter.getPosition(MissionItemTypes.LOITERT));

		LoiterTimeD item = (LoiterTimeD) this.item;

		altitudeSeekBar = (SeekBarWithText) view.findViewById(R.id.altitudeView);
		altitudeSeekBar.setValue(item.getAltitude().valueInMeters());
		altitudeSeekBar.setOnChangedListener(this);

		loiterTimeSeekBar = (SeekBarWithText) view.findViewById(R.id.loiterTime);
		loiterTimeSeekBar .setOnChangedListener(this);
		loiterTimeSeekBar.setValue(item.getTime());

	}

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		((LoiterD) item).setOrbitCCW(isChecked);
    }


	@Override
	public void onSeekBarChanged() {
		LoiterTimeD item = (LoiterTimeD) this.item;

		item.getAltitude().set(altitudeSeekBar.getValue());
		item.setTime(loiterTimeSeekBar.getValue());
		//item.setOrbitalRadius(loiterRadiusSeekBar.getValue());
		//item.setYawAngle(yawSeekBar.getValue());
	}


}
