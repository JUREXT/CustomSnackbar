package com.example.jure_lokovsek.materialdesignsnackbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Context mContext;
    private Button mButtonSnackBar1, mButtonSnackBar2, mButtonSnackBar3, mButtonSnackBar4, mButtonSnackBar5;
    /// for multiline snackbar
    private View mSnackbarView;
    private Snackbar mSnackbar;
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mToolbar = findViewById(R.id.toolbar);
        mButtonSnackBar1 = findViewById(R.id.button_snck1);
        mButtonSnackBar2 = findViewById(R.id.button_snck2);
        mButtonSnackBar3 = findViewById(R.id.button_snck3);
        mButtonSnackBar4 = findViewById(R.id.button_snck4);
        mButtonSnackBar5 = findViewById(R.id.button_snck5);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        enableClicks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void enableClicks() {
        mButtonSnackBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar 1", Snackbar.LENGTH_SHORT).show();
            }
        });

        mButtonSnackBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar with click", Snackbar.LENGTH_SHORT)
                        .setAction("YourAction", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO: Your Action
                                Toast.makeText(mContext, "Just Toast", Toast.LENGTH_LONG).show();
                            }
                 }).show();
            }
        });

        mButtonSnackBar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar with click && Color text", Snackbar.LENGTH_SHORT)
                        .setAction("YourAction", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO: Your Action
                                Toast.makeText(mContext, "Just Toast", Toast.LENGTH_LONG).show();
                            }
                        }).setActionTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
                        .show();
            }
        });

        mButtonSnackBar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar = Snackbar.make(view, "This is a multiline Snackbar. It supports longer message for your feedback if needed :) This is a longer message!",Snackbar.LENGTH_LONG).setDuration(Snackbar.LENGTH_LONG);
                mSnackbar.setAction("YourAction", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "Toast from Snackbar.setAction method", Toast.LENGTH_LONG).show();
                    }
                });
                mSnackbar.setActionTextColor(getResources().getColor(R.color.green));
                mSnackbarView = mSnackbar.getView();
                TextView tv = mSnackbarView.findViewById(android.support.design.R.id.snackbar_text);
                tv.setMaxLines(3);
                tv.setBackgroundColor(getResources().getColor(R.color.green));
                tv.setTextColor(getResources().getColor(R.color.black));
                // the whole message is clickable
                mSnackbarView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO: Your Action
                        Toast.makeText(mContext, "Toast from SnackbarView.setOnClickListener method", Toast.LENGTH_LONG).show();
                    }
                });
                mSnackbar.show();
            }
        });

        mButtonSnackBar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomSnackbar snackbar = CustomSnackbar.Builder(MainActivity.this)
                        .layout(R.layout.layout_snackbar)
                        .background(R.color.colorPrimary)
                        .duration(CustomSnackbar.LENGTH.LONG)
                        .swipe(true)
                        .build(view);
                snackbar.show();

                TextView textView = snackbar.getContentView().findViewById(R.id.snackbar_text);
                textView.setText("Happy coding!!!");
                textView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                ///
                Button btn = snackbar.getContentView().findViewById(R.id.snackbar_btn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO: Your Action
                        Toast.makeText(mContext, "Toast from Custom Snackbar :) ", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });




    }

}
