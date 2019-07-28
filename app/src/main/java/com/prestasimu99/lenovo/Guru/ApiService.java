package com.prestasimu99.lenovo.Guru;


import com.prestasimu99.lenovo.Guru.model_statusguru.ResponseGetStatusGuru;
import com.prestasimu99.lenovo.Guru.modelhome2.ResultChangeStatus;
import com.prestasimu99.lenovo.Guru.modelsignup.ResponseSignUp;
import com.prestasimu99.lenovo.Guru.modelhome.ResultRequest;
import com.prestasimu99.lenovo.Guru.notif.MyResponse;
import com.prestasimu99.lenovo.Guru.notif.Sender;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {


//    @Multipart
//    @POST("shipmentstatus/update/{id}?key=54b031e20b682fb14ae1e136bd7736c9")
//    fun uploadFile(@Part foto: MultipartBody.Part,
//                   @Part("tanggal") tanggal: RequestBody,
//                   @Part("namaPenerima") nama: RequestBody,
//                   @Part("status") status: RequestBody,
//                   @Part("keterangan") keterangan: RequestBody,
//                   @Path("id") id: String): Observable<ResponseShipment>
//
@FormUrlEncoded
@POST("changeStatus")
Call<ResultChangeStatus> actionChangeStatus(@Field("userID") String userid,@Field("status") int i);

    @FormUrlEncoded
    @POST("list_request_guru")
    Call<ResultRequest> actionRequest(@Field("id") String id);

    @Multipart
    @POST("register_guru")
    Call<ResponseSignUp> actionSINGup(
                                      @Part("name") String name,
                                      @Part("email") String email,
                                      @Part("password") String password,
                                      @Part("alamat") String alamat,
                                      @Part("kelurahan") String kelurahan,
                                      @Part("kec") String kec,
                                      @Part("kab") String kab,
                                      @Part("hp") String hp,
                                      @Part("jk") String jk);
    @FormUrlEncoded
    @POST("new_register_guru")
    Call<ResponseSignUp> actionSignUpGuru(
//
//            $name = $this->input->post('name');
//    $email = $this->input->post('email');
//    $password = $this->input->post('password');
//    $hp = $this->input->post('hp');
//    $jk = $this->input->post('jk');
//    $user_alamat = $this->input->post('user_alamat');
//    $user_kota = $this->input->post('user_kota');
//    $jp = $this->input->post('user_jp');
//    $namabank = $this->input->post('namabank');
//    $namapemilik = $this->input->post('namapemilik');
//    $norek = $this->input->post('norek');
//    $this->db->where('user_email',$email);
            @Field("name") String name,
            @Field("password") String password,
            @Field("hp") String hp,
            @Field("email") String email,
            @Field("jk") String jk,
//            @Field("mapel1") String mapel1,
//            @Field("mapel2") String mapel2,
//            @Field("mapel3") String mapel3,
            @Field("user_alamat") String user_alamat,
            @Field("user_kota") String user_kota,
//            @Field("iqra_umum") String iqra_umum,
//            @Field("alquran_umum") String alquran_umum,
//            @Field("hafalquran_umum") String hafalquran_umum,
//            @Field("arab_sd") String arab_sd,
//            @Field("arab_smp") String arab_smp,
//            @Field("arab_sma") String arab_sma,
//            @Field("inggris_sd") String inggris_sd,
//            @Field("inggris_smp") String inggris_smp,
//            @Field("inggris_sma") String inggris_sma,
//            @Field("tematik_sd") String tematik_sd,
//            @Field("biologi_smp") String biologi_smp,
//            @Field("matematika_smp") String matematika_smp,
//            @Field("fisika_smp") String fisika_smp,
//            @Field("biologi_sma") String biologi_sma,
//            @Field("kimia_sma") String kimia_sma,
//            @Field("fisika_sma") String fisika_sma,
//            @Field("matematika_sma") String matematika_sma,
//            @Field("facial_umum") String facial_umum,
//            @Field("barber_umum") String barber_umum,
//            @Field("jahit_umum") String jahit_umum,
//            @Field("makeup_umum") String makeup_umum,
            @Field("namabank") String namabank,
            @Field("namapemilik") String namapemilik,
            @Field("norek") String norek,
@Field("user_jp") String jp
//            @Field("bindo_smp") String bindo_smp,
//            @Field("ips_smp") String ips_smp,
//            @Field("bindo_sma") String bindo_sma,
//            @Field("sejarah_sma") String sejarah_sma,
//            @Field("geografi_sma") String geografi_sma,
//            @Field("sosiologi_sma") String sosiologi_sma,
//            @Field("astronomi_sma") String astronomi_sma




    );



    @FormUrlEncoded
    @POST("insert_request")
    Call<ResponseSignUp> actionRequest(@Field("iduser") String iduser,
                                       @Field("idjp") String idjp,
                                       @Field("lat") String lat,
                                       @Field("lon") String lon,
                                       @Field("alamat") String alamat,
                                       @Field("ket") String ket);

    @GET("packet_private")
    Call<ResponsePacket> actionGetPacket();



    @FormUrlEncoded
    @POST("login_guru")
    Call<ResponseLogin> actionLogin(
            @Field("hp") String hp,
            @Field("password") String password
    );

    @Headers({
            "content-Type:application/json",
            "Authorization:key=AAAAwzWoZ10:APA91bEdht2eUUBUu1tScPwGLIJ6ViAjiAJLUuEQB17wxwmUgteigdDoaJ6ejaG6W2Dabfm0Xu7GQRZgYSdgQ2HPo5Ie_hTDR4adrFnMS_QI1Ntg_Wftl1BeKAE7Egk6aWdxsJUkfNS1"
    })
    @POST("fcm/send")

    Call<MyResponse> sendNotif(@Body Sender sender);


    @FormUrlEncoded
    @POST("getStatusTeacher")
    Call<ResponseGetStatusGuru> getStatusGuru(@Field("id") String iduser);

}
