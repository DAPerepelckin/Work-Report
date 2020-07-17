package com.dapstd.workreport.ui.work_zone;

import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.dapstd.workreport.R;
import com.dapstd.workreport.ui.work_zone.weekview.WeekView;
import com.dapstd.workreport.ui.work_zone.weekview.WeekViewEvent;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static com.dapstd.workreport.ui.work_zone.weekview.WeekViewUtil.today;


public class WorkZoneFragment extends Fragment {


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_work_zone, container, false);

        Button add = root.findViewById(R.id.add_work_button);
        WeekView mWeekView = root.findViewById(R.id.weekView);
        MaterialCalendarView calendarView = root.findViewById(R.id.calendarView);


        calendarView.setSelectedDate(LocalDate.now());
        mWeekView.setSelectedDay(today());


        mWeekView.setMonthChangeListener((newYear, newMonth) -> {
            List<WeekViewEvent> events = new ArrayList<>();
            return events;
        });

        mWeekView.setXScrollingSpeed(0);

        mWeekView.setEmptyViewClickListener(time -> {
            if(mWeekView.getNumberOfVisibleDays()==7) {
                mWeekView.setNumberOfVisibleDays(1);
            }else{
                mWeekView.setNumberOfVisibleDays(7);
            }
            mWeekView.goToDate(time);
            mWeekView.setSelectedDay(time);
            calendarView.setSelectedDate(LocalDate.of(time.getWeekYear(),time.getTime().getMonth()+1,time.getTime().getDate()));
        });


        calendarView.setOnDateChangedListener((widget, date, selected) -> {
            if (calendarView.getCalendarMode() != CalendarMode.WEEKS) {
                calendarView.state().edit().setCalendarDisplayMode(CalendarMode.WEEKS).commit();
                mWeekView.setVisibility(View.VISIBLE);
            }
            mWeekView.goToDate(date.getDate());
            mWeekView.setSelectedDay(new GregorianCalendar(date.getYear(), date.getMonth() - 1, date.getDay()));
        });

        calendarView.setOnTitleClickListener(v -> {
            if(calendarView.getCalendarMode()==CalendarMode.WEEKS) {
                calendarView.state().edit().setCalendarDisplayMode(CalendarMode.MONTHS).commit();
                mWeekView.setVisibility(View.INVISIBLE);
            }else{
                calendarView.state().edit().setCalendarDisplayMode(CalendarMode.WEEKS).commit();
                mWeekView.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnMonthChangedListener((widget, date) -> {
            mWeekView.goToDate(date.getDate());
        });

        return root;
    }
}
