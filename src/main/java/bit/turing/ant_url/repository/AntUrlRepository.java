package bit.turing.ant_url.repository;

import bit.turing.ant_url.entity.AntUrl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AntUrlRepository extends CrudRepository<AntUrl, Long> {
    public Optional<AntUrl> findByDomainAndAlias(String domain, String alias);

    public  Optional<AntUrl> findByAlias(String alias);
}
