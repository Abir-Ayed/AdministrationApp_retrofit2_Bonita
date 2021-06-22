package com.example.appretrofit.Api;

import com.example.appretrofit.Model.User;

import java.util.Map;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.example.appretrofit.Model.Processus;
public interface UserService {


   @FormUrlEncoded
   @POST("loginservice")
   Call<ResponseBody> loginUser(
           @Field("username") String username,
           @Field("password") String password
   );
   @FormUrlEncoded
   @POST("loginservice")
   Call<ResponseBody> loginUser(
           @FieldMap Map<String, String> map
   );

   @GET("API/system/session/unusedId")
   Call<User> getUserId();

   @GET("API/bpm/process")
   Call<List<Processus>> getProcessus (
           @Query(value="p", encoded = true) String p,
           @Query(value="c", encoded = true) String c,
           @Query(value="o", encoded = true) String o,
           @Query(value="f", encoded = true) String activationState,
           @Query(value="f", encoded = true) String IdUser
   );

}
