package edu.birzeit.projectpart1.ui.ProfileAgency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import edu.birzeit.projectpart1.DataBaseHelper;
import edu.birzeit.projectpart1.MainActivity;
import edu.birzeit.projectpart1.R;
import edu.birzeit.projectpart1.UserRentingAgency;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileAgencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileAgencyFragment extends Fragment {
    EditText name;
    EditText email;
    EditText password;
    EditText country;
    EditText city;
    EditText phone;
    Button update;
    Button confirm;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileAgencyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileAgencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileAgencyFragment newInstance(String param1, String param2) {
        ProfileAgencyFragment fragment = new ProfileAgencyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_agency, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        name=getActivity().findViewById(R.id.agencyname_profile);
        email=getActivity().findViewById(R.id.email_profile);
        password=getActivity().findViewById(R.id.password_profile);
        country=getActivity().findViewById(R.id.country_profile);
        city=getActivity().findViewById(R.id.city_profile);
        phone=getActivity().findViewById(R.id.phone_profile);
        update=getActivity().findViewById(R.id.submit_profile);
        confirm=getActivity().findViewById(R.id.confirm_profile);
        DataBaseHelper dataBaseHelper =new
                DataBaseHelper(getActivity(), MainActivity.nameDatabase,null,1);
        UserRentingAgency ua=dataBaseHelper.getProfile_Agency();
        name.setText(ua.getName());
        email.setText(ua.getEmail());
        password.setText(ua.getPassword());
        country.setText(ua.getCountry());
        city.setText(ua.getCity());
        phone.setText(ua.getPhoneNumber());
        setVisble_AllEdit(false);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisble_AllEdit(true);
                confirm.setEnabled(true);




            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisble_AllEdit(false);
                confirm.setEnabled(false);
                UserRentingAgency ua=new UserRentingAgency();
                ua.setEmail(email.getText().toString());
                ua.setName(name.getText().toString());
                ua.setPassword(password.getText().toString());
                ua.setCity(city.getText().toString());
                ua.setCountry(country.getText().toString());
                ua.setPhoneNumber(phone.getText().toString());
                dataBaseHelper.Update_Ageny(ua);



            }
        });




    }
    public void setVisble_AllEdit(boolean state){
        name.setEnabled(state);
        email.setEnabled(state);
        password.setEnabled(state);
        country.setEnabled(state);
        city.setEnabled(state);
        phone.setEnabled(state);
    }
}