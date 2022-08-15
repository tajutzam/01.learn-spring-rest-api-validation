package zam.dev.restapivalidation.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zam.dev.restapivalidation.model.entity.Pegawai;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai , Long> {


}
