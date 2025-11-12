package mx.edu.utez.carrazosv3.data.remote

import mx.edu.utez.carrazosv3.data.model.Carro
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface CarroService {

    // GET - Obtener todos los carros
    @GET("carro")
    fun getCarros(): Call<List<Carro>>

    // DELETE - Eliminar un carro
    @DELETE("carro/{id}")
    fun deleteCarro(@Path("id") id: Int): Call<Void>

    // POST - Crear carro con multipart (nombre, descripcion, precio, imagen)
    @Multipart
    @POST("carro")
    fun createCarro(
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part("precio") precio: RequestBody,
        @Part imagen: MultipartBody.Part?
    ): Call<Carro>

    // PUT - Actualizar carro con multipart
    @Multipart
    @PUT("carro/{id}")
    fun updateCarro(
        @Path("id") id: Int,
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part("precio") precio: RequestBody,
        @Part imagen: MultipartBody.Part?
    ): Call<Carro>
}
