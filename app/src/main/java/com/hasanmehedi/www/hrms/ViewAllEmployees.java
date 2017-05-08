package com.hasanmehedi.www.hrms;

/**
 * Created by 16030003 on 5/8/2017.
 */

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.hasanmehedi.www.hrms.Model.Employee;
import com.hasanmehedi.www.hrms.DB.EmployeeOperations;

import java.util.List;

public class ViewAllEmployees extends ListActivity{

    private EmployeeOperations employeeOps;
    List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_view_all_employees);
        employeeOps = new EmployeeOperations(this);
        employeeOps.open();
        employees = employeeOps.getAllEmployees();
        employeeOps.close();
        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, employees);
        setListAdapter(adapter);
    }
}
