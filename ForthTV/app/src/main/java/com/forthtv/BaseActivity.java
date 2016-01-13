package com.forthtv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by cuongvo on 12/30/15.
 */
public class BaseActivity extends AppCompatActivity {
    public enum ActivityType{
        ACTIVITY_MAIN(1, R.layout.activity_main, "MAIN_ACTIVITY"),
        ACTIVITY_AUTHENTICATION(2, R.layout.activity_auth, "ACTIVITY_AUTHENTICATION"),
        ACTIVITY_LANDING(3, R.layout.activity_landing, "ACTIVITY_LANDING"),
        ACTIVITY_RECORD(4, R.layout.actvity_record, "ACTIVITY_RECORD"),
        ACTIVITY_SEARCH(5, R.layout.activity_search, "ACTIVITY_SEARCH");

        private int id;
        private int layoutId;
        private String name;

        ActivityType(int id, int layoutId, String name){
            this.id = id;
            this.layoutId = layoutId;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLayoutId() {
            return layoutId;
        }

        public void setLayoutId(int layoutId) {
            this.layoutId = layoutId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    protected ActivityType mActivityType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mActivityType.getLayoutId());

        updateStatusBarView();
    }

    public void openFragment(BaseFragment baseFragment, int contentLayoutId, BaseFragment.FragmentType fragmentType){
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(contentLayoutId, baseFragment, fragmentType.getName());
        fragmentTransaction.commit();
    }

    public void updateStatusBarView(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    public void displayProgress(){

    }

    public void displayToast(Activity activity, String message){
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    public void hideSoftKeyboard(EditText input) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }

}
