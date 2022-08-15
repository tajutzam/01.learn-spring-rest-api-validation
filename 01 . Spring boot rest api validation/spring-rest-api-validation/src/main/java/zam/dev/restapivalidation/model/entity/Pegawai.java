package zam.dev.restapivalidation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pegawai {

    @Id
    @Column(name = "id" , length = 8 , unique = true )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Email(message = "Mohon isikan email dengan benar")
    @Column(name = "email_pegawai" , length = 64 )
    @Getter
    @Setter
    private String email;

    @NotBlank(message = "Nama lengkap tidak boleh kosong")
    @Size(min = 6 , message = "Nama lengkap harus lebih dari 6")
    @Column(name = "nama_lengkap" , length = 64)
    @Getter
    @Setter
    private String nama_lengkap;

    @NotBlank(message = "Alamat  tidak boleh kosong")
    @Size(min = 6 , message = "Nama lengkap harus lebih dari 6")
    @Column(name = "alamat" , length = 222)
    @Getter
    @Setter
    private String alamat;
    @NotBlank(message = "Jenis Kelamin tidak boleh kosong")
    @Column(name = "jk" )
    @Getter
    @Setter
    private String jenisKelamin;

    @NotNull(message = "umur tidak boleh null")
    @Column(name = "umur")
    @Getter
    @Setter
    private int umur;

    @Override
    public String toString() {
        return "Pegawai{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nama_lengkap='" + nama_lengkap + '\'' +
                ", alamat='" + alamat + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", umur=" + umur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pegawai pegawai = (Pegawai) o;
        return id == pegawai.id && umur == pegawai.umur && Objects.equals(email, pegawai.email) && Objects.equals(nama_lengkap, pegawai.nama_lengkap) && Objects.equals(alamat, pegawai.alamat) && Objects.equals(jenisKelamin, pegawai.jenisKelamin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nama_lengkap, alamat, jenisKelamin, umur);
    }
}
