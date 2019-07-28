package com.prestasimu99.lenovo.Guru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.prestasimu99.lenovo.Guru.model_statusguru.DataItemStatusGuru;
import com.prestasimu99.lenovo.Guru.model_statusguru.ResponseGetStatusGuru;
import com.prestasimu99.lenovo.Guru.modelhome2.ResultChangeStatus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    @BindView(R.id.profilName)
    TextView profilName;
    @BindView(R.id.profilEmail)
    TextView profilEmail;
    @BindView(R.id.profilHp)
    TextView profilHp;
    @BindView(R.id.profilBtn)
    Button profilBtn;
    Unbinder unbinder;
    @BindView(R.id.profilSwitchStatus)
    Switch profilSwitchStatus;


    private SessionManager sesi;

    //tambahan untuk cek status
    String nStatusGuru;

    Boolean nStatusGuru12 ;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        sesi = new SessionManager(getActivity());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nStatusGuru12 = false;
        cekStatusGuru();

        profilEmail.setText("Email :" + sesi.getEmail());
        profilHp.setText("Handphone : " + sesi.getPhone());
        profilName.setText("Nama : " + sesi.getNama());


        profilSwitchStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(nStatusGuru12){
                  //  Toast.makeText(getContext(), "true", Toast.LENGTH_SHORT).show();
                    changeStatus(1);
                }
                else{

                    changeStatus(2);
                   // Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();



                }



            }
        });


    }

    private void cekStatusGuru() {





        //Toast.makeText(getContext(), sesi.getIdUser(), Toast.LENGTH_SHORT).show();

        NetworkClient.service.getStatusGuru(sesi.getIdUser()).enqueue(new Callback<ResponseGetStatusGuru>() {
            @Override
            public void onResponse(Call<ResponseGetStatusGuru> call, Response<ResponseGetStatusGuru> response) {

                if (response.isSuccessful()) {
                    boolean status = response.body().isStatus();
                    String pesan = response.body().getPesan();

                    List<DataItemStatusGuru> data = response.body().getData();
                    if (status) {
                        nStatusGuru = data.get(0).getUserStatus();

                        if (nStatusGuru.equalsIgnoreCase("1")) {
                            profilSwitchStatus.setChecked(false);
                            nStatusGuru12 = false ;
                            Toast.makeText(getContext(), "Anda sedang OFFLINE", Toast.LENGTH_SHORT).show();
                        } else {
                            profilSwitchStatus.setChecked(true);

                            nStatusGuru12 = true ;
                            Toast.makeText(getContext(), "Anda sedang ONLINE", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
//                if(response.body().isStatus()){
//                    nStatusGuru =
//                }

            }

            @Override
            public void onFailure(Call<ResponseGetStatusGuru> call, Throwable t) {

            }
        });
    }

    private void changeStatus(int i) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.show();

        NetworkClient.service.actionChangeStatus(sesi.getIdUser(),i).enqueue(new Callback<ResultChangeStatus>() {
            @Override
            public void onResponse(Call<ResultChangeStatus> call, Response<ResultChangeStatus> response) {

                if (response.body().isStatus()) {
                    progressDialog.dismiss();
//                    Toast.makeText(getContext(), "update berhasil", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResultChangeStatus> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.profilBtn)
    public void onViewClicked() {
        sesi.logout();
        startActivity(new Intent(getContext(), LoginActivity.class));
        getActivity().finish();
    }
}