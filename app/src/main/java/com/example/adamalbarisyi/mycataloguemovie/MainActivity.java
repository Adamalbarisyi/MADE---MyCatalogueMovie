package com.example.adamalbarisyi.mycataloguemovie;


import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<MovieItems>> {

    ListView lvMovie;
    MovieAdapter adapter;
    EditText editMovieSearch;
    Button btnSearch;

    static final String EXTRAS_MOVIE = "EXTRAS_MOVIE";
    private ArrayList<MovieItems>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        adapter.notifyDataSetChanged();

        editMovieSearch =findViewById(R.id.edt_movie_search);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(myListener);
        lvMovie = findViewById(R.id.lv_movie);
        lvMovie.setAdapter(adapter);

        String movie = editMovieSearch.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRAS_MOVIE,movie);
        getSupportLoaderManager().initLoader(0,bundle,this);

    }


    @Override
    public Loader<ArrayList<MovieItems>> onCreateLoader(int id,  Bundle args) {
        String movieSearch = " ";
        if (args != null){
            movieSearch = args.getString(EXTRAS_MOVIE);
        }
        return new MyAsyncTaskLoader( this,movieSearch);
    }


    @Override
    public void onLoadFinished( Loader<ArrayList<MovieItems>> loader, ArrayList<MovieItems> data) {
        adapter.setData(data);
    }

    @Override
    public void onLoaderReset( Loader<ArrayList<MovieItems>> loader) {
        adapter.setData(null);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String movie = editMovieSearch.getText().toString();
            if (TextUtils.isEmpty(movie))
                return;
            Bundle bundle = new Bundle();
            bundle.putString(EXTRAS_MOVIE,movie);
            getSupportLoaderManager().restartLoader(0,bundle,MainActivity.this);
        }
    };

}
