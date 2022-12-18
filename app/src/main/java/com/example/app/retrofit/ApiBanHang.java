package com.example.app.retrofit;

import com.example.app.model.DanhSachLuatModel;
import com.example.app.model.LoaiSPModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("getLuaChon.php")
    Observable<LoaiSPModel> getLoaiSP();

    @GET("getLuat.php")
    Observable<DanhSachLuatModel> getDanhSachLuat();

    @POST("getDieu.php")
    @FormUrlEncoded
    Observable<DanhSachLuatModel> getDieuLuat(
            @Field("page") int page,
            @Field("dieu") int dieu
    );



//    @GET("getSPMoi.php")
//    Observable<SanPhamMoiModel> getSPMoi();
//
//    @POST("chitiet.php")
//    @FormUrlEncoded
//    Observable<SanPhamMoiModel> getSP(
//            @Field("page") int page,
//            @Field("loai") int loai
//    );

}
