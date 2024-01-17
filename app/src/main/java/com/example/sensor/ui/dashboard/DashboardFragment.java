package com.example.sensor.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sensor.R;
import com.example.sensor.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TextView touchInfo ,touchInfo2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        touchInfo = view.findViewById(R.id.touch_info);
        touchInfo2 = view.findViewById(R.id.touch_info2);

        // Set the title of the action bar
        getActivity().setTitle("B6301095");
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pointerCount = event.getPointerCount();
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < pointerCount; i++) {
                    int pointerId = event.getPointerId(i);
                    float x = event.getX(i);
                    float y = event.getY(i);
                    int action = event.getActionMasked();
                    int actionIndex = event.getActionIndex();

                    builder.append("Pointer ID: ").append(pointerId)
                            .append(" Action: ").append(actionToString(action))
                            .append(" Action Index: ").append(actionIndex)
                            .append("\nX: ").append(x)
                            .append(" Y: ").append(y)
                            .append("\n\n");
                }
                touchInfo2.setText("");

                touchInfo.setText(builder.toString());
                return true;
            }
        });

        return view;
    }
    private String actionToString(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN: return "Down";
            case MotionEvent.ACTION_MOVE: return "Move";
            case MotionEvent.ACTION_UP: return "Up";

            default: return "";
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}