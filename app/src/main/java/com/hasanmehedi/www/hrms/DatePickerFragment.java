package com.hasanmehedi.www.hrms;

/**
 * Created by 16030003 on 5/8/2017.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.lang.reflect.AccessibleObject;
import java.util.Date;
import java.util.GregorianCalendar;
public class DatePickerFragment extends DialogFragment {

    private DatePicker datePicker;
    private static final int REQUEST_DATE = 1;

    public static final String EXTRA_DATE =
            "com.androidtutorialpoint.date";



    public interface DateDialogListener {
        void onFinishDialog(Date date);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_date,null);

        datePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);


        return new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int year = datePicker.getYear();
                                int mon = datePicker.getMonth();
                                int day = datePicker.getDayOfMonth();
                                Date date = new GregorianCalendar(year,mon,day).getTime();
                                DateDialogListener activity = (DateDialogListener) getActivity();
                                activity.onFinishDialog(date);
                                dismiss();
                            }
                        })
                .create();
    }


}
