package bit.turing.ant_url.service;

import bit.turing.ant_url.entity.AntUrl;
import bit.turing.ant_url.repository.AntUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AntUrlService {

    @Autowired
    private AntUrlRepository antUrlRepository;

    public AntUrl create(AntUrl antUrl){
        AntUrl antUrlSaved = antUrlRepository.save(antUrl);

        return antUrlSaved;
    }

    public Optional<AntUrl> findByDomainAndAlias(String domain, String alias){
        return antUrlRepository.findByDomainAndAlias(domain, alias);
    }

    public Optional<AntUrl> findByAlias(String alias){
        return  antUrlRepository.findByAlias(alias);
    }
}
