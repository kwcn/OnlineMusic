package kwcn.master.activity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;

import kwcn.master.fragment.BaseFragment;
import kwcn.master.myapplication.R;

public class MainActivity extends Activity implements BaseFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseFragment baseFragment = BaseFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.fragment, baseFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
