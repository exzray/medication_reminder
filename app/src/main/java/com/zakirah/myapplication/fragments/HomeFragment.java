package com.zakirah.myapplication.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver;
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager;
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendar;
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter;
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager;
import com.michalsvec.singlerowcalendar.utils.DateUtils;
import com.zakirah.myapplication.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    // declare views
    private SingleRowCalendar mv_calendar;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initialize views
        mv_calendar = view.findViewById(R.id.calendar);

        setupCalendar();

    }

    private void setupCalendar() {
        mv_calendar.setCalendarViewManager(new MyCalendarViewManager());
        mv_calendar.setCalendarChangesObserver(new CalendarChangesObserver() {
            @Override
            public void whenWeekMonthYearChanged(String s, String s1, String s2, String s3, Date date) {

            }

            @Override
            public void whenSelectionChanged(boolean b, int i, Date date) {

            }

            @Override
            public void whenCalendarScrolled(int i, int i1) {

            }

            @Override
            public void whenSelectionRestored() {

            }

            @Override
            public void whenSelectionRefreshed() {

            }
        });
        mv_calendar.setCalendarSelectionManager(new CalendarSelectionManager() {
            @Override
            public boolean canBeItemSelected(int i, Date date) {
                return true;
            }
        });
        mv_calendar.init();
    }

    class MyCalendarViewManager implements CalendarViewManager {

        @Override
        public void bindDataToCalendarView(SingleRowCalendarAdapter.CalendarViewHolder calendarViewHolder, Date date, int i, boolean b) {
            TextView text_date = calendarViewHolder.itemView.findViewById(R.id.text_date);
            TextView text_day = calendarViewHolder.itemView.findViewById(R.id.text_day);

            DateUtils utils = DateUtils.INSTANCE;

            text_date.setText(utils.getDayNumber(date));
            text_day.setText(utils.getDay3LettersName(date));
        }

        @Override
        public int setCalendarViewResourceId(int i, Date date, boolean b) {

            if (b) return R.layout.item_calendar_selected;

            return R.layout.item_calendar;
        }
    }
}
