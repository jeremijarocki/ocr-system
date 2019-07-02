package pl.jeremijarocki.ocrsystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicRepository extends CrudRepository<Graphic, Long> {
}
